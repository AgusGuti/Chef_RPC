from flask import Blueprint
popularidadUser_blueprint = Blueprint("popularidadUser", __name__, template_folder="templates")

from . import PopularidadUserController