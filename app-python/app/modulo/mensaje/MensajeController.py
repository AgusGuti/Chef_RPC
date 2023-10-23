from flask import Flask, render_template, request, flash, redirect,session,jsonify
from . import mensaje_blueprint
import requests
import logging
import os
logger = logging.getLogger(__name__)

@mensaje_blueprint.route("/mismensajes", methods=["GET"])
def vista_mensajes():
    user_id = session.get('user_id')

    if user_id is None:
        # Manejar el caso en el que el usuario no esté autenticado
        return jsonify({'error': 'Usuario no autenticado'}), 401

    # Realiza una solicitud GET para obtener los mensajes desde la API externa
    response = requests.get('http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mismensajes"')

    if response.status_code == 200:
        mensajes = response.json()  # Supongo que la respuesta contiene una lista de mensajes
        return render_template('mensajes.html', usuario_autenticado=user_id, mensajes=mensajes)
    else:
        # Manejar el caso en el que no se puedan obtener los mensajes
        flash('Error al obtener los mensajes', 'error')
        return redirect('/misMensajes')


@mensaje_blueprint.route("/usuario/create", methods=["POST"])
def crear_usuario():
    # Implementa la lógica para crear un nuevo usuario
    # Debes procesar los datos del nuevo usuario desde la solicitud POST
    return jsonify({"message": "Usuario creado correctamente"})


@mensaje_blueprint.route("/usuario/list", methods=["GET"])
def listar_usuarios():
    response = requests.get('http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/usuario/list')

    if response.status_code == 200:
        usuarios_data = response.json()
        return jsonify(usuarios_data)
    else:
        return jsonify({"error": "No se pudieron obtener los datos de usuarios"})


@mensaje_blueprint.route("/mensaje", methods=["POST"])
def enviar_mensaje():
    user_id = session.get('user_id')

    if user_id is None:
        # Manejar el caso en el que el usuario no esté autenticado
        return jsonify({'error': 'Usuario no autenticado'}), 401

    # Obtener los datos del formulario HTML
    idEmisor = request.form.get("idEmisor")
    idReceptor = request.form.get("idReceptor")
    asunto = request.form.get("asunto")
    cuerpo = request.form.get("cuerpo")
    
    # Imprimir los datos para depuración
    print("ID Emisor:", idEmisor)
    print("ID Receptor:", idReceptor)
    print("Asunto:", asunto)
    print("Cuerpo:", cuerpo)

    # URL de la API externa donde deseas enviar el mensaje
    api_url = 'http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mensaje'

    # Datos del mensaje a enviar
    mensaje_data = {
        'idEmisor': idEmisor,
        'idReceptor': idReceptor,
        'asunto': asunto,
        'cuerpo': cuerpo
    }

    try:
        # Realizar la solicitud POST a la API externa
        response = requests.post(api_url, json=mensaje_data)

        if response.status_code == 201:
            # Si la API devuelve un código 201 (creado), el mensaje se envió con éxito
            flash('Mensaje enviado con éxito', 'success')
            return redirect('/misMensajes')
        else:
            # Manejar otros códigos de respuesta si es necesario
            flash('Error al enviar el mensaje', 'error')
            return redirect('/misMensajes')
    except requests.exceptions.RequestException as e:
        # Manejar excepciones de solicitud (por ejemplo, problemas de red)
        flash('Error al enviar el mensaje', 'error')
        return redirect('/misMensajes')


@mensaje_blueprint.route("/mensaje/<id>", methods=["GET"])
def consultar_mensaje(id):
    response = requests.get('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + '/api/mensaje/' + id)

    if response.status_code == 200:
        mensaje_data = response.json()
        return jsonify(mensaje_data)
    else:
        return jsonify({"error": "No se pudo consultar el mensaje"})


@mensaje_blueprint.route("/mensaje/resp", methods=["POST"])
def responder_mensaje():
    # Implementa la lógica para responder a un mensaje
    # Debes procesar los datos de la respuesta desde la solicitud POST
    return jsonify({"message": "Respuesta enviada correctamente"})


@mensaje_blueprint.route("/mensaje/user/<id>", methods=["GET"])
def listar_mensajes_usuario(id):
    response = requests.get('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + '/api/mensajes/user/' + id)

    if response.status_code == 200:
        mensajes_data = response.json()
        return jsonify(mensajes_data)
    else:
        return jsonify({"error": "No se pudieron obtener los mensajes del usuario"})