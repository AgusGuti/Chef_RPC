from flask import Flask,jsonify,request
import grpc
import account_pb2
import account_pb2_grpc

import os
from dotenv import load_dotenv
load_dotenv()



app = Flask(__name__)


@app.route("/findAll")
def findAll():
    app.logger.info("/findAll")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.FindAll(account_pb2.Accounts())
    print("Greeter client received: " + str(response))    
    return str(response)

@app.route("/addAccount",methods = ['GET'])
def findByNumber():
    app.logger.info("/addAccount",request.args['number'])
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.AddAccount(account_pb2.Account(number="888888",customer_id=2))
    print("Greeter client received: " + str(response))    
    return str(response)