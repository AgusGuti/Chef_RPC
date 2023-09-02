# Chef_RPC

SERVIDOR JAVA GRPC

comandos terminal:
cd app-java
mvn clean install -DskipTests
mvn spring-boot:run

CLIENTE/SERVIDOR PYTHON 

comandos terminal:
cd app-python
pip install -r requirements.txt
python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/account.proto
flask run