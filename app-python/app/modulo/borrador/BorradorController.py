from flask import Flask, render_template, request, flash, redirect,session,jsonify
from . import borrador_blueprint
import requests
from werkzeug.utils import secure_filename
import logging
import os
logger = logging.getLogger(__name__)


@borrador_blueprint.route("/borradores", methods=["GET"])
def vista_borrador():
    user_id = session.get('user_id')

    if user_id is None:
        # Manejar el caso en el que el usuario no esté autenticado
        return jsonify({'error': 'Usuario no autenticado'}), 401

    # Llama a la función obtener_borradores para obtener los datos
    grouped_borradores = obtener_borradores()

    # Obtiene los borradores de los datos agrupados
    borradores = [borrador for borradores in grouped_borradores.values() for borrador in borradores]
    
    return render_template('borradores.html', grouped_borradores=grouped_borradores, borradores=borradores, usuario_autenticado=user_id)


@borrador_blueprint.route("/api/borradores", methods=["GET"])
def obtener_borradores():
    response = requests.get('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + '/api/borradores')

    if response.status_code == 200:
        borradores_data = response.json()

        grouped_borradores = {}

        # Agrupa los borradores por borrador_id
        for borrador in borradores_data:
            borrador_id = borrador['borrador_id']
            if borrador_id not in grouped_borradores:
                grouped_borradores[borrador_id] = []
            grouped_borradores[borrador_id].append(borrador)
        
        return grouped_borradores
    
    else:
        mensaje_error = "No se pudieron obtener los datos de borradores. Por favor, inténtalo de nuevo más tarde."
        # Devuelve un diccionario vacío en caso de error
        return {}
    
    
@borrador_blueprint.route("/api/borradores/<borrador_id>", methods=["GET"])
def obtener_borrador(borrador_id):
    response = requests.get('http://'+os.getenv("SERVER-REST-CARGAMASIVA")+'/api/borradores/' + borrador_id)
    
    if response.status_code == 200:
        return jsonify(response.json())
    else:
        mensaje_error = "No se pudieron obtener los datos del borrador. Por favor, intentalo de nuevo mas tarde."
        return jsonify({'error': mensaje_error}), 500  # Devuelve un JSON con el mensaje de error y establece un código de respuesta 500


@borrador_blueprint.route("/api/borradores/<borrador_id>", methods=["PUT"])
def actualizar_borrador(borrador_id):
    # Log the received data
    logger.info('Received PUT request for updating draft with ID %s', borrador_id)
    logger.info('Received data: %s', request.form)

    # Retrieve and log any specific data you want to inspect
    nuevoTitulo = request.form.get('titulo')
    nuevaDescripcion = request.form.get('descripcion')
    categoriaID = request.form.get('categoria_id')
    tiempoPreparacion = request.form.get('tiempo_preparacion')

    logger.info('Updated values - Titulo: %s, Descripcion: %s, Categoria ID: %s, Tiempo de Preparacion: %s', nuevoTitulo, nuevaDescripcion, categoriaID, tiempoPreparacion)

    # Make a PUT request to update the draft
    response = requests.put('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + '/api/borradores/' + borrador_id)

    if response.status_code == 200:
        logger.info('Draft updated successfully')
        return jsonify({'mensaje': 'Borrador actualizado correctamente'})
    else:
        mensaje_error = "No se pudo actualizar el borrador. Por favor, inténtalo de nuevo más tarde."
        logger.error('Error updating draft')
        return jsonify({'error': mensaje_error}), 500



@borrador_blueprint.route("/api/guardar_como_receta/<borrador_id>/", methods=["POST"])
def guardar_como_receta(borrador_id):

    borrador_data = requests.post('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + f'/api/guardar_como_receta/{borrador_id}')
    
    if borrador_data.status_code != 200:
        mensaje_error = "No se pudieron obtener los datos del borrador. Por favor, intentalo de nuevo mas tarde."
        return jsonify({'error': mensaje_error}), 500

    # Eliminar el borrador
    borrador_delete_response = requests.delete('http://'+os.getenv("SERVER-REST-CARGAMASIVA")+'/api/borradores/' + borrador_id)
    
    if borrador_delete_response.status_code == 200:
        return jsonify({'mensaje': 'Borrador guardado como receta y eliminado correctamente'})
    else:
        mensaje_error = "No se pudo eliminar el borrador. Por favor, inténtalo de nuevo mas tarde."
        return jsonify({'error': mensaje_error}), 500



@borrador_blueprint.route("/api/upload_csv/<idusuario>", methods=["POST"])
def upload_csv(idusuario):
    user_id = session.get('user_id')
    if user_id is None:
        return jsonify({'error': 'Usuario no autenticado'}), 401

    if 'file' not in request.files:
        return jsonify({'error': 'No subiste el archivo CSV'}), 400

    file = request.files['file']
    if file.filename == '':
        return jsonify({'error': 'No se seleccionó un archivo CSV'}), 400

    # Ensure a secure filename
    filename = secure_filename(file.filename)

    # Prepare the data to send to the other server
    files = {'file': (filename, file.stream, file.content_type)}
    
    url = f'http://{os.getenv("SERVER-REST-CARGAMASIVA")}/api/upload_csv/{user_id}'
    
    # Send the file to the other server
    response = requests.post(url, files=files)

    if response.status_code == 200:
        return jsonify({'mensaje': 'Archivo CSV subido correctamente'}), 200
    else:
        return jsonify({'error': 'No se pudo cargar el archivo CSV'}), 500
