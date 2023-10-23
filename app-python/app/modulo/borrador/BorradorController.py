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
    
    
@borrador_blueprint.route("/api/borradores/<int:id>", methods=["GET"])
def obtener_borrador(id):
    response = requests.get('http://'+os.getenv("SERVER-REST-CARGAMASIVA")+'/api/borradores/' + str(id))
    
    if response.status_code == 200:
        return jsonify(response.json())
    else:
        mensaje_error = "No se pudieron obtener los datos del borrador. Por favor, intentalo de nuevo mas tarde."
        return jsonify({'error': mensaje_error}), 500  # Devuelve un JSON con el mensaje de error y establece un código de respuesta 500



@borrador_blueprint.route("/api/borradores/borrador_id/<int:borrador_id>", methods=["GET"])
def obtener_borrador_id(borrador_id):
    response = requests.get('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + f'/api/borradores/borrador_id/{borrador_id}')
    
    if response.status_code == 200:
        return jsonify(response.json())
    else:
        mensaje_error = "No se pudieron obtener los datos del borrador. Por favor, inténtalo de nuevo más tarde."
        return jsonify({'error': mensaje_error}), 500


@borrador_blueprint.route("/api/borradores/<int:id>", methods=["PUT"])
def actualizar_borrador(id):
    # Log the received data
    logger.info('Received PUT request for updating draft with ID %s', str(id))
    logger.info('Received data: %s', request.form)

    # Retrieve and log any specific data you want to inspect
    nuevoTitulo = request.form.get('titulo_receta')
    nuevaDescripcion = request.form.get('descripcion')
    categoriaID = request.form.get('categoria_id')
    tiempoPreparacion = request.form.get('tiempo_preparacion')
    foto1 = request.form.get('foto1')
    foto2 = request.form.get('foto2')
    foto3 = request.form.get('foto3')
    foto4 = request.form.get('foto4')
    foto5 = request.form.get('foto5')
    pasos = request.form.get('pasos')

    logger.info('Updated values - Titulo: %s, Descripcion: %s, Categoria ID: %s, Tiempo de Preparacion: %s', nuevoTitulo, nuevaDescripcion, categoriaID, tiempoPreparacion)

    # Define los datos actualizados en un diccionario
    datos_actualizados = {
        'titulo_receta': nuevoTitulo,
        'descripcion': nuevaDescripcion,
        'categoria_id': categoriaID,
        'tiempo_preparacion': tiempoPreparacion,
        'foto1': foto1,
        'foto2': foto2,
        'foto3': foto3,
        'foto4': foto4,
        'foto5': foto5,
        'pasos': pasos
    }

    # Realiza una solicitud PUT para enviar los datos actualizados al servidor REST
    response = requests.put('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + '/api/borradores/' + str(id), json=datos_actualizados)

    if response.status_code == 200:
        logger.info('Borrador actualizado correctamente')
        return jsonify({'mensaje': 'Borrador actualizado correctamente'})
    else:
        mensaje_error = "No se pudo actualizar el borrador. Por favor, inténtalo de nuevo más tarde."
        logger.error('Error al actualizar el borrador')
        return jsonify({'error': mensaje_error}), 500


@borrador_blueprint.route("/api/guardar_como_receta/<borrador_id>", methods=["POST"])
def guardar_como_receta(borrador_id):
    user_id = session.get('user_id')
    if user_id is None:
        return jsonify({'error': 'Usuario no autenticado'}), 401

    # Obtener los datos del borrador a través de la API
    borrador_response = requests.get('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + f'/api/borradores/borrador_id/{borrador_id}')

    if borrador_response.status_code != 200:
        mensaje_error = "No se pudieron obtener los datos del borrador. Por favor, intentalo de nuevo mas tarde."
        return jsonify({'error': mensaje_error}), 500

    borrador_data = borrador_response.json()
    logger.info("ver data: %s", borrador_data)
    
        
    # Verificar si el borrador está completo
    if es_borrador_completo(borrador_data):
        guardar_receta_response = requests.post('http://' + os.getenv("SERVER-REST-CARGAMASIVA") + f'/api/guardar_como_receta/{borrador_id}', json=borrador_data)
        return jsonify({'mensaje': 'Borrador guardado como receta y eliminado correctamente'})
    else:
        mensaje_incompleto = "El borrador no esta completo. Por favor, completa todos los campos obligatorios."
        return jsonify({'error': mensaje_incompleto}), 400


def es_borrador_completo(borrador_data):
    required_fields = ['titulo_receta', 'descripcion', 'categoria_id', 'tiempo_preparacion', 'foto1', 'pasos']
    
    for item in borrador_data:
        for field in required_fields:
            if item.get(field) is None:
                logger.info(f"Falta el campo requerido: {field}")
                return False

    # Si llega a este punto, todos los campos requeridos están presentes en todos los elementos
    return True


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
