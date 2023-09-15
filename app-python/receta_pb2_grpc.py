# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
import receta_pb2 as receta__pb2


class RecetasServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.AddReceta = channel.unary_unary(
                '/model.RecetasService/AddReceta',
                request_serializer=receta__pb2.Receta.SerializeToString,
                response_deserializer=receta__pb2.Receta.FromString,
                )
        self.FindAll = channel.unary_unary(
                '/model.RecetasService/FindAll',
                request_serializer=google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
                response_deserializer=receta__pb2.Recetas.FromString,
                )


class RecetasServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def AddReceta(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindAll(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_RecetasServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'AddReceta': grpc.unary_unary_rpc_method_handler(
                    servicer.AddReceta,
                    request_deserializer=receta__pb2.Receta.FromString,
                    response_serializer=receta__pb2.Receta.SerializeToString,
            ),
            'FindAll': grpc.unary_unary_rpc_method_handler(
                    servicer.FindAll,
                    request_deserializer=google_dot_protobuf_dot_empty__pb2.Empty.FromString,
                    response_serializer=receta__pb2.Recetas.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'model.RecetasService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class RecetasService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def AddReceta(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.RecetasService/AddReceta',
            receta__pb2.Receta.SerializeToString,
            receta__pb2.Receta.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def FindAll(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.RecetasService/FindAll',
            google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
            receta__pb2.Recetas.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
