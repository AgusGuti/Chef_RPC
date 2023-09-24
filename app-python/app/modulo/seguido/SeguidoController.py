from flask import Flask, render_template, request, flash, redirect,json,session,jsonify
from . import seguido_blueprint 


from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

from app.proto.seguido_pb2 import Seguido
from app.proto.user_pb2 import User

from app.proto.seguido_pb2_grpc import SeguidosServiceStub

from logging.config import dictConfig
from google.protobuf.json_format import MessageToDict, MessageToJson
from google.protobuf.timestamp_pb2 import Timestamp
import datetime

logger = logging.getLogger(__name__)


@seguido_blueprint.route("/addSeguido", methods=['POST'])
def addSeguido():
    logger.info("/addSeguido")
    
    user_id=session['user_id']

    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = SeguidosServiceStub(channel)
        response = stub.AddSeguido(Seguido(user=User(id=int(user_id)),seguido=User(id=int(request.form["seguidoId"]))))
        print("Greeter client received: " + str(response))    
        seguido={"seguido":MessageToJson(response)}

        if seguido["seguido"]=="{}":
            return jsonify({"success": False, "message": "Error al intentar agregar seguido"})

        else:
            return jsonify({"success": True, "message": "Seguido agregado exitosamente!"})


@seguido_blueprint.route("/addSeguido",methods = ['GET'])
def seguido():
    logger.info("/addSeguido")
    return render_template('seguidos.html')


@seguido_blueprint.route("/eliminarSeguido/<int:id>",methods=["POST"])
def eliminarSeguido(id):
    logger.info("/eliminarSeguido %s"+str(id))
    user_id=session['user_id']
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = SeguidosServiceStub(channel)
        response = stub.DeleteSeguido(Seguido(id=id))
        print("Greeter client received: " + str(response))    
        seguido={"seguido":MessageToJson(response)}

        if seguido["seguido"]=="{}":
            return jsonify({"status": "error", "message": "Error al eliminar el seguido"})
        
        else:
            return jsonify({"status": "success", "message": "Seguido eliminado exitosamente!"})
    
    
@seguido_blueprint.route("/seguidos",methods = ['GET'])
def seguidos():
    logger.info("/seguidos")
    user_id=session['user_id']
    logging.info("Usuario ID: %s", user_id)
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = SeguidosServiceStub(channel)
        response = stub.FindAllById(Seguido(user=User(id=session['user_id'])))
        seguidos = response.seguido
    print("Greeter client received: " + str(response))
    
    return render_template('seguidos.html', seguidos = seguidos)

