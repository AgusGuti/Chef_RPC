from flask import Flask, render_template, request, flash, redirect, session
from . import favorito_blueprint

from google.protobuf.json_format import MessageToJson

import os,grpc

from app.proto.favorito_pb2 import Favorito
from app.proto.user_pb2 import User
from app.proto.receta_pb2 import Receta

from app.proto.favorito_pb2_grpc import FavoritosServiceStub

import logging

logger = logging.getLogger(__name__)

from logging.config import dictConfig
from google.protobuf.json_format import MessageToDict, MessageToJson
from google.protobuf.timestamp_pb2 import Timestamp
import datetime


@favorito_blueprint.route("/addFavorito", methods=['POST'])
def addFavorito():
    logger.info("/addFavorito")
    
    user_id=session['user_id']

    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = FavoritosServiceStub(channel)
        response = stub.AddFavorito(Favorito(user=User(id=int(user_id)),receta = Receta(idReceta= int(request.form["recetaId"]))))
        print("Greeter client received: " + str(response))    
        favorito={"favorito":MessageToJson(response)}

        if favorito["favorito"]=="{}":
            flash('Error al intentar agregar favorito','danger')
            return redirect('/addFavorito')
        else:
            flash('Favorito agregado exitosamente!','success')
            return redirect('/favoritos')


@favorito_blueprint.route("/addFavorito",methods = ['GET'])
def favorito():
    logger.info("/addFavorito")
    return render_template('favoritos.html')



@favorito_blueprint.route("/favoritos",methods = ['GET'])
def favoritos():
    logger.info("/favoritos")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = FavoritosServiceStub(channel)
        response = stub.FindAllById(Favorito(user=User(id=session['user_id']))) 
        favoritos = response.favorito        
    print("Greeter client received: " + str(response))    
    return render_template('favoritos.html',favoritos=favoritos)

@favorito_blueprint.route("/eliminarFavorito/<int:id>",methods=["POST"])
def eliminarFavorito(id):
    logger.info("/eliminarFavorito %s"+str(id))
    user_id=session['user_id']
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = FavoritosServiceStub(channel)
        response = stub.DeleteFavorito(Favorito(id=id))
        print("Greeter client received: " + str(response))    
        favorito={"favorito":MessageToJson(response)}

        if favorito["favorito"]=="{}":
            flash('Error al eliminar el favorito','danger')
        else:
            flash('Favorito eliminado exitosamente!','success')
        
        return redirect('/favoritos')
