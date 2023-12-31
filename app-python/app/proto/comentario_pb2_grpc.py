# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

from . import comentario_pb2 as comentario__pb2
from . import receta_pb2 as receta__pb2


class ComentariosServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.findAllByReceta = channel.unary_unary(
                '/model.ComentariosService/findAllByReceta',
                request_serializer=comentario__pb2.Comentario.SerializeToString,
                response_deserializer=comentario__pb2.Comentarios.FromString,
                )
        self.GuardarComentario = channel.unary_unary(
                '/model.ComentariosService/GuardarComentario',
                request_serializer=comentario__pb2.Comentario.SerializeToString,
                response_deserializer=comentario__pb2.Comentario.FromString,
                )


class ComentariosServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def findAllByReceta(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def GuardarComentario(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_ComentariosServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'findAllByReceta': grpc.unary_unary_rpc_method_handler(
                    servicer.findAllByReceta,
                    request_deserializer=comentario__pb2.Comentario.FromString,
                    response_serializer=comentario__pb2.Comentarios.SerializeToString,
            ),
            'GuardarComentario': grpc.unary_unary_rpc_method_handler(
                    servicer.GuardarComentario,
                    request_deserializer=comentario__pb2.Comentario.FromString,
                    response_serializer=comentario__pb2.Comentario.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'model.ComentariosService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class ComentariosService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def findAllByReceta(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.ComentariosService/findAllByReceta',
            comentario__pb2.Comentario.SerializeToString,
            comentario__pb2.Comentarios.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def GuardarComentario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.ComentariosService/GuardarComentario',
            comentario__pb2.Comentario.SerializeToString,
            comentario__pb2.Comentario.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
