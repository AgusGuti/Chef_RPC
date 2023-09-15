from flask import Flask, render_template, request, flash, redirect,json,session
from . import receta_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

from app.proto.categoria_pb2 import Categoria
from app.proto.user_pb2 import User
from app.proto.ingrediente_pb2 import Ingrediente
from app.proto.receta_pb2 import Receta

from app.proto.receta_pb2_grpc import RecetasServiceStub

from logging.config import dictConfig
from google.protobuf.json_format import MessageToDict, MessageToJson
from google.protobuf.timestamp_pb2 import Timestamp
import datetime

logger = logging.getLogger(__name__)

@receta_blueprint.route("/recetas",methods = ['GET'])
def recetas():
    logger.info("/recetas")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.FindAll(Receta())
        recetas = response.receta
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
            return redirect('/recetas')

@receta_blueprint.route("/receta/findAll",methods = ['GET'])
def findAll():
    logger.info("/receta/findAll")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.FindAll(Receta()) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)

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
    ingredientes_seleccionados = request.form.getlist("ingredientes")
    
    ingredientes = []
    for ingrediente in ingredientes_seleccionados:
        ingrediente_obj = Ingrediente(id=int(ingrediente))
        ingredientes.append(ingrediente_obj)
    
    user_id=session['user_id']
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.modificarReceta(
            Receta(ingredientes=ingredientes,user=User(id=int(user_id)),categoria=Categoria(id=int(request.form["categoria"])),tituloReceta=request.form["tituloReceta"],
                descripcion=request.form["descripcion"],pasos=request.form["pasos"],tiempoPreparacion=int(request.form["tiempoPreparacion"]),foto1=request.form["foto1"],
                foto2=request.form["foto2"],foto3=request.form["foto3"],foto4=request.form["foto4"],
                foto5=request.form["foto5"]))
        print("Greeter client received: " + str(response))    
        receta={"receta":MessageToJson(response)}
        logger.info("receta modificada %s",receta)
        if receta["receta"]=="{}":
            flash('Error al intentar modificar la receta','danger')
            return redirect('/modificarReceta')
        else:
            flash('Receta modificada exitosamente!','success')
            return redirect('/recetas')

    

