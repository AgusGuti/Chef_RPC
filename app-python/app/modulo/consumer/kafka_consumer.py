from confluent_kafka import Consumer, KafkaError

# Configuración de Kafka
kafka_config = {
    'bootstrap.servers': 'localhost:9092',  # Dirección del broker de Kafka
    'group.id': 'mi-grupo',                 # ID del grupo de consumidores
    'auto.offset.reset': 'earliest'         # Comportamiento en caso de no tener un offset inicial
}

# Crea un consumidor Kafka
consumer = Consumer(kafka_config)

# Suscribe el consumidor al topic "Novedades"
consumer.subscribe(['Novedades'])

# Función para manejar los mensajes de Kafka
def kafka_consumer():
    consumer = Consumer(kafka_config)
    consumer.subscribe(['Novedades'])

    try:
        while True:
            msg = consumer.poll(1.0)

            if msg is None:
                continue
            if msg.error():
                if msg.error().code() == KafkaError._PARTITION_EOF:
                    print('Reached end of partition')
                else:
                    print('Error: %s' % (msg.error()))
            else:
                mensaje = msg.value().decode('utf-8')
                nombre_usuario, titulo_receta, url_foto = mensaje.split(',')
                
                # Realiza las acciones necesarias con la información recibida
                print('Nuevo mensaje de Kafka:')
                print('Nombre de Usuario:', nombre_usuario)
                print('Título de Receta:', titulo_receta)
                print('URL de la Foto:', url_foto)

    except KeyboardInterrupt:
        pass

    finally:
        consumer.close()

