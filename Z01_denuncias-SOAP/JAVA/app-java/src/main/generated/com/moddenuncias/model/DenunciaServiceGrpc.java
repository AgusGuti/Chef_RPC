package com.moddenuncias.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: denuncia.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DenunciaServiceGrpc {

  private DenunciaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.DenunciaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.moddenuncias.model.DenunciaProto.Denuncias> getFindUnresolvedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindUnresolved",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.moddenuncias.model.DenunciaProto.Denuncias.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.moddenuncias.model.DenunciaProto.Denuncias> getFindUnresolvedMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.moddenuncias.model.DenunciaProto.Denuncias> getFindUnresolvedMethod;
    if ((getFindUnresolvedMethod = DenunciaServiceGrpc.getFindUnresolvedMethod) == null) {
      synchronized (DenunciaServiceGrpc.class) {
        if ((getFindUnresolvedMethod = DenunciaServiceGrpc.getFindUnresolvedMethod) == null) {
          DenunciaServiceGrpc.getFindUnresolvedMethod = getFindUnresolvedMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.moddenuncias.model.DenunciaProto.Denuncias>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindUnresolved"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moddenuncias.model.DenunciaProto.Denuncias.getDefaultInstance()))
              .setSchemaDescriptor(new DenunciaServiceMethodDescriptorSupplier("FindUnresolved"))
              .build();
        }
      }
    }
    return getFindUnresolvedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.moddenuncias.model.DenunciaProto.Denuncia,
      com.moddenuncias.model.DenunciaProto.Denuncia> getAddDenunciaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDenuncia",
      requestType = com.moddenuncias.model.DenunciaProto.Denuncia.class,
      responseType = com.moddenuncias.model.DenunciaProto.Denuncia.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.moddenuncias.model.DenunciaProto.Denuncia,
      com.moddenuncias.model.DenunciaProto.Denuncia> getAddDenunciaMethod() {
    io.grpc.MethodDescriptor<com.moddenuncias.model.DenunciaProto.Denuncia, com.moddenuncias.model.DenunciaProto.Denuncia> getAddDenunciaMethod;
    if ((getAddDenunciaMethod = DenunciaServiceGrpc.getAddDenunciaMethod) == null) {
      synchronized (DenunciaServiceGrpc.class) {
        if ((getAddDenunciaMethod = DenunciaServiceGrpc.getAddDenunciaMethod) == null) {
          DenunciaServiceGrpc.getAddDenunciaMethod = getAddDenunciaMethod =
              io.grpc.MethodDescriptor.<com.moddenuncias.model.DenunciaProto.Denuncia, com.moddenuncias.model.DenunciaProto.Denuncia>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDenuncia"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moddenuncias.model.DenunciaProto.Denuncia.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moddenuncias.model.DenunciaProto.Denuncia.getDefaultInstance()))
              .setSchemaDescriptor(new DenunciaServiceMethodDescriptorSupplier("AddDenuncia"))
              .build();
        }
      }
    }
    return getAddDenunciaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.moddenuncias.model.DenunciaProto.Denuncia> getResolverDenunciaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolverDenuncia",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.moddenuncias.model.DenunciaProto.Denuncia.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.moddenuncias.model.DenunciaProto.Denuncia> getResolverDenunciaMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.moddenuncias.model.DenunciaProto.Denuncia> getResolverDenunciaMethod;
    if ((getResolverDenunciaMethod = DenunciaServiceGrpc.getResolverDenunciaMethod) == null) {
      synchronized (DenunciaServiceGrpc.class) {
        if ((getResolverDenunciaMethod = DenunciaServiceGrpc.getResolverDenunciaMethod) == null) {
          DenunciaServiceGrpc.getResolverDenunciaMethod = getResolverDenunciaMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.moddenuncias.model.DenunciaProto.Denuncia>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResolverDenuncia"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moddenuncias.model.DenunciaProto.Denuncia.getDefaultInstance()))
              .setSchemaDescriptor(new DenunciaServiceMethodDescriptorSupplier("ResolverDenuncia"))
              .build();
        }
      }
    }
    return getResolverDenunciaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.moddenuncias.model.DenunciaProto.Denuncia,
      com.moddenuncias.model.DenunciaProto.Denuncia> getTraerDenunciaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TraerDenuncia",
      requestType = com.moddenuncias.model.DenunciaProto.Denuncia.class,
      responseType = com.moddenuncias.model.DenunciaProto.Denuncia.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.moddenuncias.model.DenunciaProto.Denuncia,
      com.moddenuncias.model.DenunciaProto.Denuncia> getTraerDenunciaMethod() {
    io.grpc.MethodDescriptor<com.moddenuncias.model.DenunciaProto.Denuncia, com.moddenuncias.model.DenunciaProto.Denuncia> getTraerDenunciaMethod;
    if ((getTraerDenunciaMethod = DenunciaServiceGrpc.getTraerDenunciaMethod) == null) {
      synchronized (DenunciaServiceGrpc.class) {
        if ((getTraerDenunciaMethod = DenunciaServiceGrpc.getTraerDenunciaMethod) == null) {
          DenunciaServiceGrpc.getTraerDenunciaMethod = getTraerDenunciaMethod =
              io.grpc.MethodDescriptor.<com.moddenuncias.model.DenunciaProto.Denuncia, com.moddenuncias.model.DenunciaProto.Denuncia>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TraerDenuncia"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moddenuncias.model.DenunciaProto.Denuncia.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moddenuncias.model.DenunciaProto.Denuncia.getDefaultInstance()))
              .setSchemaDescriptor(new DenunciaServiceMethodDescriptorSupplier("TraerDenuncia"))
              .build();
        }
      }
    }
    return getTraerDenunciaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DenunciaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DenunciaServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DenunciaServiceStub>() {
        @java.lang.Override
        public DenunciaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DenunciaServiceStub(channel, callOptions);
        }
      };
    return DenunciaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DenunciaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DenunciaServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DenunciaServiceBlockingStub>() {
        @java.lang.Override
        public DenunciaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DenunciaServiceBlockingStub(channel, callOptions);
        }
      };
    return DenunciaServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DenunciaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DenunciaServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DenunciaServiceFutureStub>() {
        @java.lang.Override
        public DenunciaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DenunciaServiceFutureStub(channel, callOptions);
        }
      };
    return DenunciaServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findUnresolved(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncias> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindUnresolvedMethod(), responseObserver);
    }

    /**
     */
    default void addDenuncia(com.moddenuncias.model.DenunciaProto.Denuncia request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddDenunciaMethod(), responseObserver);
    }

    /**
     */
    default void resolverDenuncia(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResolverDenunciaMethod(), responseObserver);
    }

    /**
     */
    default void traerDenuncia(com.moddenuncias.model.DenunciaProto.Denuncia request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTraerDenunciaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DenunciaService.
   */
  public static abstract class DenunciaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DenunciaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DenunciaService.
   */
  public static final class DenunciaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DenunciaServiceStub> {
    private DenunciaServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DenunciaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DenunciaServiceStub(channel, callOptions);
    }

    /**
     */
    public void findUnresolved(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncias> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindUnresolvedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDenuncia(com.moddenuncias.model.DenunciaProto.Denuncia request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddDenunciaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resolverDenuncia(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolverDenunciaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void traerDenuncia(com.moddenuncias.model.DenunciaProto.Denuncia request,
        io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTraerDenunciaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DenunciaService.
   */
  public static final class DenunciaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DenunciaServiceBlockingStub> {
    private DenunciaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DenunciaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DenunciaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.moddenuncias.model.DenunciaProto.Denuncias findUnresolved(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindUnresolvedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.moddenuncias.model.DenunciaProto.Denuncia addDenuncia(com.moddenuncias.model.DenunciaProto.Denuncia request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDenunciaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.moddenuncias.model.DenunciaProto.Denuncia resolverDenuncia(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolverDenunciaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.moddenuncias.model.DenunciaProto.Denuncia traerDenuncia(com.moddenuncias.model.DenunciaProto.Denuncia request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTraerDenunciaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DenunciaService.
   */
  public static final class DenunciaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DenunciaServiceFutureStub> {
    private DenunciaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DenunciaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DenunciaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.moddenuncias.model.DenunciaProto.Denuncias> findUnresolved(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindUnresolvedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.moddenuncias.model.DenunciaProto.Denuncia> addDenuncia(
        com.moddenuncias.model.DenunciaProto.Denuncia request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddDenunciaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.moddenuncias.model.DenunciaProto.Denuncia> resolverDenuncia(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolverDenunciaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.moddenuncias.model.DenunciaProto.Denuncia> traerDenuncia(
        com.moddenuncias.model.DenunciaProto.Denuncia request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTraerDenunciaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_UNRESOLVED = 0;
  private static final int METHODID_ADD_DENUNCIA = 1;
  private static final int METHODID_RESOLVER_DENUNCIA = 2;
  private static final int METHODID_TRAER_DENUNCIA = 3;

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
        case METHODID_FIND_UNRESOLVED:
          serviceImpl.findUnresolved((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncias>) responseObserver);
          break;
        case METHODID_ADD_DENUNCIA:
          serviceImpl.addDenuncia((com.moddenuncias.model.DenunciaProto.Denuncia) request,
              (io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia>) responseObserver);
          break;
        case METHODID_RESOLVER_DENUNCIA:
          serviceImpl.resolverDenuncia((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia>) responseObserver);
          break;
        case METHODID_TRAER_DENUNCIA:
          serviceImpl.traerDenuncia((com.moddenuncias.model.DenunciaProto.Denuncia) request,
              (io.grpc.stub.StreamObserver<com.moddenuncias.model.DenunciaProto.Denuncia>) responseObserver);
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
          getFindUnresolvedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.moddenuncias.model.DenunciaProto.Denuncias>(
                service, METHODID_FIND_UNRESOLVED)))
        .addMethod(
          getAddDenunciaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.moddenuncias.model.DenunciaProto.Denuncia,
              com.moddenuncias.model.DenunciaProto.Denuncia>(
                service, METHODID_ADD_DENUNCIA)))
        .addMethod(
          getResolverDenunciaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.moddenuncias.model.DenunciaProto.Denuncia>(
                service, METHODID_RESOLVER_DENUNCIA)))
        .addMethod(
          getTraerDenunciaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.moddenuncias.model.DenunciaProto.Denuncia,
              com.moddenuncias.model.DenunciaProto.Denuncia>(
                service, METHODID_TRAER_DENUNCIA)))
        .build();
  }

  private static abstract class DenunciaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DenunciaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.moddenuncias.model.DenunciaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DenunciaService");
    }
  }

  private static final class DenunciaServiceFileDescriptorSupplier
      extends DenunciaServiceBaseDescriptorSupplier {
    DenunciaServiceFileDescriptorSupplier() {}
  }

  private static final class DenunciaServiceMethodDescriptorSupplier
      extends DenunciaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DenunciaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DenunciaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DenunciaServiceFileDescriptorSupplier())
              .addMethod(getFindUnresolvedMethod())
              .addMethod(getAddDenunciaMethod())
              .addMethod(getResolverDenunciaMethod())
              .addMethod(getTraerDenunciaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
