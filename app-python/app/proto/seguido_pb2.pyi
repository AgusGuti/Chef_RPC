from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
import user_pb2 as _user_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Seguidos(_message.Message):
    __slots__ = ["user"]
    USER_FIELD_NUMBER: _ClassVar[int]
    user: _containers.RepeatedCompositeFieldContainer[Seguidos]
    def __init__(self, user: _Optional[_Iterable[_Union[Seguidos, _Mapping]]] = ...) -> None: ...

class FlagSeguido(_message.Message):
    __slots__ = ["flagExiste"]
    FLAGEXISTE_FIELD_NUMBER: _ClassVar[int]
    flagExiste: bool
    def __init__(self, flagExiste: bool = ...) -> None: ...

class Seguido(_message.Message):
    __slots__ = ["id", "user", "seguido"]
    ID_FIELD_NUMBER: _ClassVar[int]
    USER_FIELD_NUMBER: _ClassVar[int]
    SEGUIDO_FIELD_NUMBER: _ClassVar[int]
    id: int
    user: _user_pb2.User
    seguido: _user_pb2.User
    def __init__(self, id: _Optional[int] = ..., user: _Optional[_Union[_user_pb2.User, _Mapping]] = ..., seguido: _Optional[_Union[_user_pb2.User, _Mapping]] = ...) -> None: ...
