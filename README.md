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
python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=./proto --pyi_out=./proto --grpc_python_out=./proto ../app-java/src/main/proto/account.proto
flask run