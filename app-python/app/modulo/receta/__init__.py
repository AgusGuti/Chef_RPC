from flask import Blueprint
receta_blueprint = Blueprint("receta", __name__, template_folder="templates")

from . import RecetaController