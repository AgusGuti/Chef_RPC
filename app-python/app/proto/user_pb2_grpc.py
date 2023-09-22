# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from . import categoria_pb2 as categoria__pb2
from . import ingrediente_pb2 as ingrediente__pb2
from . import user_pb2 as user__pb2
from . import user_pb2 as user__pb2


class UsersServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.AddUser = channel.unary_unary(
                '/model.UsersService/AddUser',
                request_serializer=user__pb2.User.SerializeToString,
                response_deserializer=user__pb2.User.FromString,
                )
        self.ValidarCredenciales = channel.unary_unary(
                '/model.UsersService/ValidarCredenciales',
                request_serializer=user__pb2.User.SerializeToString,
                response_deserializer=user__pb2.User.FromString,
                )
        self.TraerUser = channel.unary_unary(
                '/model.UsersService/TraerUser',
                request_serializer=user__pb2.User.SerializeToString,
                response_deserializer=user__pb2.User.FromString,
                )
        self.FindAll = channel.unary_unary(
                '/model.UsersService/FindAll',
                request_serializer=google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
                response_deserializer=user__pb2.Users.FromString,
                )
        self.TraerSeguidos = channel.unary_unary(
                '/model.UsersService/TraerSeguidos',
                request_serializer=user__pb2.User.SerializeToString,
                response_deserializer=user__pb2.Users.FromString,
                )
        self.TraerSeguidores = channel.unary_unary(
                '/model.UsersService/TraerSeguidores',
                request_serializer=user__pb2.User.SerializeToString,
                response_deserializer=user__pb2.Users.FromString,
                )


class UsersServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def AddUser(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def ValidarCredenciales(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def TraerUser(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindAll(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def TraerSeguidos(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def TraerSeguidores(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_UsersServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'AddUser': grpc.unary_unary_rpc_method_handler(
                    servicer.AddUser,
                    request_deserializer=user__pb2.User.FromString,
                    response_serializer=user__pb2.User.SerializeToString,
            ),
            'ValidarCredenciales': grpc.unary_unary_rpc_method_handler(
                    servicer.ValidarCredenciales,
                    request_deserializer=user__pb2.User.FromString,
                    response_serializer=user__pb2.User.SerializeToString,
            ),
            'TraerUser': grpc.unary_unary_rpc_method_handler(
                    servicer.TraerUser,
                    request_deserializer=user__pb2.User.FromString,
                    response_serializer=user__pb2.User.SerializeToString,
            ),
            'FindAll': grpc.unary_unary_rpc_method_handler(
                    servicer.FindAll,
                    request_deserializer=google_dot_protobuf_dot_empty__pb2.Empty.FromString,
                    response_serializer=user__pb2.Users.SerializeToString,
            ),
            'TraerSeguidos': grpc.unary_unary_rpc_method_handler(
                    servicer.TraerSeguidos,
                    request_deserializer=user__pb2.User.FromString,
                    response_serializer=user__pb2.Users.SerializeToString,
            ),
            'TraerSeguidores': grpc.unary_unary_rpc_method_handler(
                    servicer.TraerSeguidores,
                    request_deserializer=user__pb2.User.FromString,
                    response_serializer=user__pb2.Users.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'model.UsersService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class UsersService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def AddUser(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.UsersService/AddUser',
            user__pb2.User.SerializeToString,
            user__pb2.User.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def ValidarCredenciales(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.UsersService/ValidarCredenciales',
            user__pb2.User.SerializeToString,
            user__pb2.User.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def TraerUser(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.UsersService/TraerUser',
            user__pb2.User.SerializeToString,
            user__pb2.User.FromString,
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
        return grpc.experimental.unary_unary(request, target, '/model.UsersService/FindAll',
            google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
            user__pb2.Users.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def TraerSeguidos(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.UsersService/TraerSeguidos',
            user__pb2.User.SerializeToString,
            user__pb2.Users.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def TraerSeguidores(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.UsersService/TraerSeguidores',
            user__pb2.User.SerializeToString,
            user__pb2.Users.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
