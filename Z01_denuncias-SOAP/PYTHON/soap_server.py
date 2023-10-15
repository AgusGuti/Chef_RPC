from spyne import Application, rpc, ServiceBase, Integer
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from wsgiref.simple_server import make_server

class MiServicio(ServiceBase):
    @rpc(Integer, _returns=Integer)
    def multiplicar(ctx, numero):
        return numero * 2

soap_app = Application([MiServicio],
                       tns='tu.namespace',
                       in_protocol=Soap11(validator='lxml'),
                       out_protocol=Soap11())

wsgi_app = WsgiApplication(soap_app)

if __name__ == '__main__':
    server = make_server('127.0.0.1', 8000, wsgi_app)
    server.serve_forever()
