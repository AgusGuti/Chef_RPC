from app import create_app
from flask import render_template
from argparse import ArgumentParser
from multiprocessing import Pool
from app.modulo.consumer import kafka_consumer  # Importamos la función kafka_consumer

app = create_app('flask.cfg')

@app.route("/", methods=["GET"])
def home():
    return render_template('login.html')

if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument('-p', '--port', default=5000, type=int, help='port to listen on')
    args = parser.parse_args()
    port = args.port
    
    # Crear un pool de procesos con un solo proceso
    with Pool(processes=1) as pool:
        # Iniciar el proceso de kafka_consumer en segundo plano
        pool.apply_async(kafka_consumer)

        # Ejecutar la aplicación Flask en el proceso principal
        app.run(host='0.0.0.0', port=port)