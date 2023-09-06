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
      com.chefencasa.model.RecetaProto.RecetaResponse> getAddRecetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddReceta",
      requestType = com.chefencasa.model.RecetaProto.Receta.class,
      responseType = com.chefencasa.model.RecetaProto.RecetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta,
      com.chefencasa.model.RecetaProto.RecetaResponse> getAddRecetaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.RecetaResponse> getAddRecetaMethod;
    if ((getAddRecetaMethod = RecetasServiceGrpc.getAddRecetaMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getAddRecetaMethod = RecetasServiceGrpc.getAddRecetaMethod) == null) {
          RecetasServiceGrpc.getAddRecetaMethod = getAddRecetaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Receta, com.chefencasa.model.RecetaProto.RecetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddReceta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Receta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("AddReceta"))
              .build();
        }
      }
    }
    return getAddRecetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.RecetaFiltro,
      com.chefencasa.model.RecetaProto.RecetasResponse> getGetByFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByFilter",
      requestType = com.chefencasa.model.RecetaProto.RecetaFiltro.class,
      responseType = com.chefencasa.model.RecetaProto.RecetasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.RecetaFiltro,
      com.chefencasa.model.RecetaProto.RecetasResponse> getGetByFilterMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.RecetaFiltro, com.chefencasa.model.RecetaProto.RecetasResponse> getGetByFilterMethod;
    if ((getGetByFilterMethod = RecetasServiceGrpc.getGetByFilterMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getGetByFilterMethod = RecetasServiceGrpc.getGetByFilterMethod) == null) {
          RecetasServiceGrpc.getGetByFilterMethod = getGetByFilterMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.RecetaFiltro, com.chefencasa.model.RecetaProto.RecetasResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getByFilter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetaFiltro.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetasResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("getByFilter"))
              .build();
        }
      }
    }
    return getGetByFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Empty,
      com.chefencasa.model.RecetaProto.RecetasResponse> getGetAllRecetasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllRecetas",
      requestType = com.chefencasa.model.RecetaProto.Empty.class,
      responseType = com.chefencasa.model.RecetaProto.RecetasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Empty,
      com.chefencasa.model.RecetaProto.RecetasResponse> getGetAllRecetasMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.Empty, com.chefencasa.model.RecetaProto.RecetasResponse> getGetAllRecetasMethod;
    if ((getGetAllRecetasMethod = RecetasServiceGrpc.getGetAllRecetasMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getGetAllRecetasMethod = RecetasServiceGrpc.getGetAllRecetasMethod) == null) {
          RecetasServiceGrpc.getGetAllRecetasMethod = getGetAllRecetasMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.Empty, com.chefencasa.model.RecetaProto.RecetasResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllRecetas"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetasResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("getAllRecetas"))
              .build();
        }
      }
    }
    return getGetAllRecetasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.UsuarioId,
      com.chefencasa.model.RecetaProto.RecetasResponse> getGetAllRecetasByUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllRecetasByUser",
      requestType = com.chefencasa.model.RecetaProto.UsuarioId.class,
      responseType = com.chefencasa.model.RecetaProto.RecetasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.UsuarioId,
      com.chefencasa.model.RecetaProto.RecetasResponse> getGetAllRecetasByUserMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.UsuarioId, com.chefencasa.model.RecetaProto.RecetasResponse> getGetAllRecetasByUserMethod;
    if ((getGetAllRecetasByUserMethod = RecetasServiceGrpc.getGetAllRecetasByUserMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getGetAllRecetasByUserMethod = RecetasServiceGrpc.getGetAllRecetasByUserMethod) == null) {
          RecetasServiceGrpc.getGetAllRecetasByUserMethod = getGetAllRecetasByUserMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.UsuarioId, com.chefencasa.model.RecetaProto.RecetasResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllRecetasByUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.UsuarioId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetasResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("getAllRecetasByUser"))
              .build();
        }
      }
    }
    return getGetAllRecetasByUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.RecetaId,
      com.chefencasa.model.RecetaProto.RecetaResponse> getUpdateRecetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateReceta",
      requestType = com.chefencasa.model.RecetaProto.RecetaId.class,
      responseType = com.chefencasa.model.RecetaProto.RecetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.RecetaId,
      com.chefencasa.model.RecetaProto.RecetaResponse> getUpdateRecetaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RecetaProto.RecetaId, com.chefencasa.model.RecetaProto.RecetaResponse> getUpdateRecetaMethod;
    if ((getUpdateRecetaMethod = RecetasServiceGrpc.getUpdateRecetaMethod) == null) {
      synchronized (RecetasServiceGrpc.class) {
        if ((getUpdateRecetaMethod = RecetasServiceGrpc.getUpdateRecetaMethod) == null) {
          RecetasServiceGrpc.getUpdateRecetaMethod = getUpdateRecetaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RecetaProto.RecetaId, com.chefencasa.model.RecetaProto.RecetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateReceta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetaId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RecetaProto.RecetaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecetasServiceMethodDescriptorSupplier("updateReceta"))
              .build();
        }
      }
    }
    return getUpdateRecetaMethod;
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
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRecetaMethod(), responseObserver);
    }

    /**
     */
    default void getByFilter(com.chefencasa.model.RecetaProto.RecetaFiltro request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByFilterMethod(), responseObserver);
    }

    /**
     */
    default void getAllRecetas(com.chefencasa.model.RecetaProto.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRecetasMethod(), responseObserver);
    }

    /**
     */
    default void getAllRecetasByUser(com.chefencasa.model.RecetaProto.UsuarioId request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRecetasByUserMethod(), responseObserver);
    }

    /**
     */
    default void updateReceta(com.chefencasa.model.RecetaProto.RecetaId request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRecetaMethod(), responseObserver);
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
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRecetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByFilter(com.chefencasa.model.RecetaProto.RecetaFiltro request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByFilterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRecetas(com.chefencasa.model.RecetaProto.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRecetasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRecetasByUser(com.chefencasa.model.RecetaProto.UsuarioId request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRecetasByUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateReceta(com.chefencasa.model.RecetaProto.RecetaId request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRecetaMethod(), getCallOptions()), request, responseObserver);
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
    public com.chefencasa.model.RecetaProto.RecetaResponse addReceta(com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRecetaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.RecetasResponse getByFilter(com.chefencasa.model.RecetaProto.RecetaFiltro request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByFilterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.RecetasResponse getAllRecetas(com.chefencasa.model.RecetaProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRecetasMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.RecetasResponse getAllRecetasByUser(com.chefencasa.model.RecetaProto.UsuarioId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRecetasByUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.RecetaProto.RecetaResponse updateReceta(com.chefencasa.model.RecetaProto.RecetaId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRecetaMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.RecetaResponse> addReceta(
        com.chefencasa.model.RecetaProto.Receta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRecetaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.RecetasResponse> getByFilter(
        com.chefencasa.model.RecetaProto.RecetaFiltro request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByFilterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.RecetasResponse> getAllRecetas(
        com.chefencasa.model.RecetaProto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRecetasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.RecetasResponse> getAllRecetasByUser(
        com.chefencasa.model.RecetaProto.UsuarioId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRecetasByUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RecetaProto.RecetaResponse> updateReceta(
        com.chefencasa.model.RecetaProto.RecetaId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRecetaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_RECETA = 0;
  private static final int METHODID_GET_BY_FILTER = 1;
  private static final int METHODID_GET_ALL_RECETAS = 2;
  private static final int METHODID_GET_ALL_RECETAS_BY_USER = 3;
  private static final int METHODID_UPDATE_RECETA = 4;

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
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetaResponse>) responseObserver);
          break;
        case METHODID_GET_BY_FILTER:
          serviceImpl.getByFilter((com.chefencasa.model.RecetaProto.RecetaFiltro) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_RECETAS:
          serviceImpl.getAllRecetas((com.chefencasa.model.RecetaProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_RECETAS_BY_USER:
          serviceImpl.getAllRecetasByUser((com.chefencasa.model.RecetaProto.UsuarioId) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetasResponse>) responseObserver);
          break;
        case METHODID_UPDATE_RECETA:
          serviceImpl.updateReceta((com.chefencasa.model.RecetaProto.RecetaId) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RecetaProto.RecetaResponse>) responseObserver);
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
              com.chefencasa.model.RecetaProto.RecetaResponse>(
                service, METHODID_ADD_RECETA)))
        .addMethod(
          getGetByFilterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.RecetaFiltro,
              com.chefencasa.model.RecetaProto.RecetasResponse>(
                service, METHODID_GET_BY_FILTER)))
        .addMethod(
          getGetAllRecetasMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.Empty,
              com.chefencasa.model.RecetaProto.RecetasResponse>(
                service, METHODID_GET_ALL_RECETAS)))
        .addMethod(
          getGetAllRecetasByUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.UsuarioId,
              com.chefencasa.model.RecetaProto.RecetasResponse>(
                service, METHODID_GET_ALL_RECETAS_BY_USER)))
        .addMethod(
          getUpdateRecetaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RecetaProto.RecetaId,
              com.chefencasa.model.RecetaProto.RecetaResponse>(
                service, METHODID_UPDATE_RECETA)))
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
              .addMethod(getGetByFilterMethod())
              .addMethod(getGetAllRecetasMethod())
              .addMethod(getGetAllRecetasByUserMethod())
              .addMethod(getUpdateRecetaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
