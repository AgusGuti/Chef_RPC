# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: denuncia.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from . import user_pb2 as user__pb2
from . import receta_pb2 as receta__pb2
from . import motivo_pb2 as motivo__pb2


DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x0e\x64\x65nuncia.proto\x12\x05model\x1a\x1bgoogle/protobuf/empty.proto\x1a\nuser.proto\x1a\x0creceta.proto\x1a\x0cmotivo.proto\".\n\tDenuncias\x12!\n\x08\x64\x65nuncia\x18\x01 \x03(\x0b\x32\x0f.model.Denuncia\"\x87\x01\n\x08\x44\x65nuncia\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x1c\n\x07user_id\x18\x02 \x01(\x0b\x32\x0b.model.User\x12 \n\treceta_id\x18\x03 \x01(\x0b\x32\r.model.Receta\x12\x10\n\x08resuelta\x18\x04 \x01(\t\x12\x1d\n\x06motivo\x18\x05 \x01(\x0b\x32\r.model.Motivo2I\n\x10\x44\x65nunciasService\x12\x35\n\x07\x46indAll\x12\x16.google.protobuf.Empty\x1a\x10.model.Denuncias\"\x00\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'denuncia_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:
  DESCRIPTOR._options = None
  _globals['_DENUNCIAS']._serialized_start=94
  _globals['_DENUNCIAS']._serialized_end=140
  _globals['_DENUNCIA']._serialized_start=143
  _globals['_DENUNCIA']._serialized_end=278
  _globals['_DENUNCIASSERVICE']._serialized_start=280
  _globals['_DENUNCIASSERVICE']._serialized_end=353
# @@protoc_insertion_point(module_scope)
