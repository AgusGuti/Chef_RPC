from flask import Flask, render_template, request, flash, redirect,session, json
from . import user_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

from app.proto.user_pb2 import User

from app.proto.user_pb2_grpc import UsersServiceStub

import logging

logger = logging.getLogger(__name__)

@user_blueprint.route("/autenticar", methods=['POST'])
def autenticar():
    logger.info("/autenticar  %s",request.form['username'])
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.ValidarCredenciales(User(nombre=request.form['username'],email=request.form['username'],clave=request.form['password']))
        user=MessageToJson(response)
    
    logger.info("user : %s",response.nombre)
    
    if user=="{}":
        flash('Usuario y/o clave incorrectos','danger')
        return redirect('/')
    else:
        session['user_id']=response.id
        session['nombre']=response.nombre
        session['apellido']=response.apellido
        session['email']=response.email
        session['fotoPerfil']=response.fotoPerfil
        return render_template('index.html', nombre=response.nombre)

@user_blueprint.route("/registrar", methods=['POST'])
def registrarUser():
    logger.info("/registrar")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.AddUser(User(nombre=request.form['nombre'],apellido=request.form['apellido'],email=request.form['email'],clave=request.form['clave'], fotoPerfil=request.form['fotoPerfil']))
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

    logger.info("user_id: %d",session['user_id'])
    logger.info("nombre: %s",session['nombre'])
    logger.info("apellido: %s",session['apellido'])
    logger.info("email: %s",session['email'])
    logger.info("fotoPerfil: %s",session['fotoPerfil'])


    return render_template('myprofile.html', 
                user_id=session['user_id'],
                nombre=session['nombre'],
                apellido=session['apellido'],
                email=session['email'],
                fotoPerfil=session['fotoPerfil'])


@user_blueprint.route("/seguidos",methods = ['GET'])
def seguidos():
    logger.info("/seguidos")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.TraerSeguidos(User(id=session['user_id']))
    print("Greeter client received: " + str(response))
    seguidos = response.user
    return render_template('seguidos.html', seguidos = seguidos)

@user_blueprint.route("/seguidores",methods = ['GET'])
def seguidores():
    logger.info("/seguidores")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.TraerSeguidores(User(id=session['user_id']))
    print("Greeter client received: " + str(response))    
    seguidores = response.user
    return render_template('seguidores.html', seguidores = seguidores)

@user_blueprint.route("/logout",methods = ['GET'])
def logout():
    logger.info("/logout")
    session.pop('user_id', None)
    session.pop('nombre', None)
    session.pop('apellido', None)
    session.pop('email', None)
    session.pop('fotoPerfil', None)
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
