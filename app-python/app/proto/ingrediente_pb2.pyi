from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Ingredientes(_message.Message):
    __slots__ = ["ingrediente"]
    INGREDIENTE_FIELD_NUMBER: _ClassVar[int]
    ingrediente: _containers.RepeatedCompositeFieldContainer[Ingrediente]
    def __init__(self, ingrediente: _Optional[_Iterable[_Union[Ingrediente, _Mapping]]] = ...) -> None: ...

class Ingrediente(_message.Message):
    __slots__ = ["id", "ingrediente"]
    ID_FIELD_NUMBER: _ClassVar[int]
    INGREDIENTE_FIELD_NUMBER: _ClassVar[int]
    id: int
    ingrediente: str
    def __init__(self, id: _Optional[int] = ..., ingrediente: _Optional[str] = ...) -> None: ...
