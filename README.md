# Chef_RPC

SERVIDOR JAVA RPC

sdk install java 20.0.2-amzn

cd app-java
mvn clean install -DskipTests
mvn spring-boot:run

CLIENTE/SERVIDOR PYTHON 

cd app-python
pip install -r requirements.txt
python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/account.proto
flask run