# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: receta.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from google.protobuf import wrappers_pb2 as google_dot_protobuf_dot_wrappers__pb2
from google.protobuf import timestamp_pb2 as google_dot_protobuf_dot_timestamp__pb2


DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x0creceta.proto\x12\x05model\x1a\x1bgoogle/protobuf/empty.proto\x1a\x1egoogle/protobuf/wrappers.proto\x1a\x1fgoogle/protobuf/timestamp.proto\x1a\x0f\x63\x61tegoria.proto\x1a\x11ingrediente.proto\x1a\nuser.proto\"\x07\n\x05\x45mpty\"(\n\x07Recetas\x12\x1d\n\x06receta\x18\x01 \x03(\x0b\x32\r.model.Receta\"\xb8\x02\n\x06Receta\x12\x10\n\x08idReceta\x18\x01 \x01(\x05\x12\x19\n\x04user\x18\x02 \x01(\x0b\x32\x0b.model.User\x12\x14\n\x0ctituloReceta\x18\x03 \x01(\t\x12\x13\n\x0b\x64\x65scripcion\x18\x04 \x01(\t\x12#\n\tcategoria\x18\x05 \x01(\x0b\x32\x10.model.Categoria\x12\r\n\x05pasos\x18\x06 \x01(\t\x12(\n\x0cingredientes\x18\x08 \x03(\x0b\x32\x12.model.Ingrediente\x12\x19\n\x11tiempoPreparacion\x18\t \x01(\x05\x12\r\n\x05\x66oto1\x18\n \x01(\t\x12\r\n\x05\x66oto2\x18\x0b \x01(\t\x12\r\n\x05\x66oto3\x18\x0c \x01(\t\x12\r\n\x05\x66oto4\x18\r \x01(\t\x12\r\n\x05\x66oto5\x18\x0e \x01(\t\x12\x12\n\ncomentario\x18\x0f \x01(\t\"y\n\x0cRecetaFiltro\x12\x11\n\tcategoria\x18\x01 \x01(\t\x12\x0e\n\x06nombre\x18\x02 \x01(\t\x12\x14\n\x0cingredientes\x18\x03 \x03(\t\x12\x17\n\x0ftiempoPrepDesde\x18\x04 \x01(\x05\x12\x17\n\x0ftiempoPrepHasta\x18\x05 \x01(\x05\x32\xe4\x02\n\x0eRecetasService\x12+\n\tAddReceta\x12\r.model.Receta\x1a\r.model.Receta\"\x00\x12\x33\n\x07\x46indAll\x12\x16.google.protobuf.Empty\x1a\x0e.model.Recetas\"\x00\x12\x31\n\x0fModificarReceta\x12\r.model.Receta\x1a\r.model.Receta\"\x00\x12*\n\x08\x46indById\x12\r.model.Receta\x1a\r.model.Receta\"\x00\x12\x30\n\rFindFavoritos\x12\r.model.Receta\x1a\x0e.model.Recetas\"\x00\x12.\n\x0b\x46indAllById\x12\r.model.Receta\x1a\x0e.model.Recetas\"\x00\x12/\n\rAddComentario\x12\r.model.Receta\x1a\r.model.Receta\"\x00\x42#\n\x14\x63om.chefencasa.modelB\x0bRecetaProtob\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'receta_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\024com.chefencasa.modelB\013RecetaProto'
  _globals['_EMPTY']._serialized_start=165
  _globals['_EMPTY']._serialized_end=172
  _globals['_RECETAS']._serialized_start=174
  _globals['_RECETAS']._serialized_end=214
  _globals['_RECETA']._serialized_start=217
  _globals['_RECETA']._serialized_end=529
  _globals['_RECETAFILTRO']._serialized_start=531
  _globals['_RECETAFILTRO']._serialized_end=652
  _globals['_RECETASSERVICE']._serialized_start=655
  _globals['_RECETASSERVICE']._serialized_end=1011
# @@protoc_insertion_point(module_scope)
