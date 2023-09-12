from flask import Flask, render_template, request, flash, redirect
from . import ingrediente_blueprint

from google.protobuf.json_format import MessageToJson

import os,grpc

from app.proto.ingrediente_pb2 import Ingrediente

from app.proto.ingrediente_pb2_grpc import IngredientesServiceStub

import logging

logger = logging.getLogger(__name__)

@ingrediente_blueprint.route("/ingrediente/<int:id>", methods=["GET", "POST"])
def ingredienteById(id):
    logger.info("/ingredienteById &s"+str(id))
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = IngredientesServiceStub(channel)
        response = stub.TraerIngrediente(Ingrediente(id=id)) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)

@ingrediente_blueprint.route("/ingredientes",methods = ['GET'])
def findAll():
    logger.info("/ingredientes")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = IngredientesServiceStub(channel)
        response = stub.FindAll(Ingrediente()) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)
