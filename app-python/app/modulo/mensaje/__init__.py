from flask import Blueprint
mensaje_blueprint = Blueprint("mensaje", __name__, template_folder="templates")

from . import MensajeController