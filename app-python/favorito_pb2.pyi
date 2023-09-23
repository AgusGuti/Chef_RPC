from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
import user_pb2 as _user_pb2
import receta_pb2 as _receta_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Favoritos(_message.Message):
    __slots__ = ["favorito"]
    FAVORITO_FIELD_NUMBER: _ClassVar[int]
    favorito: _containers.RepeatedCompositeFieldContainer[Favorito]
    def __init__(self, favorito: _Optional[_Iterable[_Union[Favorito, _Mapping]]] = ...) -> None: ...

class Favorito(_message.Message):
    __slots__ = ["id", "user", "receta"]
    ID_FIELD_NUMBER: _ClassVar[int]
    USER_FIELD_NUMBER: _ClassVar[int]
    RECETA_FIELD_NUMBER: _ClassVar[int]
    id: int
    user: _user_pb2.User
    receta: _receta_pb2.Receta
    def __init__(self, id: _Optional[int] = ..., user: _Optional[_Union[_user_pb2.User, _Mapping]] = ..., receta: _Optional[_Union[_receta_pb2.Receta, _Mapping]] = ...) -> None: ...

class FlagFavorito(_message.Message):
    __slots__ = ["flagExiste"]
    FLAGEXISTE_FIELD_NUMBER: _ClassVar[int]
    flagExiste: bool
    def __init__(self, flagExiste: bool = ...) -> None: ...
