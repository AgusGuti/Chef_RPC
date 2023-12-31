package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: popularidadReceta.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PopularidadRecetaServiceGrpc {

  private PopularidadRecetaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.PopularidadRecetaService";

  // Static method descriptors that strictly reflect the proto.
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
    if ((getFindAllMethod = PopularidadRecetaServiceGrpc.getFindAllMethod) == null) {
      synchronized (PopularidadRecetaServiceGrpc.class) {
        if ((getFindAllMethod = PopularidadRecetaServiceGrpc.getFindAllMethod) == null) {
          PopularidadRecetaServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadRecetaServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PopularidadRecetaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetaServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetaServiceStub>() {
        @java.lang.Override
        public PopularidadRecetaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadRecetaServiceStub(channel, callOptions);
        }
      };
    return PopularidadRecetaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PopularidadRecetaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetaServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetaServiceBlockingStub>() {
        @java.lang.Override
        public PopularidadRecetaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadRecetaServiceBlockingStub(channel, callOptions);
        }
      };
    return PopularidadRecetaServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PopularidadRecetaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetaServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadRecetaServiceFutureStub>() {
        @java.lang.Override
        public PopularidadRecetaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadRecetaServiceFutureStub(channel, callOptions);
        }
      };
    return PopularidadRecetaServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PopularidadRecetaService.
   */
  public static abstract class PopularidadRecetaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PopularidadRecetaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PopularidadRecetaService.
   */
  public static final class PopularidadRecetaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PopularidadRecetaServiceStub> {
    private PopularidadRecetaServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadRecetaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadRecetaServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PopularidadRecetaService.
   */
  public static final class PopularidadRecetaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PopularidadRecetaServiceBlockingStub> {
    private PopularidadRecetaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadRecetaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadRecetaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas findAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PopularidadRecetaService.
   */
  public static final class PopularidadRecetaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PopularidadRecetaServiceFutureStub> {
    private PopularidadRecetaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadRecetaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadRecetaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas> findAll(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;

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
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas>) responseObserver);
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
          getFindAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.chefencasa.model.PopularidadRecetaProto.PopularidadRecetas>(
                service, METHODID_FIND_ALL)))
        .build();
  }

  private static abstract class PopularidadRecetaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PopularidadRecetaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.PopularidadRecetaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PopularidadRecetaService");
    }
  }

  private static final class PopularidadRecetaServiceFileDescriptorSupplier
      extends PopularidadRecetaServiceBaseDescriptorSupplier {
    PopularidadRecetaServiceFileDescriptorSupplier() {}
  }

  private static final class PopularidadRecetaServiceMethodDescriptorSupplier
      extends PopularidadRecetaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PopularidadRecetaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PopularidadRecetaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PopularidadRecetaServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
