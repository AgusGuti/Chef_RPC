# Chef_RPC

Clases creadas en capa servidor:

.Categoría
.Receta
.User
.Seguidores
.Seguidos
.Favoritos
.Ingredientes

## SERVIDOR JAVA GRPC

comandos terminal:

1. cd app-java
2. mvn clean install -DskipTests
3. mvn spring-boot:run

## CLIENTE/SERVIDOR PYTHON 

Version python:  
Python 3.9.13

comandos terminal:

1. cd app-python
2. pip install -r requirements.txt
3. python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/account.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/user.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/rol.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/receta.proto

4. flask run
