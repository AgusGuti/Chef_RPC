from flask import Flask
import grpc
import account_pb2
import account_pb2_grpc

app = Flask(__name__)

@app.route("/")
def account():
    print("Will try to greet world ...")
    with grpc.insecure_channel("localhost:9090") as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.FindAll(account_pb2.Accounts())
    print("Greeter client received: " + response.message)    
    return "<p>Hello, World!</p>"