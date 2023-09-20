package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: seguido.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeguidosServiceGrpc {

  private SeguidosServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.SeguidosService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido,
      com.chefencasa.model.SeguidoProto.Seguido> getAddSeguidosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddSeguidos",
      requestType = com.chefencasa.model.SeguidoProto.Seguido.class,
      responseType = com.chefencasa.model.SeguidoProto.Seguido.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido,
      com.chefencasa.model.SeguidoProto.Seguido> getAddSeguidosMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido, com.chefencasa.model.SeguidoProto.Seguido> getAddSeguidosMethod;
    if ((getAddSeguidosMethod = SeguidosServiceGrpc.getAddSeguidosMethod) == null) {
      synchronized (SeguidosServiceGrpc.class) {
        if ((getAddSeguidosMethod = SeguidosServiceGrpc.getAddSeguidosMethod) == null) {
          SeguidosServiceGrpc.getAddSeguidosMethod = getAddSeguidosMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.SeguidoProto.Seguido, com.chefencasa.model.SeguidoProto.Seguido>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddSeguidos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.SeguidoProto.Seguido.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.SeguidoProto.Seguido.getDefaultInstance()))
              .setSchemaDescriptor(new SeguidosServiceMethodDescriptorSupplier("AddSeguidos"))
              .build();
        }
      }
    }
    return getAddSeguidosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido,
      com.chefencasa.model.SeguidoProto.Seguido> getDeleteSeguidosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSeguidos",
      requestType = com.chefencasa.model.SeguidoProto.Seguido.class,
      responseType = com.chefencasa.model.SeguidoProto.Seguido.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido,
      com.chefencasa.model.SeguidoProto.Seguido> getDeleteSeguidosMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido, com.chefencasa.model.SeguidoProto.Seguido> getDeleteSeguidosMethod;
    if ((getDeleteSeguidosMethod = SeguidosServiceGrpc.getDeleteSeguidosMethod) == null) {
      synchronized (SeguidosServiceGrpc.class) {
        if ((getDeleteSeguidosMethod = SeguidosServiceGrpc.getDeleteSeguidosMethod) == null) {
          SeguidosServiceGrpc.getDeleteSeguidosMethod = getDeleteSeguidosMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.SeguidoProto.Seguido, com.chefencasa.model.SeguidoProto.Seguido>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSeguidos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.SeguidoProto.Seguido.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.SeguidoProto.Seguido.getDefaultInstance()))
              .setSchemaDescriptor(new SeguidosServiceMethodDescriptorSupplier("DeleteSeguidos"))
              .build();
        }
      }
    }
    return getDeleteSeguidosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido,
      com.chefencasa.model.SeguidoProto.Seguido> getDeleteSeguidoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSeguidores",
      requestType = com.chefencasa.model.SeguidoProto.Seguido.class,
      responseType = com.chefencasa.model.SeguidoProto.Seguido.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido,
      com.chefencasa.model.SeguidoProto.Seguido> getDeleteSeguidoresMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.SeguidoProto.Seguido, com.chefencasa.model.SeguidoProto.Seguido> getDeleteSeguidoresMethod;
    if ((getDeleteSeguidoresMethod = SeguidosServiceGrpc.getDeleteSeguidoresMethod) == null) {
      synchronized (SeguidosServiceGrpc.class) {
        if ((getDeleteSeguidoresMethod = SeguidosServiceGrpc.getDeleteSeguidoresMethod) == null) {
          SeguidosServiceGrpc.getDeleteSeguidoresMethod = getDeleteSeguidoresMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.SeguidoProto.Seguido, com.chefencasa.model.SeguidoProto.Seguido>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSeguidores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.SeguidoProto.Seguido.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.SeguidoProto.Seguido.getDefaultInstance()))
              .setSchemaDescriptor(new SeguidosServiceMethodDescriptorSupplier("DeleteSeguidores"))
              .build();
        }
      }
    }
    return getDeleteSeguidoresMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeguidosServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeguidosServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeguidosServiceStub>() {
        @java.lang.Override
        public SeguidosServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeguidosServiceStub(channel, callOptions);
        }
      };
    return SeguidosServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeguidosServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeguidosServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeguidosServiceBlockingStub>() {
        @java.lang.Override
        public SeguidosServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeguidosServiceBlockingStub(channel, callOptions);
        }
      };
    return SeguidosServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeguidosServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeguidosServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeguidosServiceFutureStub>() {
        @java.lang.Override
        public SeguidosServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeguidosServiceFutureStub(channel, callOptions);
        }
      };
    return SeguidosServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addSeguidos(com.chefencasa.model.SeguidoProto.Seguido request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddSeguidosMethod(), responseObserver);
    }

    /**
     */
    default void deleteSeguidos(com.chefencasa.model.SeguidoProto.Seguido request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSeguidosMethod(), responseObserver);
    }

    /**
     */
    default void deleteSeguidores(com.chefencasa.model.SeguidoProto.Seguido request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSeguidoresMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeguidosService.
   */
  public static abstract class SeguidosServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeguidosServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeguidosService.
   */
  public static final class SeguidosServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeguidosServiceStub> {
    private SeguidosServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeguidosServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeguidosServiceStub(channel, callOptions);
    }

    /**
     */
    public void addSeguidos(com.chefencasa.model.SeguidoProto.Seguido request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddSeguidosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSeguidos(com.chefencasa.model.SeguidoProto.Seguido request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSeguidosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSeguidores(com.chefencasa.model.SeguidoProto.Seguido request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSeguidoresMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeguidosService.
   */
  public static final class SeguidosServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeguidosServiceBlockingStub> {
    private SeguidosServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeguidosServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeguidosServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.SeguidoProto.Seguido addSeguidos(com.chefencasa.model.SeguidoProto.Seguido request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddSeguidosMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.SeguidoProto.Seguido deleteSeguidos(com.chefencasa.model.SeguidoProto.Seguido request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSeguidosMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.SeguidoProto.Seguido deleteSeguidores(com.chefencasa.model.SeguidoProto.Seguido request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSeguidoresMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeguidosService.
   */
  public static final class SeguidosServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeguidosServiceFutureStub> {
    private SeguidosServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeguidosServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeguidosServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.SeguidoProto.Seguido> addSeguidos(
        com.chefencasa.model.SeguidoProto.Seguido request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddSeguidosMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.SeguidoProto.Seguido> deleteSeguidos(
        com.chefencasa.model.SeguidoProto.Seguido request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSeguidosMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.SeguidoProto.Seguido> deleteSeguidores(
        com.chefencasa.model.SeguidoProto.Seguido request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSeguidoresMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SEGUIDOS = 0;
  private static final int METHODID_DELETE_SEGUIDOS = 1;
  private static final int METHODID_DELETE_SEGUIDORES = 2;

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
        case METHODID_ADD_SEGUIDOS:
          serviceImpl.addSeguidos((com.chefencasa.model.SeguidoProto.Seguido) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido>) responseObserver);
          break;
        case METHODID_DELETE_SEGUIDOS:
          serviceImpl.deleteSeguidos((com.chefencasa.model.SeguidoProto.Seguido) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido>) responseObserver);
          break;
        case METHODID_DELETE_SEGUIDORES:
          serviceImpl.deleteSeguidores((com.chefencasa.model.SeguidoProto.Seguido) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.SeguidoProto.Seguido>) responseObserver);
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
          getAddSeguidosMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.SeguidoProto.Seguido,
              com.chefencasa.model.SeguidoProto.Seguido>(
                service, METHODID_ADD_SEGUIDOS)))
        .addMethod(
          getDeleteSeguidosMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.SeguidoProto.Seguido,
              com.chefencasa.model.SeguidoProto.Seguido>(
                service, METHODID_DELETE_SEGUIDOS)))
        .addMethod(
          getDeleteSeguidoresMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.SeguidoProto.Seguido,
              com.chefencasa.model.SeguidoProto.Seguido>(
                service, METHODID_DELETE_SEGUIDORES)))
        .build();
  }

  private static abstract class SeguidosServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeguidosServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.SeguidoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeguidosService");
    }
  }

  private static final class SeguidosServiceFileDescriptorSupplier
      extends SeguidosServiceBaseDescriptorSupplier {
    SeguidosServiceFileDescriptorSupplier() {}
  }

  private static final class SeguidosServiceMethodDescriptorSupplier
      extends SeguidosServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SeguidosServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SeguidosServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeguidosServiceFileDescriptorSupplier())
              .addMethod(getAddSeguidosMethod())
              .addMethod(getDeleteSeguidosMethod())
              .addMethod(getDeleteSeguidoresMethod())
              .build();
        }
      }
    }
    return result;
  }
}
