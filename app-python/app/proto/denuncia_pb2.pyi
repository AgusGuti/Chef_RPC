from google.protobuf import empty_pb2 as _empty_pb2
import user_pb2 as _user_pb2
import receta_pb2 as _receta_pb2
import motivo_pb2 as _motivo_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Denuncias(_message.Message):
    __slots__ = ["denuncia"]
    DENUNCIA_FIELD_NUMBER: _ClassVar[int]
    denuncia: _containers.RepeatedCompositeFieldContainer[Denuncia]
    def __init__(self, denuncia: _Optional[_Iterable[_Union[Denuncia, _Mapping]]] = ...) -> None: ...

class Denuncia(_message.Message):
    __slots__ = ["id", "user_id", "receta_id", "resuelta", "motivo"]
    ID_FIELD_NUMBER: _ClassVar[int]
    USER_ID_FIELD_NUMBER: _ClassVar[int]
    RECETA_ID_FIELD_NUMBER: _ClassVar[int]
    RESUELTA_FIELD_NUMBER: _ClassVar[int]
    MOTIVO_FIELD_NUMBER: _ClassVar[int]
    id: int
    user_id: _user_pb2.User
    receta_id: _receta_pb2.Receta
    resuelta: str
    motivo: _motivo_pb2.Motivo
    def __init__(self, id: _Optional[int] = ..., user_id: _Optional[_Union[_user_pb2.User, _Mapping]] = ..., receta_id: _Optional[_Union[_receta_pb2.Receta, _Mapping]] = ..., resuelta: _Optional[str] = ..., motivo: _Optional[_Union[_motivo_pb2.Motivo, _Mapping]] = ...) -> None: ...
