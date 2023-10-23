from flask import Flask, render_template, request, flash, redirect,json,session,jsonify
from . import receta_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

import threading

from app.proto.categoria_pb2 import Categoria
from app.proto.user_pb2 import User
from app.proto.ingrediente_pb2 import Ingrediente
from app.proto.receta_pb2 import Receta

from app.proto.denuncia_pb2 import Denuncia
from app.proto.motivo_pb2 import Motivo

from app.proto.favorito_pb2 import Favorito

from app.proto.receta_pb2_grpc import RecetasServiceStub
from app.proto.favorito_pb2_grpc import FavoritosServiceStub
from app.proto.user_pb2_grpc import UsersServiceStub

from logging.config import dictConfig
from google.protobuf.json_format import MessageToDict, MessageToJson
from google.protobuf.timestamp_pb2 import Timestamp
import datetime

from zeep import Client, helpers
import xml.etree.ElementTree as ET
import json


from kafka import KafkaConsumer


# URL del servicio WSDL - DENUNCIAS
wsdl_url_denuncias = 'http://localhost:8085/moddenuncias/denuncias.wsdl'

# Crear un cliente para el servicio SOAP - DENUNCIAS
clientDenuncias = Client(wsdl_url_denuncias)

# URL del servicio WSDL - RECETARIOS
wsdl_url_recetarios = 'http://localhost:8088/modrecetarios/recetarios.wsdl'

# Crear un cliente para el servicio SOAP - RECETARIOS
clientRecetarios = Client(wsdl_url_recetarios)




logger = logging.getLogger(__name__)

# Configuración de Kafka
kafka_config = {
     'bootstrap_servers': os.getenv("SERVER-KAFKA-BROKER"),  # Dirección del broker de Kafka
     'group_id': 'test-consumer-group',       # ID del grupo de consumidores
     'auto_offset_reset': 'earliest',         # Comportamiento en caso de no tener un offset inicial
     #'max_poll_records': 5,                  # Máximo número de registros a recuperar en cada llamada a poll
     'enable_auto_commit': False              # Desactiva el auto commit
}


@receta_blueprint.route("/agregarPuntaje",methods = ['POST'])
def agregarPuntaje():
    logger.info("/agregarPuntaje %s",request.form["puntaje"],request.form["idReceta"])

    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.AddPuntaje(
        Receta(idReceta=int(request.form["idReceta"]),puntaje=str(request.form["puntaje"])))
        receta={"receta":MessageToJson(response)}
    return redirect('/storyline')


@receta_blueprint.route("/agregarComentario",methods = ['POST'])
def agregarComentario():
    logger.info("/agregarComentario")
    
    user_id=session['user_id']
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.AddComentario(
            Receta(user=User(id=int(user_id)),tituloReceta=request.form["tituloReceta"],
                comentario=request.form["comentario"],idReceta=int(request.form["idReceta"])))
        receta={"receta":MessageToJson(response)}
    return redirect('/storyline')

        
@receta_blueprint.route("/novedades", methods=['GET'])
def novedades():
    # Crear un consumidor Kafka
    consumer = KafkaConsumer(
        'novedades',  # Nombre del tema al que suscribirse
        **kafka_config
    )

    lista_mensajes = []
    try:
        while len(lista_mensajes) < 5:  # Recibir solo los primeros 5 mensajes
            mensaje = consumer.poll(60000)  # Obtener mensajes de Kafka
            if not mensaje:
                # Si no hay más mensajes, salir del ciclo
                break
            for msg in mensaje.values():
                for mensaje_info in msg:
                    mensaje_decodificado = mensaje_info.value.decode('utf-8')
                    logger.info(mensaje_decodificado)
                    # Decodifica el JSON en cada mensaje para eliminar las barras invertidas "\" en las URL
                    mensaje_decodificado = json.loads(mensaje_decodificado)
                    lista_mensajes.append({'novedades': mensaje_decodificado})
    finally:
        consumer.close()

    # Invertir la lista para que los mensajes más recientes estén en la parte superior
    lista_mensajes.reverse()
    
    # Tomar solo los 5 mensajes más recientes
    lista_mensajes = lista_mensajes[:5]

    # Convierte la lista de mensajes en un JSON array y retorna la respuesta como JSON
    return jsonify(lista_mensajes)


@receta_blueprint.route("/misRecetas",methods = ['GET'])
def misRecetas():
    logger.info("/misRecetas")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel) 
        response = stub.FindAllById(Receta(user=User(id=session['user_id'])))
        recetas = response.receta        
    print("Greeter Recetas received: " + str(response))

    return render_template('abm-receta.html', recetas=recetas)


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
            return redirect('/misRecetas')
            

@receta_blueprint.route("/storyline",methods = ['GET'])
def findAll():
    logger.info("/receta/findAll")
    user_id=session['user_id']
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.FindAll(Receta()) 
        recetas = response.receta 

    motivos = getMotivos()

    print("Greeter client received: " + str(response))    
    return render_template('storyline.html', recetas=recetas,usuario_autenticado=user_id, motivos= motivos)


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
        
@receta_blueprint.route("/eliminarReceta/<int:id>",methods=["POST"])
def eliminarReceta(id):
    logger.info("/eliminarReceta %s"+str(id))
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.DeleteReceta(Receta(idReceta= int(id)))
        print("Greeter client received: " + str(response))    
        receta={"receta":MessageToJson(response)}

    return receta


###################  Metodos de Modulo DENUNCIAS  ###################


