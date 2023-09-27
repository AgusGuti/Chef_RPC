from confluent_kafka import Consumer, KafkaError

import logging

logger = logging.getLogger(__name__)

# Configuración de Kafka
kafka_config = {
    'bootstrap.servers': 'localhost:9092',  # Dirección del broker de Kafka
    'group.id': 'test-consumer-group',      # ID del grupo de consumidores
    "default.topic.config": {"auto.offset.reset": "earliest"},
    "enable.auto.commit": False,  # Comportamiento en caso de no tener un offset inicial
}


# Función para manejar los mensajes de Kafka
def kafka_consumer():
   # Crea un consumidor Kafka
   consumer = Consumer(kafka_config)
   
   # Suscribe el consumidor al topic "Novedades"
   consumer.subscribe(['novedades'])

   try:
       while True:
           msg = consumer.poll(1.0)  # Espera hasta que llegue un mensaje por 1 segundo
           
           if msg is None:
               continue
           
           if msg.error():
               if msg.error().code() == KafkaError._PARTITION_EOF:
                   print('Reached end of partition')
               else:
                   print('Error: %s' % (msg.error()))
           else:
               # Procesa el mensaje recibido
               mensaje = msg.value().decode('utf-8')
               # Divide el mensaje en sus componentes (nombre de usuario, título de receta, URL de la foto)
               nombre_usuario, titulo_receta, url_foto = mensaje.split(',')
            
               # Realiza las acciones necesarias con la información recibida, por ejemplo, almacenarla en una base de datos o mostrarla en la aplicación.
               print('Nuevo mensaje de Kafka:')
               print('Nombre de Usuario:', nombre_usuario)
               print('Título de Receta:', titulo_receta)
               print('URL de la Foto:', url_foto)

   except KeyboardInterrupt:
       pass

   finally:
       # Cierra el consumidor de Kafka de manera adecuada al finalizar
       consumer.close()

