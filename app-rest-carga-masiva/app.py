from flask import Flask, request, render_template, jsonify , redirect, url_for
from flask_sqlalchemy import SQLAlchemy
import csv
import io
from flask_swagger import swagger
from flask_swagger_ui import get_swaggerui_blueprint

app = Flask(__name__)

@app.route("/spec")
def spec():
    swag = swagger(app)
    swag['info']['version'] = "1.0"
    swag['info']['title'] = "ModuloCsv"

    # Define la descripcion de la ruta /api/borradores
    swag['paths']['/api/borradores'] = {
        'get': {
            'summary': 'Obtiene un listado de todos los elementos que estan guardados como borrador',
            'description': 'Obtiene un listado de todos los elementos que estan guardados como borrador.',
            'responses': {
                '200': {
                    'description': 'Éxito. Devuelve la lista de borradores.'
                }
            }
        },
        
    }

    # Define la descripcion de la ruta /api/borradores/{borrador_id}
    swag['paths']['/api/borradores/{id}'] = {
        'get': {
            'summary': 'Obtener datos de un borrador',
            'description': 'Obtiene datos de un borrador específico por su ID.',
            'parameters': [
                {
                    'name': 'id',
                    'in': 'path',
                    'description': 'ID del borrador a consultar',
                    'required': True,
                    'schema': {
                        'type': 'integer'
                    }
                }
            ],
            'responses': {
                '200': {
                    'description': 'Éxito. Devuelve los datos del borrador.'
                }
            }
        },
        'put': {
    'summary': 'Actualizar un elemento de un borrador con id especifica',
    'description': 'Actualiza un elemento de un borrador .',
    'parameters': [
        {
            'name': 'id',
            'in': 'path',
            'description': 'ID del borrador a actualizar',
            'required': True,
            'schema': {
                'type': 'integer'
            }
        },
        {
            'name': 'titulo_receta',
            'in': 'formData',
            'description': 'Nuevo título de la receta',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'descripcion',
            'in': 'formData',
            'description': 'Nueva descripción del borrador',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'categoria_id',
            'in': 'formData',
            'description': 'Nuevo ID de categoría',
            'required': False,
            'type': 'integer'
        },
        {
            'name': 'tiempo_preparacion',
            'in': 'formData',
            'description': 'Nuevo tiempo de preparación',
            'required': False,
            'type': 'integer'
        },
        {
            'name': 'foto1',
            'in': 'formData',
            'description': 'Nueva URL de la foto 1',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'foto2',
            'in': 'formData',
            'description': 'Nueva URL de la foto 2',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'foto3',
            'in': 'formData',
            'description': 'Nueva URL de la foto 3',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'foto4',
            'in': 'formData',
            'description': 'Nueva URL de la foto 4',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'foto5',
            'in': 'formData',
            'description': 'Nueva URL de la foto 5',
            'required': False,
            'type': 'string'
        },
        {
            'name': 'pasos',
            'in': 'formData',
            'description': 'Nuevos pasos de la receta',
            'required': False,
            'type': 'string'
        }
    ],
    'responses': {
        '200': {
            'description': 'Éxito. El borrador ha sido actualizado.'
        }
    }
}

        
        
    }
       
    swag['paths']['/api/upload_csv/{idusuario}'] = {
    'post': {
        'summary': 'Subir archivo CSV',
        'description': 'Carga un archivo CSV para procesar en la base de datos.',
        'consumes': ['multipart/form-data'],
        'parameters': [
            {
                'name': 'file',
                'in': 'formData',
                'description': 'Archivo CSV a cargar',
                'required': True,
                'type': 'file',
            },
            {
                'name': 'idusuario',
                'in': 'path',
                'description': 'ID de usuario',
                'required': True,
                'schema': {
                    'type': 'integer'
                }
            },
        ],
        'responses': {
            '200': {
                'description': 'Éxito. El archivo CSV ha sido procesado y los datos han sido guardados en la base de datos.',
            },
        },
    },
}
    swag['paths']['/api/guardar_como_receta/{borrador_id}'] = {
    'post': {
        'summary': 'Guardar múltiples borradores como recetas',
        'description': 'Mueve múltiples borradores con el mismo borrador_id a la entidad Receta y elimina los borradores.',
        'parameters': [
            {
                'name': 'borrador_id',
                'in': 'path',
                'description': 'ID del borrador a guardar como receta',
                'required': True,
                'schema': {
                    'type': 'integer'
                }
            }
        ],
        'responses': {
            '200': {
                'description': 'Éxito. Los borradores se han guardado como recetas y se han eliminado.'
            },
            '404': {
                'description': 'No se encontraron borradores con el ID especificado.'
            },
            '500': {
                'description': 'Error al guardar las recetas o eliminar los borradores.'
            }
        }
    }
}

    return jsonify(swag)



