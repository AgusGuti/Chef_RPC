# Chef_RPC


Comandos Apache Kafka:


▶️ Iniciar Zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

▶️ Iniciar Kafka
.\bin\windows\kafka-server-start.bat .\config\server.properties

▶️ Crea un nuevo topic en el servidor de kafka
.\bin\windows\kafka-topics.bat --create --topic {topic-name} --bootstrap-server localhost:9092

▶️ Decribir los detalles de un topic
.\bin\windows\kafka-topics.bat --describe --topic {topic-name} --bootstrap-server localhost:9092

▶️ Listar todos los topics que existen dentro del broker
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

▶️ Inicia una consola para ver mensajes de un topic específico
.\bin\windows\kafka-console-consumer.bat --topic {nombreTopic} --bootstrap-server localhost:9092

▶️ Inicia una consola para enviar mensajes a un topic específico
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic {topic-name}

Clases creadas en capa servidor:

.Categoría
.Receta
.User
.Seguidores
.Seguidos
.Favoritos
.Ingredientes
.Subcategoria

## Restante

-Solucionar la carga del objeto categoría dentro de la clase receta.

-Falta poder cargar foto de perfil al registrarse y mostrarla en Mi Perfil. SOLUCIÓN: cargar archivo de tipo .png web directamente en la base.
-Falta implementar poder dejar de seguir, evitar que me sigan (F. de Obs: 17/09/2023)
-Falta poder marcar publicacion como favorito al verla en STORYLINE (F. de Obs: 15/09/2023)

-No levantó correctmente las recetas de los INSERT (F. de Obs: 19/09/2023)
(OPCIONAL, las recetas generadas desde la pagina funcionan bien)

## SERVIDOR JAVA GRPC

### Version JAVA:

- JDK 17

### Comandos terminal:

1. cd app-java
2. mvn clean install -DskipTests
3. mvn spring-boot:run
   
4. Correr Inserts_alt.sql (para tener para test) (OPCIONAL)

## CLIENTE/SERVIDOR PYTHON 

### Version Python:  

- Python 3.9.13

### Comandos terminal:

1. cd app-python
2. pip install -r requirements.txt
3. Si se modifica del lado del server de las clases ejecutar nuevamente:
   
   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/user.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/receta.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/categoria.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/ingrediente.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/seguido.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/favorito.proto


4. python main.py

## BD MYSQL

1. Crear base de datos chefencasa en mysql antes de ejecutar los servicios.

## EJECUCIÓN

1. Una vez corriendo ambos servicios se accede al front desde: http://localhost:5000
