# Chef_RPC


Comandos Apache Kafka:


▶️ Iniciar Zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

▶️ Iniciar Kafka
.\bin\windows\kafka-server-start.bat .\config\server.properties

▶️ Listar todos los topics que existen dentro del broker
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092


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

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/popularidadReceta.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/popularidadUser.proto

   
   
   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/comentario.proto;

4. python main.py

## BD MYSQL

1. Crear base de datos chefencasa en mysql antes de ejecutar los servicios.

## EJECUCIÓN

1. Una vez corriendo ambos servicios se accede al front desde: http://localhost:5000


https://kafka-python.readthedocs.io/en/master/apidoc/KafkaConsumer.html