SWAGGER_URL = '/swagger'
API_URL = '/spec'  

swaggerui_blueprint = get_swaggerui_blueprint(
    SWAGGER_URL,
    API_URL,
    
)
app.register_blueprint(swaggerui_blueprint, url_prefix=SWAGGER_URL)

# Configuro la base de datos

DB_USERNAME = 'root'
DB_PASSWORD = 'root'
DB_HOST = '127.0.0.1'
DB_PORT = '3306'
DB_NAME = 'csvmicroservice'

# Configuro driver mysql pymysql
app.config['SQLALCHEMY_DATABASE_URI'] = f'mysql+pymysql://{DB_USERNAME}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/{DB_NAME}'

# Inicializo sql alchemy
db = SQLAlchemy(app)

class Borrador(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    titulo_receta = db.Column(db.String(255), nullable=False)
    descripcion = db.Column(db.String(255), nullable=False)
    categoria_id = db.Column(db.Integer, nullable=False)
    borrador_id=db.Column(db.Integer,nullable=False)
    tiempo_preparacion = db.Column(db.Integer, nullable=False)
    foto1 = db.Column(db.String(255), nullable=True)
    foto2 = db.Column(db.String(255), nullable=True)
    foto3 = db.Column(db.String(255), nullable=True)
    foto4 = db.Column(db.String(255), nullable=True)
    foto5 = db.Column(db.String(255), nullable=True)
    pasos = db.Column(db.String(1000), nullable=True)
    usuario = db.Column(db.Integer, nullable=False)

    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}
    
class Receta(db.Model):
    idreceta = db.Column(db.Integer, primary_key=True)
    titulo_receta = db.Column(db.String(255), nullable=False)
    descripcion = db.Column(db.String(255), nullable=False)
    categoria_id = db.Column(db.Integer, nullable=False)
    tiempo_preparacion = db.Column(db.Integer, nullable=False)
    foto1 = db.Column(db.String(255), nullable=True)
    foto2 = db.Column(db.String(255), nullable=True)
    foto3 = db.Column(db.String(255), nullable=True)
    foto4 = db.Column(db.String(255), nullable=True)
    foto5 = db.Column(db.String(255), nullable=True)
    pasos = db.Column(db.String(1000), nullable=True)
    usuario = db.Column(db.Integer, nullable=False)


@app.route('/listadoborradores', methods=['GET'])
def borradores():
    borradores = Borrador.query.all()
    grouped_borradores = {}  # Un diccionario para agrupar los borradores por borrador_id

    for borrador in borradores:
        borrador_id = borrador.borrador_id
        if borrador_id not in grouped_borradores:
            grouped_borradores[borrador_id] = []  # Inicializa una lista vacia para cada borrador_id
        grouped_borradores[borrador_id].append(borrador)

    return render_template('borradores.html', grouped_borradores=grouped_borradores)

@app.route('/editar_borrador/<int:id>', methods=['GET', 'POST'])
def editar_borrador(id):
    borrador = Borrador.query.get(id)

    if request.method == 'POST':
        # Procesar los datos enviados por el formulario de edicion
        borrador.descripcion = request.form['descripcion']
        borrador.categoria_id = request.form['categoria_id']
        borrador.tiempo_preparacion = request.form['tiempo_preparacion']
        borrador.foto1=request.form["foto1"]
        borrador.foto2=request.form["foto2"]
        borrador.foto3=request.form["foto3"]
        borrador.foto4=request.form["foto4"]
        borrador.foto5=request.form["foto5"]
        borrador.pasos=request.form["pasos"]

        
        db.session.commit()
        return redirect(url_for('borradores'))

    return render_template('editar_borrador.html', borrador=borrador)

