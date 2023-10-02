from flask import Flask, render_template, request, flash, redirect,json,session,jsonify
from . import popularidadUser_blueprint

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

from app.proto.popularidadUser_pb2 import PopularidadUser
from app.proto.user_pb2 import User

from app.proto.popularidadUser_pb2_grpc import PopularidadUsersServiceStub

from logging.config import dictConfig
from google.protobuf.json_format import MessageToDict, MessageToJson
from google.protobuf.timestamp_pb2 import Timestamp


from kafka import KafkaConsumer

import time

logger = logging.getLogger(__name__)

# Configuración de Kafka
kafka_config = {
     'bootstrap_servers': os.getenv("SERVER-KAFKA-BROKER"),  # Dirección del broker de Kafka
     'group_id': 'test-consumer-group',       # ID del grupo de consumidores
     'auto_offset_reset': 'earliest',         # Comportamiento en caso de no tener un offset inicial
     #'max_poll_records': 5,                  # Máximo número de registros a recuperar en cada llamada a poll
     'enable_auto_commit': False              # Desactiva el auto commit
}


@popularidadUser_blueprint.route("/popularidadUsuario", methods=['GET'])
def popularidadUsuario():
    # Crear un consumidor Kafka
    consumer = KafkaConsumer(
        'popularidadUsuario',  # Nombre del tema al que suscribirse
        **kafka_config
    )
    lista_mensajes = []
    usuarios_guardados = []

    try:
        while True:
            mensaje = consumer.poll(60000)  # Obtener mensajes de Kafka
            if not mensaje:
                # Si no hay más mensajes, salir del ciclo
                break

            for msg in mensaje.values():
                for mensaje_info in msg:
                    mensaje_decodificado = mensaje_info.value.decode('utf-8')
                    logger.info(mensaje_decodificado)
                    # Decodifica el JSON en cada mensaje para eliminar las barras invertidas "\" en las URL
                    mensaje_decodificado = json.loads(mensaje_decodificado)
                    lista_mensajes.append({'popularidadUsuario': mensaje_decodificado})

            # Calcular la popularidad de los usuarios en función de los mensajes recibidos
            popularidad_usuarios = {}

            for mensaje in lista_mensajes:
                mensaje_decodificado = mensaje['popularidadUsuario']
                if 'nombreUsuario' in mensaje_decodificado and 'puntaje' in mensaje_decodificado:
                    nombre_usuario = mensaje_decodificado['nombreUsuario']
                    puntaje = mensaje_decodificado['puntaje']
                
                else:
                    logger.warning("Mensaje incompleto: {}".format(mensaje_decodificado))

                # Convertir puntaje a entero
                if puntaje == "+1":
                    puntaje_entero = 1
                elif puntaje == "-1":
                    puntaje_entero = -1
                else:
                    puntaje_entero = 0  # Manejar otros valores de puntaje como 0

                # Actualizar la suma de puntajes para el usuario
                if nombre_usuario in popularidad_usuarios:
                    popularidad_usuarios[nombre_usuario] += puntaje_entero
                else:
                    popularidad_usuarios[nombre_usuario] = puntaje_entero

            # Ordenar los usuarios por popularidad en orden descendente
            usuarios_ordenados = sorted(popularidad_usuarios.items(), key=lambda x: x[1], reverse=True)

            # Obtener los usuarios más populares (por ejemplo, los 5 mejores)
            usuarios_populares = usuarios_ordenados[:2]

            for nombre_usuario, puntaje_usuario in usuarios_populares:
                with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
                    stub = PopularidadUsersServiceStub(channel)
                    try:
                        response = stub.GuardarPopularidadUser(
                            PopularidadUser(nombreUsuario=nombre_usuario, puntaje=str(puntaje_usuario)))
                        logger.info("Popularidad " + MessageToJson(response))
                        usuario_guardado = {"popularidadUsuario": MessageToJson(response)}
                        usuarios_guardados.append(usuario_guardado)
                    except Exception as e:
                        logger.error("Error al llamar a gRPC: {}".format(str(e)))
            time.sleep(5)

    finally:
        consumer.close()

    # Devolver los usuarios populares como JSON
    return jsonify(usuarios_populares)