from flask import Flask, render_template, request, flash, redirect
from . import categoria_blueprint

from google.protobuf.json_format import MessageToJson

import os,grpc

from app.proto.categoria_pb2 import Categoria

from app.proto.categoria_pb2_grpc import CategoriasServiceStub

import logging

logger = logging.getLogger(__name__)

@categoria_blueprint.route("/categoria/<int:id>", methods=["GET", "POST"])
def categoriaById(id):
    logger.info("/categoriaById &s"+str(id))
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = CategoriasServiceStub(channel)
        response = stub.TraerCategoria(Categoria(id=id)) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)

@categoria_blueprint.route("/categorias",methods = ['GET'])
def findAll():
    logger.info("/categorias")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = CategoriasServiceStub(channel)
        response = stub.FindAll(Categoria()) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)
