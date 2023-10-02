from flask import Blueprint
popularidadReceta_blueprint = Blueprint("popularidadReceta", __name__, template_folder="templates")

from . import PopularidadRecetaController