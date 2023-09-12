from flask import Blueprint
categoria_blueprint = Blueprint("categoria", __name__, template_folder="templates")

from . import CategoriaController