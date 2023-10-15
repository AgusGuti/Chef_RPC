import connexion

from soap_server import MiServicio

app = connexion.App(__name__, specification_dir='./')
app.add_api('swagger.yaml', arguments={'title': 'Mi API SOAP'})
application = app.app

if __name__ == '__main__':
    app.run(port=8080)
