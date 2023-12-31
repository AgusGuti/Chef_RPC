from flask import Flask


from logging.config import dictConfig

dictConfig({
    'version': 1,
    'formatters': {'default': {
        'format': '[%(asctime)s] %(levelname)s in %(module)s: %(message)s',
    }},
    'handlers': {'wsgi': {
        'class': 'logging.StreamHandler',
        'stream': 'ext://flask.logging.wsgi_errors_stream',
        'formatter': 'default'
    }},
    'root': {
        'level': 'INFO',
        'handlers': ['wsgi']
    }
})


def create_app(config_filename=None):
    app = Flask(__name__, instance_relative_config=True)
    logger = app
    app.config.from_pyfile(config_filename)
    register_blueprints(app)
    return app

def register_blueprints(app):
    from app.modulo.user import user_blueprint
    from app.modulo.receta import receta_blueprint
    from app.modulo.ingrediente import ingrediente_blueprint
    from app.modulo.categoria import categoria_blueprint
    from app.modulo.favorito import favorito_blueprint
    from app.modulo.seguido import seguido_blueprint
    from app.modulo.popularidadReceta import popularidadReceta_blueprint
    from app.modulo.popularidadUser import popularidadUser_blueprint
    from app.modulo.comentario import comentario_blueprint
    from app.modulo.borrador import borrador_blueprint
    from app.modulo.mensaje import mensaje_blueprint
    app.register_blueprint(user_blueprint)
    app.register_blueprint(receta_blueprint)
    app.register_blueprint(ingrediente_blueprint)
    app.register_blueprint(categoria_blueprint)
    app.register_blueprint(favorito_blueprint)
    app.register_blueprint(seguido_blueprint)
    app.register_blueprint(popularidadReceta_blueprint)
    app.register_blueprint(popularidadUser_blueprint)
    app.register_blueprint(comentario_blueprint)
    app.register_blueprint(borrador_blueprint)
    app.register_blueprint(mensaje_blueprint)


    
    