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
        response = stub.AddSeguidos(Seguido(user=User(id=int(user_id)),seguido=User(id=int(request.form["seguidoId"]))))
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