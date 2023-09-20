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
    __slots__ = ["user"]
    USER_FIELD_NUMBER: _ClassVar[int]
    user: _containers.RepeatedCompositeFieldContainer[Favoritos]
    def __init__(self, user: _Optional[_Iterable[_Union[Favoritos, _Mapping]]] = ...) -> None: ...

class Favorito(_message.Message):
    __slots__ = ["id", "userId", "RecetaId"]
    ID_FIELD_NUMBER: _ClassVar[int]
    USERID_FIELD_NUMBER: _ClassVar[int]
    RECETAID_FIELD_NUMBER: _ClassVar[int]
    id: int
    userId: _user_pb2.User
    RecetaId: _receta_pb2.Receta
    def __init__(self, id: _Optional[int] = ..., userId: _Optional[_Union[_user_pb2.User, _Mapping]] = ..., RecetaId: _Optional[_Union[_receta_pb2.Receta, _Mapping]] = ...) -> None: ...

class FlagFavorito(_message.Message):
    __slots__ = ["flagExiste"]
    FLAGEXISTE_FIELD_NUMBER: _ClassVar[int]
    flagExiste: bool
    def __init__(self, flagExiste: bool = ...) -> None: ...
