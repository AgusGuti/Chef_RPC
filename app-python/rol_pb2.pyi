from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Rols(_message.Message):
    __slots__ = ["rol"]
    ROL_FIELD_NUMBER: _ClassVar[int]
    rol: _containers.RepeatedCompositeFieldContainer[Rol]
    def __init__(self, rol: _Optional[_Iterable[_Union[Rol, _Mapping]]] = ...) -> None: ...

class Rol(_message.Message):
    __slots__ = ["idRol", "rol"]
    IDROL_FIELD_NUMBER: _ClassVar[int]
    ROL_FIELD_NUMBER: _ClassVar[int]
    idRol: int
    rol: str
    def __init__(self, idRol: _Optional[int] = ..., rol: _Optional[str] = ...) -> None: ...