@app.route('/api/upload_csv/<int:idusuario>', methods=['POST'])
def upload_csv(idusuario):
    if request.method == 'POST':
        if 'file' not in request.files:
            return jsonify({'error': 'No subiste el archivo CSV'})
        max_borrador_id = db.session.query(db.func.max(Borrador.borrador_id)).scalar()

        if max_borrador_id is not None:
            max_borrador_id += 1
        else:
            max_borrador_id = 1

        file = request.files['file']

        if file.filename == '':
            return jsonify({'error': 'CSV vacío'})

        if not file.filename.endswith('.csv'):
            return jsonify({'error': 'Extensión incorrecta, debes subir un archivo CSV'})

        try:
            csv_data = []
            reader = csv.DictReader(io.TextIOWrapper(file, 'utf-8'))

            for row in reader:
                row['borrador_id'] = max_borrador_id
                row['idusuario'] = idusuario
                csv_data.append(row)

        except Exception as e:
            return jsonify({'error': 'Error al analizar el archivo CSV', 'details': str(e)})

        for row in csv_data:
            try:
                borrador = Borrador(
                    titulo_receta=row['titulo_receta'],
                    descripcion=row['descripcion'],
                    categoria_id=row['categoria_id'],
                    tiempo_preparacion=row['tiempo_preparacion'],
                    borrador_id=row['borrador_id'],
                    usuario=row['idusuario']
                )
                db.session.add(borrador)
            except Exception as e:
                return jsonify({'error': 'Error al insertar datos en la base de datos borrador', 'details': str(e)})

        try:
            db.session.commit()
            return jsonify({'Exito': 'Borrador guardado con éxito en la base de datos'})
        except Exception as e:
            db.session.rollback()
            return jsonify({'error': 'Hubo un error con el driver MySQL', 'details': str(e)})


#Api para mostrar listado de borradores en la bd
@app.route('/api/borradores', methods=['GET'])
def lista_borradores():
    if request.method == 'GET':
        borradores = Borrador.query.all()

        return jsonify([borrador.as_dict() for borrador in borradores])


#Dentro de cada borrador quiero poder modificar los campos de cada uno de los borradores hasta que tenga todos los datos
#y crear una receta
@app.route('/api/borradores/<int:borrador_id>', methods=['GET', 'PUT', 'DELETE'])
def detalle_borrador(borrador_id):
    borrador = Borrador.query.get_or_404(borrador_id)

    if request.method == 'GET':
        return jsonify(borrador.as_dict())

    if request.method == 'PUT':
        if request.content_type == 'application/json': #si el contenido es un json porq viene de swagger aplica esto
            data = request.get_json()
        else:
            data = request.form.to_dict() # si quiero editarlo desde el html tengo que usar esto

        borrador.titulo_receta = data.get('titulo_receta', borrador.titulo_receta)
        borrador.descripcion = data.get('descripcion', borrador.descripcion)
        borrador.categoria_id = data.get('categoria_id', borrador.categoria_id)
        borrador.tiempo_preparacion = data.get('tiempo_preparacion', borrador.tiempo_preparacion)
        borrador.foto1 = data.get('foto1', borrador.foto1)
        borrador.foto2 = data.get('foto2', borrador.foto2)
        borrador.foto3 = data.get('foto3', borrador.foto3)
        borrador.foto4 = data.get('foto4', borrador.foto4)
        borrador.foto5 = data.get('foto5', borrador.foto5)
        borrador.pasos = data.get('pasos', borrador.pasos)

        db.session.commit()
        return jsonify({'mensaje': 'Borrador actualizado exitosamente'})

    if request.method == 'DELETE':
        db.session.delete(borrador)
        db.session.commit()
        return jsonify({'mensaje': 'Borrador eliminado exitosamente'})
    
@app.route('/api/guardar_como_receta/<int:borrador_id>', methods=['POST'])
def guardar_como_receta(borrador_id):
    # Obtener todos los borradores con el borrador_id especifico
    borradores_a_guardar = Borrador.query.filter_by(borrador_id=borrador_id).all()

    if not borradores_a_guardar:
        return jsonify({'error': 'No se encontraron borradores con el ID especificado'})

    # Crear una lista de diccionarios con los datos de los borradores
    datos_recetas = []
    for borrador in borradores_a_guardar:
        datos_receta = {
            'titulo_receta': borrador.titulo_receta,
            'descripcion': borrador.descripcion,
            'categoria_id': borrador.categoria_id,
            'tiempo_preparacion': borrador.tiempo_preparacion,
            'foto1': borrador.foto1,
            'foto2': borrador.foto2,
            'foto3': borrador.foto3,
            'foto4': borrador.foto4,
            'foto5': borrador.foto5,
            'pasos': borrador.pasos,
            'usuario': borrador.usuario,
        }
        datos_recetas.append(datos_receta)

    try:
        # Realizo una operacion bulk insert para agregar las nuevas recetas a la base de datos
        db.session.bulk_insert_mappings(Receta, datos_recetas)

        # Eliminar los borradores una vez que las recetas se han guardado con exito
        Borrador.query.filter_by(borrador_id=borrador_id).delete()
        db.session.commit()

        return jsonify({'mensaje': 'Recetas guardadas exitosamente'})
    except Exception as e:
        db.session.rollback()
        return jsonify({'error': 'Hubo un error al guardar las recetas', 'details': str(e)})

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(host='0.0.0.0', port=5001,debug=True)
