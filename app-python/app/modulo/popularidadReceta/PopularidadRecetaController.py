from flask import Flask, render_template, request, flash, redirect,json,session,jsonify
from . import popularidadReceta_blueprint

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

from app.proto.popularidadReceta_pb2 import PopularidadReceta
from app.proto.receta_pb2 import Receta

from app.proto.popularidadReceta_pb2_grpc import PopularidadRecetasServiceStub

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


@popularidadReceta_blueprint.route("/popularidadReceta", methods=['GET'])
def popularidadReceta():
    # Crear un consumidor Kafka
    consumer = KafkaConsumer(
        'popularidadReceta',  # Nombre del tema al que suscribirse
        **kafka_config
    )
    lista_mensajes = []
    recetas_guardadas = []

    try:
        while True:  # Ciclo infinito
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
                    lista_mensajes.append({'popularidadReceta': mensaje_decodificado})

            # Calcular la popularidad de las recetas en función de los mensajes recibidos
            popularidad_recetas = {}
            contador_puntajes = {}

            for mensaje in lista_mensajes:
                mensaje_decodificado = mensaje['popularidadReceta']
                receta_id = mensaje_decodificado['idReceta']
                puntaje = mensaje_decodificado['puntaje']

                # Convertir puntaje a entero
                if puntaje == "+1":
                    puntaje_entero = 1
                elif puntaje == "-1":
                    puntaje_entero = -1
                elif puntaje in ("1", "2", "3", "4", "5"):
                    puntaje_entero = int(puntaje)
                else:
                    puntaje_entero = 0  # Manejar otros valores de puntaje como 0

                # Actualizar la suma de puntajes y el contador de puntajes para la receta
                if receta_id in popularidad_recetas:
                    popularidad_recetas[receta_id] += puntaje_entero
                    contador_puntajes[receta_id] += 1
                else:
                    popularidad_recetas[receta_id] = puntaje_entero
                    contador_puntajes[receta_id] = 1

            # Calcular la popularidad promedio de cada receta y guardarla en la base de datos
            with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
                stub = PopularidadRecetasServiceStub(channel)
                for receta_id, puntaje_sum in popularidad_recetas.items():
                    puntaje_promedio = puntaje_sum / contador_puntajes[receta_id]
                    response = stub.GuardarPopularidadReceta(
                        PopularidadReceta(receta=Receta(idReceta=int(receta_id)), puntaje=str(puntaje_promedio)))
                    logger.info("PopularidadReceta guardada: " + MessageToJson(response))
                    receta_guardada = {"popularidadReceta": MessageToJson(response)}
                    recetas_guardadas.append(receta_guardada)

            # Agregar una pausa
            time.sleep(5)

    finally:
        consumer.close()

    # Devolver las recetas guardadas como JSON
    return jsonify({"recetasGuardadas": recetas_guardadas})
