package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: receta.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecetasServiceGrpc {

  private RecetasServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.RecetasService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getAddRecetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddReceta",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.Receta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getAddRecetaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta> getAddRecetaMethod;
    if ((getAddRecetaMethod = RecetasServiceGrpc.getAddRecetaMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getAddRecetaMethod = RecetasServiceGrpc.getAddRecetaMethod) == null) {
          RecetasServiceGrpc.getAddRecetaMethod = getAddRecetaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddReceta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("AddReceta"))
              .build();
        }
      }
    }
    return getAddRecetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.RecetaProto.Recetas> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.chefencasa.model.RecetaProto.Recetas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.RecetaProto.Recetas> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.chefencasa.model.RecetaProto.Recetas> getFindAllMethod;
    if ((getFindAllMethod = RecetasServiceGrpc.getFindAllMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getFindAllMethod = RecetasServiceGrpc.getFindAllMethod) == null) {
          RecetasServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.chefencasa.model.RecetaProto.Recetas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Recetas.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getModificarRecetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModificarReceta",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.Receta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getModificarRecetaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta> getModificarRecetaMethod;
    if ((getModificarRecetaMethod = RecetasServiceGrpc.getModificarRecetaMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getModificarRecetaMethod = RecetasServiceGrpc.getModificarRecetaMethod) == null) {
          RecetasServiceGrpc.getModificarRecetaMethod = getModificarRecetaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModificarReceta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("ModificarReceta"))
              .build();
        }
      }
    }
    return getModificarRecetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindById",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.Receta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta> getFindByIdMethod;
    if ((getFindByIdMethod = RecetasServiceGrpc.getFindByIdMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getFindByIdMethod = RecetasServiceGrpc.getFindByIdMethod) == null) {
          RecetasServiceGrpc.getFindByIdMethod = getFindByIdMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("FindById"))
              .build();
        }
      }
    }
    return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Recetas> getFindFavoritosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindFavoritos",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.Recetas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Recetas> getFindFavoritosMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Recetas> getFindFavoritosMethod;
    if ((getFindFavoritosMethod = RecetasServiceGrpc.getFindFavoritosMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getFindFavoritosMethod = RecetasServiceGrpc.getFindFavoritosMethod) == null) {
          RecetasServiceGrpc.getFindFavoritosMethod = getFindFavoritosMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Recetas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindFavoritos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Recetas.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("FindFavoritos"))
              .build();
        }
      }
    }
    return getFindFavoritosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Recetas> getFindAllByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllById",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.Recetas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Recetas> getFindAllByIdMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Recetas> getFindAllByIdMethod;
    if ((getFindAllByIdMethod = RecetasServiceGrpc.getFindAllByIdMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getFindAllByIdMethod = RecetasServiceGrpc.getFindAllByIdMethod) == null) {
          RecetasServiceGrpc.getFindAllByIdMethod = getFindAllByIdMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Recetas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Recetas.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("FindAllById"))
              .build();
        }
      }
    }
    return getFindAllByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getAddComentarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddComentario",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.Receta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.Receta> getAddComentarioMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta> getAddComentarioMethod;
    if ((getAddComentarioMethod = RecetasServiceGrpc.getAddComentarioMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getAddComentarioMethod = RecetasServiceGrpc.getAddComentarioMethod) == null) {
          RecetasServiceGrpc.getAddComentarioMethod = getAddComentarioMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.Receta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddComentario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("AddComentario"))
              .build();
        }
      }
    }
    return getAddComentarioMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecetasServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecetasServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecetasServiceStub>() {
        @java.lang.Override
        public RecetasServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecetasServiceStub(channel, callOptions);
        }
      };
    return RecetasServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecetasServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecetasServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecetasServiceBlockingStub>() {
        @java.lang.Override
        public RecetasServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecetasServiceBlockingStub(channel, callOptions);
        }
      };
    return RecetasServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecetasServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecetasServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecetasServiceFutureStub>() {
        @java.lang.Override
        public RecetasServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecetasServiceFutureStub(channel, callOptions);
        }
      };
    return RecetasServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addReceta(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRecetaMethod(), responseObserver);
    }

    /**
     */
    default void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    default void modificarReceta(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModificarRecetaMethod(), responseObserver);
    }

    /**
     */
    default void findById(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    default void findFavoritos(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindFavoritosMethod(), responseObserver);
    }

    /**
     */
    default void findAllById(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllByIdMethod(), responseObserver);
    }

    /**
     */
    default void addComentario(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddComentarioMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RecetasService.
   */
  public static abstract class RecetasServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RecetasServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RecetasService.
   */
  public static final class RecetasServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RecetasServiceStub> {
    private RecetasServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecetasServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecetasServiceStub(channel, callOptions);
    }

    /**
     */
    public void addReceta(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRecetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modificarReceta(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModificarRecetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findFavoritos(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindFavoritosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllById(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addComentario(com.chefencasa.model.RecetaProto.Receta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddComentarioMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RecetasService.
   */
  public static final class RecetasServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecetasServiceBlockingStub> {
    private RecetasServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecetasServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecetasServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Receta addReceta(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRecetaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Recetas findAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Receta modificarReceta(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModificarRecetaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Receta findById(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Recetas findFavoritos(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindFavoritosMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Recetas findAllById(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.Receta addComentario(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddComentarioMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RecetasService.
   */
  public static final class RecetasServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecetasServiceFutureStub> {
    private RecetasServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecetasServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecetasServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Receta> addReceta(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRecetaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Recetas> findAll(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Receta> modificarReceta(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModificarRecetaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Receta> findById(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Recetas> findFavoritos(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindFavoritosMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Recetas> findAllById(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.Receta> addComentario(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddComentarioMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_RECETA = 0;
  private static final int METHODID_FIND_ALL = 1;
  private static final int METHODID_MODIFICAR_RECETA = 2;
  private static final int METHODID_FIND_BY_ID = 3;
  private static final int METHODID_FIND_FAVORITOS = 4;
  private static final int METHODID_FIND_ALL_BY_ID = 5;
  private static final int METHODID_ADD_COMENTARIO = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_RECETA:
          serviceImpl.addReceta((com.chefencasa.model.RecetaProto.Receta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas>) responseObserver);
          break;
        case METHODID_MODIFICAR_RECETA:
          serviceImpl.modificarReceta((com.chefencasa.model.RecetaProto.Receta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.chefencasa.model.RecetaProto.Receta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta>) responseObserver);
          break;
        case METHODID_FIND_FAVORITOS:
          serviceImpl.findFavoritos((com.chefencasa.model.RecetaProto.Receta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_ID:
          serviceImpl.findAllById((com.chefencasa.model.RecetaProto.Receta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Recetas>) responseObserver);
          break;
        case METHODID_ADD_COMENTARIO:
          serviceImpl.addComentario((com.chefencasa.model.RecetaProto.Receta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.Receta>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddRecetaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Receta,
              com.chefencasa.model.RecetaProto.Receta>(
                service, METHODID_ADD_RECETA)))
        .addMethod(
          getFindAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.chefencasa.model.RecetaProto.Recetas>(
                service, METHODID_FIND_ALL)))
        .addMethod(
          getModificarRecetaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Receta,
              com.chefencasa.model.RecetaProto.Receta>(
                service, METHODID_MODIFICAR_RECETA)))
        .addMethod(
          getFindByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Receta,
              com.chefencasa.model.RecetaProto.Receta>(
                service, METHODID_FIND_BY_ID)))
        .addMethod(
          getFindFavoritosMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Receta,
              com.chefencasa.model.RecetaProto.Recetas>(
                service, METHODID_FIND_FAVORITOS)))
        .addMethod(
          getFindAllByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Receta,
              com.chefencasa.model.RecetaProto.Recetas>(
                service, METHODID_FIND_ALL_BY_ID)))
        .addMethod(
          getAddComentarioMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Receta,
              com.chefencasa.model.RecetaProto.Receta>(
                service, METHODID_ADD_COMENTARIO)))
        .build();
  }

  private static abstract class RecetasServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecetasServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.RecetaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecetasService");
    }
  }

  private static final class RecetasServiceFileDescriptorSupplier
      extends RecetasServiceBaseDescriptorSupplier {
    RecetasServiceFileDescriptorSupplier() {}
  }

  private static final class RecetasServiceMethodDescriptorSupplier
      extends RecetasServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RecetasServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RecetasServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecetasServiceFileDescriptorSupplier())
              .addMethod(getAddRecetaMethod())
              .addMethod(getFindAllMethod())
              .addMethod(getModificarRecetaMethod())
              .addMethod(getFindByIdMethod())
              .addMethod(getFindFavoritosMethod())
              .addMethod(getFindAllByIdMethod())
              .addMethod(getAddComentarioMethod())
              .build();
        }
      }
    }
    return result;
  }
}
