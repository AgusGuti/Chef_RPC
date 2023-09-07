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
    app.register_blueprint(user_blueprint)
    app.register_blueprint(receta_blueprint)
    