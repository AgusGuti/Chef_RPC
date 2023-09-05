from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf import wrappers_pb2 as _wrappers_pb2
from google.protobuf import timestamp_pb2 as _timestamp_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Empty(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class Ingrediente(_message.Message):
    __slots__ = ["idIngrediente", "ingrediente"]
    IDINGREDIENTE_FIELD_NUMBER: _ClassVar[int]
    INGREDIENTE_FIELD_NUMBER: _ClassVar[int]
    idIngrediente: int
    ingrediente: str
    def __init__(self, idIngrediente: _Optional[int] = ..., ingrediente: _Optional[str] = ...) -> None: ...

class Receta(_message.Message):
    __slots__ = ["idReceta", "idUsuario", "tituloReceta", "descripcion", "Categoria", "pasos", "fechaCreacion", "ingredientes", "tiempoPreparacion", "foto1", "foto2", "foto3", "foto4", "foto5"]
    IDRECETA_FIELD_NUMBER: _ClassVar[int]
    IDUSUARIO_FIELD_NUMBER: _ClassVar[int]
    TITULORECETA_FIELD_NUMBER: _ClassVar[int]
    DESCRIPCION_FIELD_NUMBER: _ClassVar[int]
    CATEGORIA_FIELD_NUMBER: _ClassVar[int]
    PASOS_FIELD_NUMBER: _ClassVar[int]
    FECHACREACION_FIELD_NUMBER: _ClassVar[int]
    INGREDIENTES_FIELD_NUMBER: _ClassVar[int]
    TIEMPOPREPARACION_FIELD_NUMBER: _ClassVar[int]
    FOTO1_FIELD_NUMBER: _ClassVar[int]
    FOTO2_FIELD_NUMBER: _ClassVar[int]
    FOTO3_FIELD_NUMBER: _ClassVar[int]
    FOTO4_FIELD_NUMBER: _ClassVar[int]
    FOTO5_FIELD_NUMBER: _ClassVar[int]
    idReceta: int
    idUsuario: int
    tituloReceta: str
    descripcion: str
    Categoria: str
    pasos: str
    fechaCreacion: _timestamp_pb2.Timestamp
    ingredientes: _containers.RepeatedScalarFieldContainer[str]
    tiempoPreparacion: int
    foto1: str
    foto2: str
    foto3: str
    foto4: str
    foto5: str
    def __init__(self, idReceta: _Optional[int] = ..., idUsuario: _Optional[int] = ..., tituloReceta: _Optional[str] = ..., descripcion: _Optional[str] = ..., Categoria: _Optional[str] = ..., pasos: _Optional[str] = ..., fechaCreacion: _Optional[_Union[_timestamp_pb2.Timestamp, _Mapping]] = ..., ingredientes: _Optional[_Iterable[str]] = ..., tiempoPreparacion: _Optional[int] = ..., foto1: _Optional[str] = ..., foto2: _Optional[str] = ..., foto3: _Optional[str] = ..., foto4: _Optional[str] = ..., foto5: _Optional[str] = ...) -> None: ...

class RecetaResponse(_message.Message):
    __slots__ = ["receta", "mensaje"]
    RECETA_FIELD_NUMBER: _ClassVar[int]
    MENSAJE_FIELD_NUMBER: _ClassVar[int]
    receta: Receta
    mensaje: str
    def __init__(self, receta: _Optional[_Union[Receta, _Mapping]] = ..., mensaje: _Optional[str] = ...) -> None: ...

class RecetasResponse(_message.Message):
    __slots__ = ["receta", "mensaje"]
    RECETA_FIELD_NUMBER: _ClassVar[int]
    MENSAJE_FIELD_NUMBER: _ClassVar[int]
    receta: _containers.RepeatedCompositeFieldContainer[Receta]
    mensaje: str
    def __init__(self, receta: _Optional[_Iterable[_Union[Receta, _Mapping]]] = ..., mensaje: _Optional[str] = ...) -> None: ...

class UsuarioId(_message.Message):
    __slots__ = ["idUsuario"]
    IDUSUARIO_FIELD_NUMBER: _ClassVar[int]
    idUsuario: int
    def __init__(self, idUsuario: _Optional[int] = ...) -> None: ...

class RecetaId(_message.Message):
    __slots__ = ["idReceta"]
    IDRECETA_FIELD_NUMBER: _ClassVar[int]
    idReceta: int
    def __init__(self, idReceta: _Optional[int] = ...) -> None: ...

class RecetaFiltro(_message.Message):
    __slots__ = ["categoria", "nombre", "ingredientes", "tiempoPrepDesde", "tiempoPrepHasta"]
    CATEGORIA_FIELD_NUMBER: _ClassVar[int]
    NOMBRE_FIELD_NUMBER: _ClassVar[int]
    INGREDIENTES_FIELD_NUMBER: _ClassVar[int]
    TIEMPOPREPDESDE_FIELD_NUMBER: _ClassVar[int]
    TIEMPOPREPHASTA_FIELD_NUMBER: _ClassVar[int]
    categoria: int
    nombre: str
    ingredientes: _containers.RepeatedCompositeFieldContainer[Ingrediente]
    tiempoPrepDesde: int
    tiempoPrepHasta: int
    def __init__(self, categoria: _Optional[int] = ..., nombre: _Optional[str] = ..., ingredientes: _Optional[_Iterable[_Union[Ingrediente, _Mapping]]] = ..., tiempoPrepDesde: _Optional[int] = ..., tiempoPrepHasta: _Optional[int] = ...) -> None: ...
