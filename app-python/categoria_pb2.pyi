from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Categorias(_message.Message):
    __slots__ = ["categoria"]
    CATEGORIA_FIELD_NUMBER: _ClassVar[int]
    categoria: _containers.RepeatedCompositeFieldContainer[Categoria]
    def __init__(self, categoria: _Optional[_Iterable[_Union[Categoria, _Mapping]]] = ...) -> None: ...

class Categoria(_message.Message):
    __slots__ = ["id", "categoria"]
    ID_FIELD_NUMBER: _ClassVar[int]
    CATEGORIA_FIELD_NUMBER: _ClassVar[int]
    id: int
    categoria: str
    def __init__(self, id: _Optional[int] = ..., categoria: _Optional[str] = ...) -> None: ...
