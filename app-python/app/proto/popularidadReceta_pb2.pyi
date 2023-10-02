from google.protobuf import empty_pb2 as _empty_pb2
import receta_pb2 as _receta_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class PopularidadRecetas(_message.Message):
    __slots__ = ["popularidadReceta"]
    POPULARIDADRECETA_FIELD_NUMBER: _ClassVar[int]
    popularidadReceta: _containers.RepeatedCompositeFieldContainer[PopularidadRecetas]
    def __init__(self, popularidadReceta: _Optional[_Iterable[_Union[PopularidadRecetas, _Mapping]]] = ...) -> None: ...

class PopularidadReceta(_message.Message):
    __slots__ = ["id", "puntaje", "receta"]
    ID_FIELD_NUMBER: _ClassVar[int]
    PUNTAJE_FIELD_NUMBER: _ClassVar[int]
    RECETA_FIELD_NUMBER: _ClassVar[int]
    id: int
    puntaje: str
    receta: _receta_pb2.Receta
    def __init__(self, id: _Optional[int] = ..., puntaje: _Optional[str] = ..., receta: _Optional[_Union[_receta_pb2.Receta, _Mapping]] = ...) -> None: ...
