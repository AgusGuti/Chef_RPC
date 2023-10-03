from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
import user_pb2 as _user_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class PopularidadUsers(_message.Message):
    __slots__ = ["popularidadUser"]
    POPULARIDADUSER_FIELD_NUMBER: _ClassVar[int]
    popularidadUser: _containers.RepeatedCompositeFieldContainer[PopularidadUser]
    def __init__(self, popularidadUser: _Optional[_Iterable[_Union[PopularidadUser, _Mapping]]] = ...) -> None: ...

class PopularidadUser(_message.Message):
    __slots__ = ["id", "nombreUsuario", "puntaje", "user"]
    ID_FIELD_NUMBER: _ClassVar[int]
    NOMBREUSUARIO_FIELD_NUMBER: _ClassVar[int]
    PUNTAJE_FIELD_NUMBER: _ClassVar[int]
    USER_FIELD_NUMBER: _ClassVar[int]
    id: int
    nombreUsuario: str
    puntaje: str
    user: _user_pb2.User
    def __init__(self, id: _Optional[int] = ..., nombreUsuario: _Optional[str] = ..., puntaje: _Optional[str] = ..., user: _Optional[_Union[_user_pb2.User, _Mapping]] = ...) -> None: ...
