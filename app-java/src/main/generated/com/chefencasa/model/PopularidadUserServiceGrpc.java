package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: popularidadUser.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PopularidadUserServiceGrpc {

  private PopularidadUserServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.PopularidadUserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.PopularidadUserProto.PopularidadUsers> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.chefencasa.model.PopularidadUserProto.PopularidadUsers.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.PopularidadUserProto.PopularidadUsers> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.chefencasa.model.PopularidadUserProto.PopularidadUsers> getFindAllMethod;
    if ((getFindAllMethod = PopularidadUserServiceGrpc.getFindAllMethod) == null) {
      synchronized (PopularidadUserServiceGrpc.class) {
        if ((getFindAllMethod = PopularidadUserServiceGrpc.getFindAllMethod) == null) {
          PopularidadUserServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.chefencasa.model.PopularidadUserProto.PopularidadUsers>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadUserProto.PopularidadUsers.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadUserServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PopularidadUserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadUserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadUserServiceStub>() {
        @java.lang.Override
        public PopularidadUserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadUserServiceStub(channel, callOptions);
        }
      };
    return PopularidadUserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PopularidadUserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadUserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadUserServiceBlockingStub>() {
        @java.lang.Override
        public PopularidadUserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadUserServiceBlockingStub(channel, callOptions);
        }
      };
    return PopularidadUserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PopularidadUserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadUserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadUserServiceFutureStub>() {
        @java.lang.Override
        public PopularidadUserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadUserServiceFutureStub(channel, callOptions);
        }
      };
    return PopularidadUserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUsers> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PopularidadUserService.
   */
  public static abstract class PopularidadUserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PopularidadUserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PopularidadUserService.
   */
  public static final class PopularidadUserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PopularidadUserServiceStub> {
    private PopularidadUserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadUserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUsers> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PopularidadUserService.
   */
  public static final class PopularidadUserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PopularidadUserServiceBlockingStub> {
    private PopularidadUserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadUserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.PopularidadUserProto.PopularidadUsers findAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PopularidadUserService.
   */
  public static final class PopularidadUserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PopularidadUserServiceFutureStub> {
    private PopularidadUserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadUserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadUserProto.PopularidadUsers> findAll(
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
              (io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUsers>) responseObserver);
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
              com.chefencasa.model.PopularidadUserProto.PopularidadUsers>(
                service, METHODID_FIND_ALL)))
        .build();
  }

  private static abstract class PopularidadUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PopularidadUserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.PopularidadUserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PopularidadUserService");
    }
  }

  private static final class PopularidadUserServiceFileDescriptorSupplier
      extends PopularidadUserServiceBaseDescriptorSupplier {
    PopularidadUserServiceFileDescriptorSupplier() {}
  }

  private static final class PopularidadUserServiceMethodDescriptorSupplier
      extends PopularidadUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PopularidadUserServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PopularidadUserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PopularidadUserServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
