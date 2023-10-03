from flask import Flask, render_template, request, flash, redirect,json,session,jsonify
from . import comentario_blueprint

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

from app.proto.comentario_pb2 import Comentario
from app.proto.receta_pb2 import Receta

from app.proto.comentario_pb2_grpc import ComentariosServiceStub

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


@comentario_blueprint.route("/comentario", methods=['GET'])
def comentario():
    # Crear un consumidor Kafka
    consumer = KafkaConsumer(
        'comentario',  # Nombre del tema al que suscribirse
        **kafka_config
    )
    
    comentarios_guardados = []
    
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
                    # Decodifica el JSON en cada mensaje
                    mensaje_decodificado = json.loads(mensaje_decodificado)
                    
                    receta_comentada = mensaje_decodificado['recetaComentada']
                    usuario_comentario = mensaje_decodificado['usuarioComentario']
                    comentario = mensaje_decodificado['comentario']
            
                    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
                        stub = ComentariosServiceStub(channel)
                        response = stub.GuardarComentario(
                            Comentario(
                                recetaComentada=receta_comentada,
                                usuarioComentario=usuario_comentario,
                                comentario=comentario,
                                receta=Receta(tituloReceta=receta_comentada)
                            )
                        )
                        comentario_guardado = {"comentario": MessageToJson(response)}
                        comentarios_guardados.append(comentario_guardado)
                    
            time.sleep(5)
                   
    finally:
        consumer.close()

    # Devuelve la lista de comentarios como JSON
    return jsonify({"comentariosGuardados": comentarios_guardados})



