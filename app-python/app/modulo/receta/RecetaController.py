from flask import Flask, render_template, request, flash, redirect,json,session
from . import receta_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

import threading

from app.proto.categoria_pb2 import Categoria
from app.proto.user_pb2 import User
from app.proto.ingrediente_pb2 import Ingrediente
from app.proto.receta_pb2 import Receta
from app.proto.favorito_pb2 import Favorito

from app.proto.receta_pb2_grpc import RecetasServiceStub
from app.proto.favorito_pb2_grpc import FavoritosServiceStub

from logging.config import dictConfig
from google.protobuf.json_format import MessageToDict, MessageToJson
from google.protobuf.timestamp_pb2 import Timestamp
import datetime


from app.modulo.consumer import kafka_consumer  # Importamos la función kafka_consumer


logger = logging.getLogger(__name__)


# Definición de la función para ejecutar el consumidor en un hilo
def run_kafka_consumer():
    logger.info("Entre aquiii")
    kafka_consumer.kafka_consumer()  # Llama a tu función de consumidor de Kafka aquí


@receta_blueprint.route("/misRecetas",methods = ['GET'])
def misRecetas():
    logger.info("/misRecetas")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel) 
        response = stub.FindAllById(Receta(user=User(id=session['user_id'])))
        recetas = response.receta        
    print("Greeter Recetas received: " + str(response))

    return render_template('abm-receta.html', recetas=recetas)


@receta_blueprint.route("/index",methods = ['GET'])
def index():
    logger.info("/index")
    return render_template('index.html',nombre=session['nombre'])


@receta_blueprint.route("/altaReceta",methods = ['GET'])
def nuevaReceta():
    logger.info("/altaReceta")
    return render_template('abm-receta.html')



@receta_blueprint.route("/altaReceta",methods = ['POST'])
def altaReceta():
    logger.info("/altaReceta")
    ingredientes_seleccionados = request.form.getlist("ingredientes")
    
    ingredientes = []
    for ingrediente in ingredientes_seleccionados:
        ingrediente_obj = Ingrediente(id=int(ingrediente))
        ingredientes.append(ingrediente_obj)
    
    user_id=session['user_id']
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.AddReceta(
            Receta(ingredientes=ingredientes,user=User(id=int(user_id)),categoria=Categoria(id=int(request.form["categoria"])),tituloReceta=request.form["tituloReceta"],
                descripcion=request.form["descripcion"],pasos=request.form["pasos"],tiempoPreparacion=int(request.form["tiempoPreparacion"]),foto1=request.form["foto1"],
                foto2=request.form["foto2"],foto3=request.form["foto3"],foto4=request.form["foto4"],
                foto5=request.form["foto5"]))
        print("Greeter client received: " + str(response))
        receta={"receta":MessageToJson(response)}
        logger.info("receta registrada %s",receta)
        if receta["receta"]=="{}":
            flash('Error al intentar cargar la receta','danger')
            return redirect('/altaReceta')
        else:
            flash('Receta creada exitosamente!','success')
            # Crear y iniciar un hilo para ejecutar el consumidor
            kafka_consumer_thread = threading.Thread(target=run_kafka_consumer)
            kafka_consumer_thread.start()
            return redirect('/misRecetas')
            

@receta_blueprint.route("/storyline",methods = ['GET'])
def findAll():
    logger.info("/receta/findAll")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.FindAll(Receta()) 
        recetas = response.receta 
    print("Greeter client received: " + str(response))    
    return render_template('storyline.html', recetas=recetas)


@receta_blueprint.route("/receta/findById/<int:id>",methods = ['GET'])
def findById(id):
    logger.info("/receta/findById %s",request.args.get('id'))
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.FindById(Receta(idReceta=id))
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)


@receta_blueprint.route("/modificarReceta",methods=['POST'])
def modificarReceta():
    logger.info("/modificarReceta")
    ingredientes_seleccionados = request.form.getlist("mod_ingredientes")
    
    ingredientes = []
    for ingrediente in ingredientes_seleccionados:
        ingrediente_obj = Ingrediente(id=int(ingrediente))
        ingredientes.append(ingrediente_obj)
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.ModificarReceta(
            Receta(idReceta=int(request.form["receta_id"]),ingredientes=ingredientes,categoria=Categoria(id=int(request.form["mod_categoria"])) ,tituloReceta=request.form["mod_tituloReceta"],
                descripcion=request.form["mod_descripcion"],pasos=request.form["mod_pasos"],tiempoPreparacion=int(request.form["mod_tiempoPreparacion"]),foto1=request.form["mod_foto1"],
                foto2=request.form["mod_foto2"],foto3=request.form["mod_foto3"],foto4=request.form["mod_foto4"],
                foto5=request.form["mod_foto5"]))
        print("Greeter client received: " + str(response))    
        receta={"receta":MessageToJson(response)}
        logger.info("response %s",response)
        logger.info("receta modificada %s",receta)
        if receta["receta"]=="{}":
            flash('Error al intentar modificar la receta','danger')
            return redirect('/modificarReceta')
        else:
            flash('Receta modificada exitosamente!','success')
            return redirect('/misRecetas')

