# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: popularidadUser.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from google.protobuf import wrappers_pb2 as google_dot_protobuf_dot_wrappers__pb2



DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x15popularidadUser.proto\x12\x05model\x1a\x1bgoogle/protobuf/empty.proto\x1a\x1egoogle/protobuf/wrappers.proto\x1a\nuser.proto\"C\n\x10PopularidadUsers\x12/\n\x0fpopularidadUser\x18\x01 \x03(\x0b\x32\x16.model.PopularidadUser\"`\n\x0fPopularidadUser\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x15\n\rnombreUsuario\x18\x02 \x01(\t\x12\x0f\n\x07puntaje\x18\x03 \x01(\t\x12\x19\n\x04user\x18\x04 \x01(\x0b\x32\x0b.model.User2\xa3\x01\n\x17PopularidadUsersService\x12<\n\x07\x46indAll\x12\x16.google.protobuf.Empty\x1a\x17.model.PopularidadUsers\"\x00\x12J\n\x16GuardarPopularidadUser\x12\x16.model.PopularidadUser\x1a\x16.model.PopularidadUser\"\x00\x42,\n\x14\x63om.chefencasa.modelB\x14PopularidadUserProtob\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'popularidadUser_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\024com.chefencasa.modelB\024PopularidadUserProto'
  _globals['_POPULARIDADUSERS']._serialized_start=105
  _globals['_POPULARIDADUSERS']._serialized_end=172
  _globals['_POPULARIDADUSER']._serialized_start=174
  _globals['_POPULARIDADUSER']._serialized_end=270
  _globals['_POPULARIDADUSERSSERVICE']._serialized_start=273
  _globals['_POPULARIDADUSERSSERVICE']._serialized_end=436
# @@protoc_insertion_point(module_scope)