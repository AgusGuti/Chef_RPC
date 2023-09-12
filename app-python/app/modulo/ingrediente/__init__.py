from flask import Blueprint
ingrediente_blueprint = Blueprint("ingrediente", __name__, template_folder="templates")

from . import IngredienteController