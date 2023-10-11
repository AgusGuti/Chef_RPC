from flask import Flask, request, render_template, jsonify
from flask_sqlalchemy import SQLAlchemy
import csv
import io

app = Flask(__name__)

# Configura la base de datos

DB_USERNAME = 'root'
DB_PASSWORD = 'root'
DB_HOST = '127.0.0.1'
DB_PORT = '3306'
DB_NAME = 'csvmicroservice'

# Configure SQLAlchemy to use MySQL and set the URI with 'pymysql' driver
app.config['SQLALCHEMY_DATABASE_URI'] = f'mysql+pymysql://{DB_USERNAME}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/{DB_NAME}'

# Initialize SQLAlchemy with the app
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

    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}

@app.route('/borradores', methods=['GET'])
def borradores():
    borradores = Borrador.query.all()
    grouped_borradores = {}  # Un diccionario para agrupar los borradores por borrador_id

    for borrador in borradores:
        borrador_id = borrador.borrador_id
        if borrador_id not in grouped_borradores:
            grouped_borradores[borrador_id] = []  # Inicializa una lista vacía para cada borrador_id
        grouped_borradores[borrador_id].append(borrador)

    return render_template('borradores.html', grouped_borradores=grouped_borradores)

@app.route('/editar_borrador/<int:borrador_id>', methods=['GET', 'POST'])
def editar_borrador(borrador_id):
    borrador = Borrador.query.get(borrador_id)

    if request.method == 'POST':
        # Procesar los datos enviados por el formulario de edición
        borrador.descripcion = request.form['descripcion']
        borrador.categoria_id = request.form['categoria_id']
        borrador.tiempo_preparacion = request.form['tiempo_preparacion']

        
        db.session.commit()
        return redirect(url_for('borradores'))

    return render_template('editar_borrador.html', borrador=borrador)

@app.route('/upload_csv', methods=['GET', 'POST'])
def upload_csv():
    if request.method == 'POST':
        # Tengo que obtener el contador maximo de borrador si no pierdo el id
        max_borrador_id = db.session.query(db.func.max(Borrador.borrador_id)).scalar()

        # Si cargas un csv nuevo +1 al contador en caso de ser el primero es 1
        if max_borrador_id is not None:
            max_borrador_id += 1
        else:
            max_borrador_id = 1

        # Compruebo si subiste el archivo
        if 'file' not in request.files:
            return jsonify({'error': 'No subiste el archivo csv'})

        file = request.files['file']

        # Compruebo si esta vacio
        if file.filename == '':
            return jsonify({'error': 'Csv vacio'})

        # Compruebo extension csv
        if not file.filename.endswith('.csv'):
            return jsonify({'error': 'Extension incorrecta tenes que subir un csv'})

        # Modulo de lectura de csv
        try:
            csv_data = []
            # Uso el reader para abrir el archivo y comienzo a leer con formato utf-8
            reader = csv.DictReader(io.TextIOWrapper(file, 'utf-8'))
            for row in reader:
                # Asigno el  contador al nuevo borrador
                row['borrador_id'] = max_borrador_id
                csv_data.append(row)
        except Exception as e:
            return jsonify({'error': 'Error parsing CSV file', 'details': str(e)})

        # Ahora tomo los datos leidos y los guardo en la base de datos como borrador
        for row in csv_data:
            try:
                borrador = Borrador(
                    titulo_receta=row['titulo_receta'],
                    descripcion=row['descripcion'],
                    categoria_id=row['categoria_id'],
                    tiempo_preparacion=row['tiempo_preparacion'],
                    borrador_id=row['borrador_id']  
                )
                db.session.add(borrador)
            except Exception as e:
                return jsonify({'error': 'Error al insertar datos en la base de datos borraor', 'details': str(e)})

        # Guardo los cambios en la base 
        try:
            db.session.commit()
            return jsonify({'success': 'Borrador Guardado con exito en la bd '})
        except Exception as e:
            db.session.rollback()
            return jsonify({'error': 'Hubo un error con el driver mysql', 'details': str(e)})

    # Renderizo la pagina upload_csv para poder subir el archivo
    return render_template('upload_csv.html')

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
    #retorno el objeto que pertenece al borrador id...
    if request.method == 'GET':
        return jsonify(borrador.as_dict())
        #modificacion de objeto que pertenece al borrador
    if request.method == 'PUT':
        data = request.get_json()
        borrador.titulo_receta = data['titulo_receta']
        borrador.descripcion = data['descripcion']
        borrador.categoria_id = data['categoria_id']
        borrador.tiempo_preparacion = data['tiempo_preparacion']
        borrador.foto1 = data['foto1']
        borrador.foto2 = data['foto2']
        borrador.foto3 = data['foto3']
        borrador.foto4 = data['foto4']
        borrador.foto5 = data['foto5']
        borrador.pasos = data['pasos']
        db.session.commit()
        return jsonify({'mensaje': 'Borrador actualizado exitosamente'})
        #Work in progress todavia
    if request.method == 'DELETE':
        db.session.delete(borrador)
        db.session.commit()
        return jsonify({'mensaje': 'Borrador eliminado exitosamente'})

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(debug=True)
