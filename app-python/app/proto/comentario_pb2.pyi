from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
import receta_pb2 as _receta_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Comentarios(_message.Message):
    __slots__ = ["comentario"]
    COMENTARIO_FIELD_NUMBER: _ClassVar[int]
    comentario: _containers.RepeatedCompositeFieldContainer[Comentario]
    def __init__(self, comentario: _Optional[_Iterable[_Union[Comentario, _Mapping]]] = ...) -> None: ...

class Comentario(_message.Message):
    __slots__ = ["id", "recetaComentada", "usuarioComentario", "comentario", "receta"]
    ID_FIELD_NUMBER: _ClassVar[int]
    RECETACOMENTADA_FIELD_NUMBER: _ClassVar[int]
    USUARIOCOMENTARIO_FIELD_NUMBER: _ClassVar[int]
    COMENTARIO_FIELD_NUMBER: _ClassVar[int]
    RECETA_FIELD_NUMBER: _ClassVar[int]
    id: int
    recetaComentada: str
    usuarioComentario: str
    comentario: str
    receta: _receta_pb2.Receta
    def __init__(self, id: _Optional[int] = ..., recetaComentada: _Optional[str] = ..., usuarioComentario: _Optional[str] = ..., comentario: _Optional[str] = ..., receta: _Optional[_Union[_receta_pb2.Receta, _Mapping]] = ...) -> None: ...
