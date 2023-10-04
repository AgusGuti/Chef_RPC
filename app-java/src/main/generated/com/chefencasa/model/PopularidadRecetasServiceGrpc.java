package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: popularidadReceta.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PopularidadRecetasServiceGrpc {

  private PopularidadRecetasServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.PopularidadRecetasService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta,
      com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> getTraerPuntajePorRecetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TraerPuntajePorReceta",
      requestType = com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.class,
      responseType = com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta,
      com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> getTraerPuntajePorRecetaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta, com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> getTraerPuntajePorRecetaMethod;
    if ((getTraerPuntajePorRecetaMethod = PopularidadRecetasServiceGrpc.getTraerPuntajePorRecetaMethod) == null) {
      synchronized (PopularidadRecetasServiceGrpc.class) {
        if ((getTraerPuntajePorRecetaMethod = PopularidadRecetasServiceGrpc.getTraerPuntajePorRecetaMethod) == null) {
          PopularidadRecetasServiceGrpc.getTraerPuntajePorRecetaMethod = getTraerPuntajePorRecetaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta, com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TraerPuntajePorReceta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadRecetasServiceMethodDescriptorSupplier("TraerPuntajePorReceta"))
              .build();
        }
      }
    }
    return getTraerPuntajePorRecetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> getFindAllMethod;
    if ((getFindAllMethod = PopularidadRecetasServiceGrpc.getFindAllMethod) == null) {
      synchronized (PopularidadRecetasServiceGrpc.class) {
        if ((getFindAllMethod = PopularidadRecetasServiceGrpc.getFindAllMethod) == null) {
          PopularidadRecetasServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadRecetasServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta,
      com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> getGuardarPopularidadRecetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GuardarPopularidadReceta",
      requestType = com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.class,
      responseType = com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta,
      com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> getGuardarPopularidadRecetaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta, com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> getGuardarPopularidadRecetaMethod;
    if ((getGuardarPopularidadRecetaMethod = PopularidadRecetasServiceGrpc.getGuardarPopularidadRecetaMethod) == null) {
      synchronized (PopularidadRecetasServiceGrpc.class) {
        if ((getGuardarPopularidadRecetaMethod = PopularidadRecetasServiceGrpc.getGuardarPopularidadRecetaMethod) == null) {
          PopularidadRecetasServiceGrpc.getGuardarPopularidadRecetaMethod = getGuardarPopularidadRecetaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta, com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GuardarPopularidadReceta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadRecetasServiceMethodDescriptorSupplier("GuardarPopularidadReceta"))
              .build();
        }
      }
    }
    return getGuardarPopularidadRecetaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PopularidadRecetasServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetasServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetasServiceStub>() {
        @java.lang.Override
        public PopularidadRecetasServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadRecetasServiceStub(channel, callOptions);
        }
      };
    return PopularidadRecetasServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PopularidadRecetasServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetasServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetasServiceBlockingStub>() {
        @java.lang.Override
        public PopularidadRecetasServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadRecetasServiceBlockingStub(channel, callOptions);
        }
      };
    return PopularidadRecetasServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PopularidadRecetasServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetasServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetasServiceFutureStub>() {
        @java.lang.Override
        public PopularidadRecetasServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadRecetasServiceFutureStub(channel, callOptions);
        }
      };
    return PopularidadRecetasServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void traerPuntajePorReceta(com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTraerPuntajePorRecetaMethod(), responseObserver);
    }

    /**
     */
    default void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    default void guardarPopularidadReceta(com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGuardarPopularidadRecetaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PopularidadRecetasService.
   */
  public static abstract class PopularidadRecetasServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PopularidadRecetasServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PopularidadRecetasService.
   */
  public static final class PopularidadRecetasServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PopularidadRecetasServiceStub> {
    private PopularidadRecetasServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadRecetasServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadRecetasServiceStub(channel, callOptions);
    }

    /**
     */
    public void traerPuntajePorReceta(com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTraerPuntajePorRecetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void guardarPopularidadReceta(com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGuardarPopularidadRecetaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PopularidadRecetasService.
   */
  public static final class PopularidadRecetasServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PopularidadRecetasServiceBlockingStub> {
    private PopularidadRecetasServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadRecetasServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadRecetasServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta traerPuntajePorReceta(com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTraerPuntajePorRecetaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas findAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta guardarPopularidadReceta(com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGuardarPopularidadRecetaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PopularidadRecetasService.
   */
  public static final class PopularidadRecetasServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PopularidadRecetasServiceFutureStub> {
    private PopularidadRecetasServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadRecetasServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadRecetasServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> traerPuntajePorReceta(
        com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTraerPuntajePorRecetaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> findAll(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta> guardarPopularidadReceta(
        com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGuardarPopularidadRecetaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRAER_PUNTAJE_POR_RECETA = 0;
  private static final int METHODID_FIND_ALL = 1;
  private static final int METHODID_GUARDAR_POPULARIDAD_RECETA = 2;

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
        case METHODID_TRAER_PUNTAJE_POR_RECETA:
          serviceImpl.traerPuntajePorReceta((com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas>) responseObserver);
          break;
        case METHODID_GUARDAR_POPULARIDAD_RECETA:
          serviceImpl.guardarPopularidadReceta((com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta>) responseObserver);
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
          getTraerPuntajePorRecetaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta,
              com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta>(
                service, METHODID_TRAER_PUNTAJE_POR_RECETA)))
        .addMethod(
          getFindAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas>(
                service, METHODID_FIND_ALL)))
        .addMethod(
          getGuardarPopularidadRecetaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta,
              com.chefencasa.model.PopularidadRecetaProto.PopularidadReceta>(
                service, METHODID_GUARDAR_POPULARIDAD_RECETA)))
        .build();
  }

  private static abstract class PopularidadRecetasServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PopularidadRecetasServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.PopularidadRecetaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PopularidadRecetasService");
    }
  }

  private static final class PopularidadRecetasServiceFileDescriptorSupplier
      extends PopularidadRecetasServiceBaseDescriptorSupplier {
    PopularidadRecetasServiceFileDescriptorSupplier() {}
  }

  private static final class PopularidadRecetasServiceMethodDescriptorSupplier
      extends PopularidadRecetasServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PopularidadRecetasServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PopularidadRecetasServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PopularidadRecetasServiceFileDescriptorSupplier())
              .addMethod(getTraerPuntajePorRecetaMethod())
              .addMethod(getFindAllMethod())
              .addMethod(getGuardarPopularidadRecetaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
