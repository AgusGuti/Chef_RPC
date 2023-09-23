from flask import Blueprint
seguido_blueprint = Blueprint("seguido", __name__, template_folder="templates")

from . import SeguidoController