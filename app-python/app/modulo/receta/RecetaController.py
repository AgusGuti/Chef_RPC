from flask import Flask, render_template, request, flash, redirect
from . import receta_blueprint 

from google.protobuf.json_format import MessageToJson

import os,grpc

import logging

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