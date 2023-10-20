from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Motivos(_message.Message):
    __slots__ = ["motivo"]
    MOTIVO_FIELD_NUMBER: _ClassVar[int]
    motivo: _containers.RepeatedCompositeFieldContainer[Motivo]
    def __init__(self, motivo: _Optional[_Iterable[_Union[Motivo, _Mapping]]] = ...) -> None: ...

class Motivo(_message.Message):
    __slots__ = ["id", "motivo"]
    ID_FIELD_NUMBER: _ClassVar[int]
    MOTIVO_FIELD_NUMBER: _ClassVar[int]
    id: int
    motivo: str
    def __init__(self, id: _Optional[int] = ..., motivo: _Optional[str] = ...) -> None: ...
