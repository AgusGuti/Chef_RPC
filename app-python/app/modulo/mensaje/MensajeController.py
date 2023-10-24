from flask import Flask, render_template, request, flash, redirect,session,jsonify
from . import mensaje_blueprint
import requests
import logging
import os
logger = logging.getLogger(__name__)



@mensaje_blueprint.route("/misMensajes", methods=["GET"])
def vista_mensajes():
    user_id = session.get('user_id')

    if user_id is None:
        # Manejar el caso en el que el usuario no esté autenticado
        return jsonify({'error': 'Usuario no autenticado'}), 401

    # Realiza una solicitud GET para obtener los mensajes desde la API externa
    response = requests.get('http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mensaje/user/' + str(user_id))

    if response.status_code == 200:
        mensajes = response.json()  # Supongo que la respuesta contiene una lista de mensajes

        # Filtrar los mensajes donde el receptor coincida con el usuario logueado
        mensajes_filtrados = [mensaje for mensaje in mensajes if mensaje['receptor']['id'] == user_id]

        return render_template('mensajes.html', mensajes=mensajes_filtrados)
    else:
        # Manejar el caso en el que no se puedan obtener los mensajes
        flash('Error al obtener los mensajes', 'error')
        return redirect('/misMensajes')



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

    # Obtener el ID del receptor y otros datos del formulario HTML
    idReceptor = request.form.get("idReceptor")
    asunto = request.form.get("asunto")
    cuerpo = request.form.get("cuerpo")
    
    # Imprimir los datos para depuración
    print("ID Emisor (logueado):", user_id)
    print("ID Receptor:", idReceptor)
    print("Asunto:", asunto)
    print("Cuerpo:", cuerpo)

    # URL de la API externa donde deseas enviar el mensaje
    api_url = 'http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mensaje'

    # Datos del mensaje a enviar
    mensaje_data = {
        'idEmisor': user_id,  # Emisor es el usuario logueado
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


# Ruta para responder a un mensaje
@mensaje_blueprint.route("/mensaje/resp", methods=["POST"])
def responder_mensaje():
    cuerpo = request.form.get("cuerpo")
    idMensajeRespondido = request.form.get("idMensajeRespondido")

    print("Cuerpo:", cuerpo)
    print("ID Mensaje:", idMensajeRespondido)
  
    api_url = 'http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mensaje/resp'

    mensaje_data = {
            'idEmisor': idMensajeRespondido,
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
                flash('Error: este mensaje ya ha sido respondido', 'danger')
                return redirect('/misMensajes')
            
    except requests.exceptions.RequestException as e:
        # Manejar excepciones de solicitud (por ejemplo, problemas de red)
        flash('Error al enviar el mensaje', 'error')
        return redirect('/misMensajes')


@mensaje_blueprint.route("/mensaje/user/<id>", methods=["GET"])
def listar_mensajes_usuario(id):

    response = requests.get('http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mensaje/user/' + str(id))

    if response.status_code == 200:
        mensajes_del_usuario = response.json()  # Cambiamos el nombre de la variable
        return render_template('mensajes.html', mensajes=mensajes_del_usuario)
    else:
        return jsonify({"error": "No se pudieron obtener los mensajes del usuario"})



@mensaje_blueprint.route("/mensaje/resp/<id>", methods=["GET"])
def listar_mensajes_resp(id):

    response = requests.get('http://' + os.getenv("SERVER-REST-CORREOINTERNO") + '/mensaje/resp/' + str(id))

    if response.status_code == 200:
        return jsonify(response.json())
    else:
        return jsonify({"error": "No se pudieron obtener los mensajes del usuario"})
    



