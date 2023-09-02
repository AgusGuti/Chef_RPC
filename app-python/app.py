#from app import app
#from tables import Results
#from db_config import mysql

from flask_table import Table, Col, LinkCol
from flask import flash, render_template, request, redirect
from flask import Flask
import grpc
import account_pb2
import account_pb2_grpc

import os
from dotenv import load_dotenv
load_dotenv()




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
    return str(response)

@app.route("/addAccount",methods = ['GET'])
def addAccount():
    app.logger.info("/addAccount",request.args['number'])
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.AddAccount(account_pb2.Account(number="888888",customer_id=2))
    print("Greeter client received: " + str(response))    
    return str(response)


@app.route("/findByCustomer",methods = ['GET'])
def findByCustomer():
    app.logger.info("/findByCustomer",request.args['customer_id'])
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.FindByCustomer(account_pb2.Account(number="888888",customer_id=2))
    print("Greeter client received: " + str(response))    
    return str(response)


@app.route("/findByNumber",methods = ['GET'])
def findByNumber():
    app.logger.info("/findByNumber",request.args['number'])
    with grpc.insecure_channel(os.getenv("SERVER-JAVA-RPC")) as channel:
        stub = account_pb2_grpc.AccountsServiceStub(channel)
        response = stub.FindByNumber(account_pb2.Account(id=1,number="777777",customer_id=2))
    print("Greeter client received: " + str(response))    
    return str(response)