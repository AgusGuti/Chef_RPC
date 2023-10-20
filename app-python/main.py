from app import create_app
from flask import render_template
from argparse import ArgumentParser
from multiprocessing import Pool
import schedule
import time
from threading import Thread
from app.modulo.popularidadReceta.PopularidadRecetaController import popularidadReceta
from app.modulo.popularidadUser.PopularidadUserController import popularidadUsuario
from app.modulo.comentario.ComentarioController import comentario


app = create_app('flask.cfg')

# Definimos una ruta para la página principal que renderiza la plantilla 'login.html'
@app.route("/", methods=["GET"])
def home():
    return render_template('login.html')

# Definimos una función para ejecutar tareas programadas
# def run_scheduler():
#     with app.app_context():  # Contexto de la aplicación
        
#         # Creamos trabajos programados que ejecutan cada 1 hora
#         schedule.every(1).hour.do(popularidadReceta)
#         schedule.every(1).hour.do(popularidadUsuario)
#         schedule.every(1).hour.do(comentario)
        
#         #schedule.every(1).minutes.do(popularidadReceta)
#         #schedule.every(1).minutes.do(popularidadUsuario)
      

#         # Se ejecuta la planificación en un hilo en segundo plano
#         while True:
#             schedule.run_pending() # Se Ejecuta las tareas programadas pendientes
#             time.sleep(1) # Se Pausa la ejecución durante 1 segundo

# # Se inicia la planificación en un hilo en segundo plano
# scheduler_thread = Thread(target=run_scheduler)
# scheduler_thread.start()

if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument('-p', '--port', default=5000, type=int, help='port to listen on')
    args = parser.parse_args()
    port = args.port

    app.run(host='0.0.0.0', port=port)