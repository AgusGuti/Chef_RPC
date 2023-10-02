package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: popularidadUser.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PopularidadUsersServiceGrpc {

  private PopularidadUsersServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.PopularidadUsersService";

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
    if ((getFindAllMethod = PopularidadUsersServiceGrpc.getFindAllMethod) == null) {
      synchronized (PopularidadUsersServiceGrpc.class) {
        if ((getFindAllMethod = PopularidadUsersServiceGrpc.getFindAllMethod) == null) {
          PopularidadUsersServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.chefencasa.model.PopularidadUserProto.PopularidadUsers>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadUserProto.PopularidadUsers.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadUsersServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadUserProto.PopularidadUser,
      com.chefencasa.model.PopularidadUserProto.PopularidadUser> getGuardarPopularidadUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GuardarPopularidadUser",
      requestType = com.chefencasa.model.PopularidadUserProto.PopularidadUser.class,
      responseType = com.chefencasa.model.PopularidadUserProto.PopularidadUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadUserProto.PopularidadUser,
      com.chefencasa.model.PopularidadUserProto.PopularidadUser> getGuardarPopularidadUserMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.PopularidadUserProto.PopularidadUser, com.chefencasa.model.PopularidadUserProto.PopularidadUser> getGuardarPopularidadUserMethod;
    if ((getGuardarPopularidadUserMethod = PopularidadUsersServiceGrpc.getGuardarPopularidadUserMethod) == null) {
      synchronized (PopularidadUsersServiceGrpc.class) {
        if ((getGuardarPopularidadUserMethod = PopularidadUsersServiceGrpc.getGuardarPopularidadUserMethod) == null) {
          PopularidadUsersServiceGrpc.getGuardarPopularidadUserMethod = getGuardarPopularidadUserMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.PopularidadUserProto.PopularidadUser, com.chefencasa.model.PopularidadUserProto.PopularidadUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GuardarPopularidadUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadUserProto.PopularidadUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.PopularidadUserProto.PopularidadUser.getDefaultInstance()))
              .setSchemaDescriptor(new PopularidadUsersServiceMethodDescriptorSupplier("GuardarPopularidadUser"))
              .build();
        }
      }
    }
    return getGuardarPopularidadUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PopularidadUsersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadUsersServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadUsersServiceStub>() {
        @java.lang.Override
        public PopularidadUsersServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadUsersServiceStub(channel, callOptions);
        }
      };
    return PopularidadUsersServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PopularidadUsersServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadUsersServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadUsersServiceBlockingStub>() {
        @java.lang.Override
        public PopularidadUsersServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadUsersServiceBlockingStub(channel, callOptions);
        }
      };
    return PopularidadUsersServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PopularidadUsersServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PopularidadUsersServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PopularidadUsersServiceFutureStub>() {
        @java.lang.Override
        public PopularidadUsersServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PopularidadUsersServiceFutureStub(channel, callOptions);
        }
      };
    return PopularidadUsersServiceFutureStub.newStub(factory, channel);
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

    /**
     */
    default void guardarPopularidadUser(com.chefencasa.model.PopularidadUserProto.PopularidadUser request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGuardarPopularidadUserMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PopularidadUsersService.
   */
  public static abstract class PopularidadUsersServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PopularidadUsersServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PopularidadUsersService.
   */
  public static final class PopularidadUsersServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PopularidadUsersServiceStub> {
    private PopularidadUsersServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadUsersServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadUsersServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUsers> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void guardarPopularidadUser(com.chefencasa.model.PopularidadUserProto.PopularidadUser request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGuardarPopularidadUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PopularidadUsersService.
   */
  public static final class PopularidadUsersServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PopularidadUsersServiceBlockingStub> {
    private PopularidadUsersServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadUsersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadUsersServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.PopularidadUserProto.PopularidadUsers findAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.PopularidadUserProto.PopularidadUser guardarPopularidadUser(com.chefencasa.model.PopularidadUserProto.PopularidadUser request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGuardarPopularidadUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PopularidadUsersService.
   */
  public static final class PopularidadUsersServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PopularidadUsersServiceFutureStub> {
    private PopularidadUsersServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PopularidadUsersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PopularidadUsersServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadUserProto.PopularidadUsers> findAll(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.PopularidadUserProto.PopularidadUser> guardarPopularidadUser(
        com.chefencasa.model.PopularidadUserProto.PopularidadUser request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGuardarPopularidadUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_GUARDAR_POPULARIDAD_USER = 1;

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
        case METHODID_GUARDAR_POPULARIDAD_USER:
          serviceImpl.guardarPopularidadUser((com.chefencasa.model.PopularidadUserProto.PopularidadUser) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.PopularidadUserProto.PopularidadUser>) responseObserver);
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
        .addMethod(
          getGuardarPopularidadUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.PopularidadUserProto.PopularidadUser,
              com.chefencasa.model.PopularidadUserProto.PopularidadUser>(
                service, METHODID_GUARDAR_POPULARIDAD_USER)))
        .build();
  }

  private static abstract class PopularidadUsersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PopularidadUsersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.PopularidadUserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PopularidadUsersService");
    }
  }

  private static final class PopularidadUsersServiceFileDescriptorSupplier
      extends PopularidadUsersServiceBaseDescriptorSupplier {
    PopularidadUsersServiceFileDescriptorSupplier() {}
  }

  private static final class PopularidadUsersServiceMethodDescriptorSupplier
      extends PopularidadUsersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PopularidadUsersServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PopularidadUsersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PopularidadUsersServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getGuardarPopularidadUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
