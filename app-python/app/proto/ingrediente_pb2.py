# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: ingrediente.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from google.protobuf import wrappers_pb2 as google_dot_protobuf_dot_wrappers__pb2


DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x11ingrediente.proto\x12\x05model\x1a\x1bgoogle/protobuf/empty.proto\x1a\x1egoogle/protobuf/wrappers.proto\"7\n\x0cIngredientes\x12\'\n\x0bingrediente\x18\x01 \x03(\x0b\x32\x12.model.Ingrediente\".\n\x0bIngrediente\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x13\n\x0bingrediente\x18\x02 \x01(\t2\x8d\x01\n\x13IngredientesService\x12<\n\x10TraerIngrediente\x12\x12.model.Ingrediente\x1a\x12.model.Ingrediente\"\x00\x12\x38\n\x07\x46indAll\x12\x16.google.protobuf.Empty\x1a\x13.model.Ingredientes\"\x00\x42(\n\x14\x63om.chefencasa.modelB\x10IngredienteProtob\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'ingrediente_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\024com.chefencasa.modelB\020IngredienteProto'
  _globals['_INGREDIENTES']._serialized_start=89
  _globals['_INGREDIENTES']._serialized_end=144
  _globals['_INGREDIENTE']._serialized_start=146
  _globals['_INGREDIENTE']._serialized_end=192
  _globals['_INGREDIENTESSERVICE']._serialized_start=195
  _globals['_INGREDIENTESSERVICE']._serialized_end=336
# @@protoc_insertion_point(module_scope)