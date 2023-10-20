from flask import Flask, render_template, request, flash, redirect,jsonify
from . import borrador_blueprint
import requests
import logging
import os
logger = logging.getLogger(__name__)

@borrador_blueprint.route("/borradores", methods=["GET"])
def obtener_borradores():
    response = requests.get('http://'+os.getenv("SERVER-REST-CARGAMASIVA")+'/api/borradores')
    
    if response.status_code == 200:
        borradores_data = response.json()
        return render_template('borradores.html', borradores=borradores_data)
    else:
        mensaje_error = "No se pudieron obtener los datos de borradores. Por favor, inténtalo de nuevo más tarde."
        return render_template('error.html', mensaje=mensaje_error), 500  # Renderiza una plantilla de error y establece un código de respuesta 500


@borrador_blueprint.route("/api/borradores", methods=["GET"])
def apiborradores():
    response = requests.get('http://'+os.getenv("SERVER-REST-CARGAMASIVA")+'/api/borradores')
    
    if response.status_code == 200:
        return jsonify(response.json())
    else:
        mensaje_error = "No se pudieron obtener los datos de borradores. Por favor, inténtalo de nuevo más tarde."
        return jsonify({'error': mensaje_error}), 500  # Devuelve un JSON con el mensaje de error y establece un código de respuesta 500
    

@borrador_blueprint.route("/api/borradores/<borrador_id>", methods=["GET"])
def obtener_borrador(borrador_id):
    response = requests.get('http://'+os.getenv("SERVER-REST-CARGAMASIVA")+'/api/borradores/' + borrador_id)
    
    if response.status_code == 200:
        return jsonify(response.json())
    else:
        mensaje_error = "No se pudieron obtener los datos del borrador. Por favor, inténtalo de nuevo más tarde."
        return jsonify({'error': mensaje_error}), 500  # Devuelve un JSON con el mensaje de error y establece un código de respuesta 500


@borrador_blueprint.route("/api/borradores/<borrador_id>", methods=["PUT"])
def actualizar_borrador(borrador_id):
     return jsonify({'mensaje': 'Borrador actualizado correctamente'})


@borrador_blueprint.route("/api/guardar_como_receta/<borrador_id>", methods=["POST"])
def guardar_como_receta(borrador_id):
    return jsonify({'mensaje': 'Borradores guardados como recetas correctamente'})


@borrador_blueprint.route("/api/upload_csv/<idusuario>", methods=["POST"])
def upload_csv(idusuario):
    return jsonify({'mensaje': 'Archivo CSV subido correctamente'})