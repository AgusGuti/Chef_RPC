# Chef_RPC

SERVIDOR JAVA GRPC

comandos terminal:
cd app-java
mvn clean install -DskipTests
mvn spring-boot:run

CLIENTE/SERVIDOR PYTHON 

version python
Python 3.9.13

comandos terminal:

cd app-python
pip install -r requirements.txt
python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/account.proto

python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/user.proto

python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/rol.proto

flask run