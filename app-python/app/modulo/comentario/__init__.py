from flask import Blueprint
comentario_blueprint = Blueprint("comentario", __name__, template_folder="templates")

from . import ComentarioController