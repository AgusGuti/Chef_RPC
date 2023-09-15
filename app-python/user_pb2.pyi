from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Users(_message.Message):
    __slots__ = ["user"]
    USER_FIELD_NUMBER: _ClassVar[int]
    user: _containers.RepeatedCompositeFieldContainer[User]
    def __init__(self, user: _Optional[_Iterable[_Union[User, _Mapping]]] = ...) -> None: ...

class User(_message.Message):
    __slots__ = ["id", "nombre", "apellido", "email", "clave", "fotoPerfil"]
    ID_FIELD_NUMBER: _ClassVar[int]
    NOMBRE_FIELD_NUMBER: _ClassVar[int]
    APELLIDO_FIELD_NUMBER: _ClassVar[int]
    EMAIL_FIELD_NUMBER: _ClassVar[int]
    CLAVE_FIELD_NUMBER: _ClassVar[int]
    FOTOPERFIL_FIELD_NUMBER: _ClassVar[int]
    id: int
    nombre: str
    apellido: str
    email: str
    clave: str
    fotoPerfil: str
    def __init__(self, id: _Optional[int] = ..., nombre: _Optional[str] = ..., apellido: _Optional[str] = ..., email: _Optional[str] = ..., clave: _Optional[str] = ..., fotoPerfil: _Optional[str] = ...) -> None: ...
