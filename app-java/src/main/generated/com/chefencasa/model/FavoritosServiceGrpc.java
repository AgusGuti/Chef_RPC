package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: favorito.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FavoritosServiceGrpc {

  private FavoritosServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.FavoritosService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito,
      com.chefencasa.model.FavoritoProto.Favorito> getAddFavoritoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFavorito",
      requestType = com.chefencasa.model.FavoritoProto.Favorito.class,
      responseType = com.chefencasa.model.FavoritoProto.Favorito.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito,
      com.chefencasa.model.FavoritoProto.Favorito> getAddFavoritoMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito, com.chefencasa.model.FavoritoProto.Favorito> getAddFavoritoMethod;
    if ((getAddFavoritoMethod = FavoritosServiceGrpc.getAddFavoritoMethod) == null) {
      synchronized (FavoritosServiceGrpc.class) {
        if ((getAddFavoritoMethod = FavoritosServiceGrpc.getAddFavoritoMethod) == null) {
          FavoritosServiceGrpc.getAddFavoritoMethod = getAddFavoritoMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.FavoritoProto.Favorito, com.chefencasa.model.FavoritoProto.Favorito>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddFavorito"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.FavoritoProto.Favorito.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.FavoritoProto.Favorito.getDefaultInstance()))
              .setSchemaDescriptor(new FavoritosServiceMethodDescriptorSupplier("AddFavorito"))
              .build();
        }
      }
    }
    return getAddFavoritoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito,
      com.chefencasa.model.FavoritoProto.Favorito> getDeleteFavoritoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFavorito",
      requestType = com.chefencasa.model.FavoritoProto.Favorito.class,
      responseType = com.chefencasa.model.FavoritoProto.Favorito.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito,
      com.chefencasa.model.FavoritoProto.Favorito> getDeleteFavoritoMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito, com.chefencasa.model.FavoritoProto.Favorito> getDeleteFavoritoMethod;
    if ((getDeleteFavoritoMethod = FavoritosServiceGrpc.getDeleteFavoritoMethod) == null) {
      synchronized (FavoritosServiceGrpc.class) {
        if ((getDeleteFavoritoMethod = FavoritosServiceGrpc.getDeleteFavoritoMethod) == null) {
          FavoritosServiceGrpc.getDeleteFavoritoMethod = getDeleteFavoritoMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.FavoritoProto.Favorito, com.chefencasa.model.FavoritoProto.Favorito>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFavorito"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.FavoritoProto.Favorito.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.FavoritoProto.Favorito.getDefaultInstance()))
              .setSchemaDescriptor(new FavoritosServiceMethodDescriptorSupplier("DeleteFavorito"))
              .build();
        }
      }
    }
    return getDeleteFavoritoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito,
      com.chefencasa.model.FavoritoProto.FlagFavorito> getCheckFavoritoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckFavorito",
      requestType = com.chefencasa.model.FavoritoProto.Favorito.class,
      responseType = com.chefencasa.model.FavoritoProto.FlagFavorito.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito,
      com.chefencasa.model.FavoritoProto.FlagFavorito> getCheckFavoritoMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.FavoritoProto.Favorito, com.chefencasa.model.FavoritoProto.FlagFavorito> getCheckFavoritoMethod;
    if ((getCheckFavoritoMethod = FavoritosServiceGrpc.getCheckFavoritoMethod) == null) {
      synchronized (FavoritosServiceGrpc.class) {
        if ((getCheckFavoritoMethod = FavoritosServiceGrpc.getCheckFavoritoMethod) == null) {
          FavoritosServiceGrpc.getCheckFavoritoMethod = getCheckFavoritoMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.FavoritoProto.Favorito, com.chefencasa.model.FavoritoProto.FlagFavorito>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckFavorito"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.FavoritoProto.Favorito.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.FavoritoProto.FlagFavorito.getDefaultInstance()))
              .setSchemaDescriptor(new FavoritosServiceMethodDescriptorSupplier("CheckFavorito"))
              .build();
        }
      }
    }
    return getCheckFavoritoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FavoritosServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FavoritosServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FavoritosServiceStub>() {
        @java.lang.Override
        public FavoritosServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FavoritosServiceStub(channel, callOptions);
        }
      };
    return FavoritosServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FavoritosServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FavoritosServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FavoritosServiceBlockingStub>() {
        @java.lang.Override
        public FavoritosServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FavoritosServiceBlockingStub(channel, callOptions);
        }
      };
    return FavoritosServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FavoritosServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FavoritosServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FavoritosServiceFutureStub>() {
        @java.lang.Override
        public FavoritosServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FavoritosServiceFutureStub(channel, callOptions);
        }
      };
    return FavoritosServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addFavorito(com.chefencasa.model.FavoritoProto.Favorito request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.Favorito> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddFavoritoMethod(), responseObserver);
    }

    /**
     */
    default void deleteFavorito(com.chefencasa.model.FavoritoProto.Favorito request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.Favorito> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFavoritoMethod(), responseObserver);
    }

    /**
     */
    default void checkFavorito(com.chefencasa.model.FavoritoProto.Favorito request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.FlagFavorito> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckFavoritoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FavoritosService.
   */
  public static abstract class FavoritosServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FavoritosServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FavoritosService.
   */
  public static final class FavoritosServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FavoritosServiceStub> {
    private FavoritosServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FavoritosServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FavoritosServiceStub(channel, callOptions);
    }

    /**
     */
    public void addFavorito(com.chefencasa.model.FavoritoProto.Favorito request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.Favorito> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFavoritoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFavorito(com.chefencasa.model.FavoritoProto.Favorito request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.Favorito> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFavoritoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkFavorito(com.chefencasa.model.FavoritoProto.Favorito request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.FlagFavorito> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckFavoritoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FavoritosService.
   */
  public static final class FavoritosServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FavoritosServiceBlockingStub> {
    private FavoritosServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FavoritosServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FavoritosServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.FavoritoProto.Favorito addFavorito(com.chefencasa.model.FavoritoProto.Favorito request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFavoritoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.FavoritoProto.Favorito deleteFavorito(com.chefencasa.model.FavoritoProto.Favorito request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFavoritoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.FavoritoProto.FlagFavorito checkFavorito(com.chefencasa.model.FavoritoProto.Favorito request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckFavoritoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FavoritosService.
   */
  public static final class FavoritosServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FavoritosServiceFutureStub> {
    private FavoritosServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FavoritosServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FavoritosServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.FavoritoProto.Favorito> addFavorito(
        com.chefencasa.model.FavoritoProto.Favorito request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFavoritoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.FavoritoProto.Favorito> deleteFavorito(
        com.chefencasa.model.FavoritoProto.Favorito request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFavoritoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.FavoritoProto.FlagFavorito> checkFavorito(
        com.chefencasa.model.FavoritoProto.Favorito request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckFavoritoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_FAVORITO = 0;
  private static final int METHODID_DELETE_FAVORITO = 1;
  private static final int METHODID_CHECK_FAVORITO = 2;

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
        case METHODID_ADD_FAVORITO:
          serviceImpl.addFavorito((com.chefencasa.model.FavoritoProto.Favorito) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.Favorito>) responseObserver);
          break;
        case METHODID_DELETE_FAVORITO:
          serviceImpl.deleteFavorito((com.chefencasa.model.FavoritoProto.Favorito) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.Favorito>) responseObserver);
          break;
        case METHODID_CHECK_FAVORITO:
          serviceImpl.checkFavorito((com.chefencasa.model.FavoritoProto.Favorito) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.FavoritoProto.FlagFavorito>) responseObserver);
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
          getAddFavoritoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.FavoritoProto.Favorito,
              com.chefencasa.model.FavoritoProto.Favorito>(
                service, METHODID_ADD_FAVORITO)))
        .addMethod(
          getDeleteFavoritoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.FavoritoProto.Favorito,
              com.chefencasa.model.FavoritoProto.Favorito>(
                service, METHODID_DELETE_FAVORITO)))
        .addMethod(
          getCheckFavoritoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.FavoritoProto.Favorito,
              com.chefencasa.model.FavoritoProto.FlagFavorito>(
                service, METHODID_CHECK_FAVORITO)))
        .build();
  }

  private static abstract class FavoritosServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FavoritosServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.FavoritoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FavoritosService");
    }
  }

  private static final class FavoritosServiceFileDescriptorSupplier
      extends FavoritosServiceBaseDescriptorSupplier {
    FavoritosServiceFileDescriptorSupplier() {}
  }

  private static final class FavoritosServiceMethodDescriptorSupplier
      extends FavoritosServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FavoritosServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FavoritosServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FavoritosServiceFileDescriptorSupplier())
              .addMethod(getAddFavoritoMethod())
              .addMethod(getDeleteFavoritoMethod())
              .addMethod(getCheckFavoritoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
