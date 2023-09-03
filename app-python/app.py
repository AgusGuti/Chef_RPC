#from app import app
#from tables import Results
#from db_config import mysql

from flask_table import Table, Col, LinkCol
from flask import flash, render_template, request, redirect, jsonify
from flask import Flask
from logging.config import dictConfig

from google.protobuf.json_format import MessageToDict, MessageToJson


import grpc
import account_pb2
import account_pb2_grpc

import user_pb2
import user_pb2_grpc

import os
from dotenv import load_dotenv
load_dotenv()


dictConfig({
    'version': 1,
    'formatters': {'default': {
        'format': '[%(asctime)s] %(levelname)s in %(module)s: %(message)s',
    }},
    'handlers': {'wsgi': {
        'class': 'logging.StreamHandler',
        'stream': 'ext://flask.logging.wsgi_errors_stream',
        'formatter': 'default'
    }},
    'root': {
        'level': 'INFO',
        'handlers': ['wsgi']
    }
})


#MOCK TABLA
class ItemTable(Table):
    name = Col('Name')
    description = Col('Description')
        
class Item(object):
    def __init__(self, name, description):
        self.name = name
        self.description = description
        
items = [Item('Name1', 'Description1'),
         Item('Name2', 'Description2'),
         Item('Name3', 'Description3')]



app = Flask(__name__)

#Adding routes for (add), (update), (delete)
@app.route('/')
def users():
	table = ItemTable(items)
	table.border = True
	return render_template('users.html', table=table)


@app.route('/new_user')
def add_user_view():
	return render_template('add.html')

@app.route('/add', methods=['POST'])
def add_user():
	_name = request.form['inputName']
	_email = request.form['inputEmail']
	_password = request.form['inputPassword']
	# validate the received values
	if _name and _email and _password and request.method == 'POST':
		flash('User added successfully!')
		return redirect('/')
	else:
		return 'Error while adding user'

@app.route("/findAll")
def findAll():
    app.logger.info("/findAll")
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.FindAll(account_pb2.Accounts())
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)

#TO DO JSON POST
@app.route("/addAccount",methods = ['GET'])
def addAccount():
    app.logger.info("/addAccount",request.args['number'])
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.AddAccount(account_pb2.Account(number="888888",customer_id=2))
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)


@app.route("/findByCustomer",methods = ['GET'])
def findByCustomer():
    app.logger.info("/findByCustomer %s",request.args.get('customer_id'))
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)        
        response = stub.FindByCustomer(account_pb2.Account(customer_id=int(request.args.get('customer_id'))))
    print("Greeter client received: " + str(response))        
    return MessageToJson(response)


@app.route("/findByNumber",methods = ['GET'])
def findByNumber():
    app.logger.info("/findByNumber %s",request.args.get('number'))
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.FindByNumber(account_pb2.Account(number=str(request.args.get('number'))))
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)


@app.route("/addUser",methods = ['POST'])
def addUser():
    app.logger.info("/addUser",request.get_json())
    user=request.get_json()
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = user_pb2_grpc.UsersServiceStub(channel)
        response = stub.AddUser(user_pb2.User(id=user['id'],email=user['email'],name=user['email'],nick=user['nick'],password=user['password'],role=user['role'],surname=user['surname']))
    print("Greeter client received: " + str(response))    
    return MessageToJson(response)