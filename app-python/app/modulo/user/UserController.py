from flask import Flask, render_template, request, flash, redirect
from . import user_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

from app.proto.user_pb2 import User

from app.proto.user_pb2_grpc import UsersServiceStub

import logging

logger = logging.getLogger(__name__)

@user_blueprint.route("/autenticar", methods=['POST'])
def autenticar():
    logger.info("/autenticar",request.form['username'])
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.ValidarCredenciales(User(nombre=request.form['username'],email=request.form['username'],clave=request.form['password']))
    print("Greeter client received: " + str(response))    
    user={"user":MessageToJson(response)}
    logger.info("user %s",user)
    if user["user"]=="{}":
        flash('Usuario y/o clave incorrectos','danger')
        return redirect('/')
    else:
        return render_template('index.html', user=request.form['username'])

@user_blueprint.route("/registrar", methods=['POST'])
def registrarUser():
    logger.info("/registrar")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.AddUser(User(nombre=request.form['nombre'],apellido=request.form['apellido'],email=request.form['email'],clave=request.form['clave']))
    print("Greeter client received: " + str(response))    
    user={"user":MessageToJson(response)}
    logger.info("user registrado %s",user)
    if user["user"]=="{}":
        flash('Error al intentar cargar el usuario','danger')
        return redirect('/registrar')
    else:
        flash('Usuario creado exitosamente!','success')
        return redirect('/')

@user_blueprint.route("/registrar",methods = ['GET'])
def registrar():
    logger.info("/registrar")
    return render_template('registrar.html')

@user_blueprint.route("/myprofile",methods = ['GET'])
def myprofile():
    logger.info("/myprofile")
    return render_template('myprofile.html')


@user_blueprint.route("/logout",methods = ['GET'])
def logout():
    logger.info("/logout")
    return redirect('/')


@user_blueprint.route("/user/<int:id>", methods=["GET", "POST"])
def userById(id):
    logger.info("/userById &s"+str(id))
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.TraerUser(User(id=id)) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)

@user_blueprint.route("/users",methods = ['GET'])
def findAll():
    logger.info("/users")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.FindAll(User()) 
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)
