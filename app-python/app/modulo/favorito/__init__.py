from flask import Blueprint
favorito_blueprint = Blueprint("favorito", __name__, template_folder="templates")

from . import FavoritoController

