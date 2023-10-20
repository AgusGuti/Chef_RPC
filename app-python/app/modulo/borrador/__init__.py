from flask import Blueprint
borrador_blueprint = Blueprint("borrador", __name__, template_folder="templates")

from . import BorradorController