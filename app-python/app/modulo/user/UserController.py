
from flask import Flask, render_template, request, flash, redirect,session, json,jsonify
from . import user_blueprint 

import requests

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
        session['moderador']=response.moderador
        return redirect('/index')

@user_blueprint.route("/index",methods = ['GET'])
def index():
    logger.info("/index")
    return render_template('index.html',nombre=session['nombre'])

@user_blueprint.route("/registrar", methods=['POST'])
def registrarUser():
    logger.info("/registrar")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        response = stub.AddUser(User(nombre=request.form['nombre'],apellido=request.form['apellido'],email=request.form['email'],clave=request.form['clave'], fotoPerfil=request.form['fotoPerfil'], moderador=request.form['moderador']))
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = UsersServiceStub(channel)
        usuario = stub.FindByEmail(User(email= request.form['email']))

    logger.info("Usuario traido: " + str(usuario))

    crearUsuario(usuario.id, str(usuario.nombre))
    
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
    logger.info("moderador: %s",session['moderador'])


    return render_template('myprofile.html', 
                user_id=session['user_id'],
                nombre=session['nombre'],
                apellido=session['apellido'],
                email=session['email'],
                fotoPerfil=session['fotoPerfil'],
                moderador=session['moderador'])

@user_blueprint.route("/logout",methods = ['GET'])
def logout():
    logger.info("/logout")
    session.pop('user_id', None)
    session.pop('nombre', None)
    session.pop('apellido', None)
    session.pop('email', None)
    session.pop('fotoPerfil', None)
    session.pop('moderador', None)
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



@user_blueprint.route("/usuario/create", methods=["POST"])
def crearUsuario(id, name):

    print("Se llamo a CREAR USUARIO")
    
    # Imprimir los datos para depuración
    print("Creando Usuario:", id)
    print("Nombre:", name)

    # URL de la API externa donde deseas enviar el mensaje
    api_url = 'http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/usuario/create'

    # Datos del mensaje a enviar
    mensaje_data = {
        'id': id,
        'name': name
    }

    try:
        # Realizar la solicitud POST a la API externa
        response = requests.post(api_url, json=mensaje_data)

        if response.status_code == 200:
            # Si la API devuelve un código 200 (creado)
            print('Usuario creado con éxito')
        else:
            # Manejar otros códigos de respuesta si es necesario
            print('No se creo Usuario')
    except requests.exceptions.RequestException as e:
        # Manejar excepciones de solicitud (por ejemplo, problemas de red)
        print('Error al crear Usuario')
        print(e)