@receta_blueprint.route("/denuncias",methods=['GET'])
def findDenunciasAbiertas():
    logger.info("/denuncias")
    
    denuncias_abiertas = clientDenuncias.service.getUnresolved()

    logger.info(denuncias_abiertas)

    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = RecetasServiceStub(channel)
        response = stub.FindAll(Receta()) 
        recetas = response.receta

    denuncia_recetas = []

    for denuncia in denuncias_abiertas:
        # Traigo Receta por ID
        with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
            stub = RecetasServiceStub(channel)
            recetas_x_denuncia = stub.FindById(Receta(idReceta= int(denuncia.receta_id)))
        

        with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
            stub = UsersServiceStub(channel)
            user_x_denuncia = stub.FindUserById(User(id= int(denuncia.user_id)))
                
        if recetas_x_denuncia and user_x_denuncia:
            # Si hay recetas coincidentes, agregar la denuncia y las recetas a la lista denuncia_recetas
            denuncia_recetas.append({
                'denuncia': denuncia,
                'receta': recetas_x_denuncia,
                'user' : user_x_denuncia
            })

    logger.info(denuncia_recetas)


    if denuncias_abiertas=="{}":
        flash('Error al intentar traer Denuncias','danger')
        return redirect('/storyline')
    else:
        return render_template('denuncias.html', denuncia_recetas= denuncia_recetas)
    

@receta_blueprint.route("/addDenuncia",methods=['POST'])
def addDenuncia():
    logger.info("/addDenuncia")

    recetaId = int(request.form["receta_id"])
    motivoId = int(request.form["motivo_id"])
    
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
            stub = RecetasServiceStub(channel)
            receta_denunciada = stub.FindById(Receta(idReceta= recetaId))

    
    if not isinstance(session['user_id'], int) and not isinstance(recetaId, int) and not isinstance(motivoId, int):
        flash(f'Error al intentar guardar Denuncia de receta "{receta_denunciada.tituloReceta}"', 'danger')
        return redirect('/storyline')
    else:

        clientDenuncias.service.addDenuncia(user_id=session['user_id'], receta_id= recetaId, motivo_id= motivoId)

        flash(f'Receta "{receta_denunciada.tituloReceta}" denunciada!', 'message')
        return redirect('/storyline')
    

    
@receta_blueprint.route("/resolverDenuncia",methods=['POST'])
def resolverDenuncia():
    logger.info("/resolverDenuncia")
    
    denuncia_id = request.form["denuncia_id"]
    receta_id = request.form["receta_id"]
    flg_eliminar = request.form["flg_eliminar"]

    logger.info("Resolviendo Denuncia: %s", denuncia_id)
    logger.info("Receta Denunciada: %s", receta_id)
    logger.info("FLG Denuncia: %s", flg_eliminar)

    
    if int(denuncia_id) <= 0:
        flash('Error al intentar resolver Denuncia','danger')
        return redirect('/denuncias')
    
    else:

        mensaje= "No se llego a correr la eliminacion de denuncia"

        if flg_eliminar == "1":
            
            flg_confirm = clientDenuncias.service.resolverDenunciasPorBajaReceta(receta_id)
            
            eliminarReceta(int(receta_id))

            if flg_confirm == "1": 
                mensaje = "Receta borrada y denuncias resueltas!"
            else:
                mensaje = "ERROR al resolver las denuncias"

        else:
            
            flg_confirm = clientDenuncias.service.resolverDenuncia(id=denuncia_id)

            if flg_confirm == "1":

                mensaje = "Denuncia ignorada y resuelta!"

        flash(mensaje,'message')
        return redirect('/denuncias')
    
    
@receta_blueprint.route("/getMotivos",methods=['GET'])
def getMotivos():
    logger.info("/getMotivos")
    
    motivos_crudo = clientDenuncias.service.getMotivos()

    motivos = []

    for motivo in motivos_crudo:
        motivos.append({
                    'motivo': motivo
                })
    
    if motivos=="{}":
        flash('Error al intentar traer Motivos','danger')
        return redirect('/storyline')
    else:                
        return  motivos
    
    
################  FIN Metodos de Modulo DENUNCIAS  ##################

@receta_blueprint.route("/misRecetarios",methods=['GET'])
def findRecetarios():
    logger.info("/misRecetarios")
    
    recetarios = clientRecetarios.service.TraerRecetariosPorUsuario(session['user_id'])
    

    recetarios_recetas = []

    for recetario in recetarios:
        recers = clientRecetarios.service.TraerRecetasPorRecetarios(recetario.id)
        if recetario:
            # Si hay recetas coincidentes, agregar el recetario
            recetarios_recetas.append({
                'recetario': recetario
            })
        for recetarioReceta in recers:
            # Traigo Receta por ID
            with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
                stub = RecetasServiceStub(channel)
                recetas_x_recetario = stub.FindById(Receta(idReceta=recetarioReceta.recetaId))
            if recetas_x_recetario:
                # Si hay recetas coincidentes, agregar el recetario
                recetario_data = {
                    'receta': recetas_x_recetario
                }
                recetarios_recetas.append(recetario_data)
            

    logger.info(recetarios)
    logger.info(recetarios_recetas)


    if recetarios_recetas=="{}":
        flash('Error al intentar traer las recetas por Recetario','danger')
        return redirect('/storyline')
    else:
        return render_template('recetarios.html', recetarios= recetarios)
    


@receta_blueprint.route("/agregarRecetario/<string:nombreRecetario>", methods=['GET'])
def addRecetario(nombreRecetario):
    logger.info("/agregarRecetario")

    nombre_recetario = nombreRecetario
    
    if not isinstance(session['user_id'], int) and not isinstance(nombre_recetario, str):
        flash('Error al intentar guardar el recetario', 'danger')
        return redirect('/storyline')
    else:
        clientRecetarios.service.agregarRecetario(nombre=nombre_recetario, usuarioId=session['user_id'])

        flash('Recetario agregado', 'message')
        return redirect('/misRecetarios')

