from flask import Flask, render_template, request, flash, redirect
from . import receta_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

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
    return render_template('abm-receta.html')


@receta_blueprint.route("/index",methods = ['GET'])
def index():
    logger.info("/index")
    return render_template('index.html')


@receta_blueprint.route("/altaReceta",methods = ['GET'])
def nuevaReceta():
    logger.info("/altaReceta")
    return render_template('alta-receta.html')

@receta_blueprint.route("/altaReceta",methods = ['POST'])
def altaReceta():
    logger.info("/altaReceta")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        #response = stub.AddReceta(receta_pb2.Receta(tituloReceta=request.form['tituloReceta'],descripcion=request.form['descripcion'],pasos=request.form['pasos'],foto1=request.form['foto1']))
        fecha_actual = datetime.datetime.now()
        fecha_creacion = Timestamp()
        fecha_creacion.FromDatetime(fecha_actual)
        response = stub.AddReceta(Receta(idReceta=1,idUsuario=1,tituloReceta="este es el titulo",descripcion="esta es la descripcion",Categoria="Entrada",
                                                    pasos="estos son los pasos",fechaCreacion=fecha_creacion,ingredientes=["ingrediente111","ingrediente332"],tiempoPreparacion=14,foto1="Este es un urlfoto1",
                                                    foto2="Este es un urlfoto2",foto3="Este es un urlfoto3",foto4="Este es un urlfoto4",foto5="Este es un urlfoto5"))
        #response = stub.AddReceta(receta_pb2.Receta(tituloReceta=request.form['tituloReceta'],descripcion=request.form['descripcion'],pasos=request.form['pasos'],foto1=request.form['foto1']))
    print("Greeter client received: " + str(response))    
    receta={"receta":MessageToJson(response)}
    logger.info("receta registrada %s",receta)
    if receta["receta"]=="{}":
        flash('Error al intentar cargar la receta')
        return redirect('/altaReceta')
    else:
        flash('Receta creada exitosamente!')
        return redirect('/')