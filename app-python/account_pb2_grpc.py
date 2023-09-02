# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import account_pb2 as account__pb2
from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from google.protobuf import wrappers_pb2 as google_dot_protobuf_dot_wrappers__pb2


class AccountsServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.FindByNumber = channel.unary_unary(
                '/model.AccountsService/FindByNumber',
                request_serializer=google_dot_protobuf_dot_wrappers__pb2.StringValue.SerializeToString,
                response_deserializer=account__pb2.Account.FromString,
                )
        self.FindByCustomer = channel.unary_unary(
                '/model.AccountsService/FindByCustomer',
                request_serializer=account__pb2.Account.SerializeToString,
                response_deserializer=account__pb2.Accounts.FromString,
                )
        self.FindAll = channel.unary_unary(
                '/model.AccountsService/FindAll',
                request_serializer=google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
                response_deserializer=account__pb2.Accounts.FromString,
                )
        self.AddAccount = channel.unary_unary(
                '/model.AccountsService/AddAccount',
                request_serializer=account__pb2.Account.SerializeToString,
                response_deserializer=account__pb2.Account.FromString,
                )


class AccountsServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def FindByNumber(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindByCustomer(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindAll(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def AddAccount(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_AccountsServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'FindByNumber': grpc.unary_unary_rpc_method_handler(
                    servicer.FindByNumber,
                    request_deserializer=google_dot_protobuf_dot_wrappers__pb2.StringValue.FromString,
                    response_serializer=account__pb2.Account.SerializeToString,
            ),
            'FindByCustomer': grpc.unary_unary_rpc_method_handler(
                    servicer.FindByCustomer,
                    request_deserializer=account__pb2.Account.FromString,
                    response_serializer=account__pb2.Accounts.SerializeToString,
            ),
            'FindAll': grpc.unary_unary_rpc_method_handler(
                    servicer.FindAll,
                    request_deserializer=google_dot_protobuf_dot_empty__pb2.Empty.FromString,
                    response_serializer=account__pb2.Accounts.SerializeToString,
            ),
            'AddAccount': grpc.unary_unary_rpc_method_handler(
                    servicer.AddAccount,
                    request_deserializer=account__pb2.Account.FromString,
                    response_serializer=account__pb2.Account.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'model.AccountsService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class AccountsService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def FindByNumber(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.AccountsService/FindByNumber',
            google_dot_protobuf_dot_wrappers__pb2.StringValue.SerializeToString,
            account__pb2.Account.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def FindByCustomer(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.AccountsService/FindByCustomer',
            account__pb2.Account.SerializeToString,
            account__pb2.Accounts.FromString,
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
        return grpc.experimental.unary_unary(request, target, '/model.AccountsService/FindAll',
            google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
            account__pb2.Accounts.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def AddAccount(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/model.AccountsService/AddAccount',
            account__pb2.Account.SerializeToString,
            account__pb2.Account.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
