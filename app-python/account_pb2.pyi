from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Accounts(_message.Message):
    __slots__ = ["account"]
    ACCOUNT_FIELD_NUMBER: _ClassVar[int]
    account: _containers.RepeatedCompositeFieldContainer[Account]
    def __init__(self, account: _Optional[_Iterable[_Union[Account, _Mapping]]] = ...) -> None: ...

class Account(_message.Message):
    __slots__ = ["id", "number", "customer_id"]
    ID_FIELD_NUMBER: _ClassVar[int]
    NUMBER_FIELD_NUMBER: _ClassVar[int]
    CUSTOMER_ID_FIELD_NUMBER: _ClassVar[int]
    id: int
    number: str
    customer_id: int
    def __init__(self, id: _Optional[int] = ..., number: _Optional[str] = ..., customer_id: _Optional[int] = ...) -> None: ...
