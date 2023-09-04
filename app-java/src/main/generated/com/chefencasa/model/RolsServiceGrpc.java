package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: rol.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RolsServiceGrpc {

  private RolsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.RolsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.RolProto.Rol,
      com.chefencasa.model.RolProto.Rol> getAddRolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddRol",
      requestType = com.chefencasa.model.RolProto.Rol.class,
      responseType = com.chefencasa.model.RolProto.Rol.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.RolProto.Rol,
      com.chefencasa.model.RolProto.Rol> getAddRolMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.RolProto.Rol, com.chefencasa.model.RolProto.Rol> getAddRolMethod;
    if ((getAddRolMethod = RolsServiceGrpc.getAddRolMethod) == null) {
      synchronized (RolsServiceGrpc.class) {
        if ((getAddRolMethod = RolsServiceGrpc.getAddRolMethod) == null) {
          RolsServiceGrpc.getAddRolMethod = getAddRolMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.RolProto.Rol, com.chefencasa.model.RolProto.Rol>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddRol"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RolProto.Rol.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.RolProto.Rol.getDefaultInstance()))
              .setSchemaDescriptor(new RolsServiceMethodDescriptorSupplier("AddRol"))
              .build();
        }
      }
    }
    return getAddRolMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RolsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RolsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RolsServiceStub>() {
        @java.lang.Override
        public RolsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RolsServiceStub(channel, callOptions);
        }
      };
    return RolsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RolsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RolsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RolsServiceBlockingStub>() {
        @java.lang.Override
        public RolsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RolsServiceBlockingStub(channel, callOptions);
        }
      };
    return RolsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RolsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RolsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RolsServiceFutureStub>() {
        @java.lang.Override
        public RolsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RolsServiceFutureStub(channel, callOptions);
        }
      };
    return RolsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addRol(com.chefencasa.model.RolProto.Rol request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RolProto.Rol> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRolMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RolsService.
   */
  public static abstract class RolsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RolsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RolsService.
   */
  public static final class RolsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RolsServiceStub> {
    private RolsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RolsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RolsServiceStub(channel, callOptions);
    }

    /**
     */
    public void addRol(com.chefencasa.model.RolProto.Rol request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.RolProto.Rol> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRolMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RolsService.
   */
  public static final class RolsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RolsServiceBlockingStub> {
    private RolsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RolsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RolsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.RolProto.Rol addRol(com.chefencasa.model.RolProto.Rol request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRolMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RolsService.
   */
  public static final class RolsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RolsServiceFutureStub> {
    private RolsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RolsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RolsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.RolProto.Rol> addRol(
        com.chefencasa.model.RolProto.Rol request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRolMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_ROL = 0;

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
        case METHODID_ADD_ROL:
          serviceImpl.addRol((com.chefencasa.model.RolProto.Rol) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.RolProto.Rol>) responseObserver);
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
          getAddRolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.RolProto.Rol,
              com.chefencasa.model.RolProto.Rol>(
                service, METHODID_ADD_ROL)))
        .build();
  }

  private static abstract class RolsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RolsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.RolProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RolsService");
    }
  }

  private static final class RolsServiceFileDescriptorSupplier
      extends RolsServiceBaseDescriptorSupplier {
    RolsServiceFileDescriptorSupplier() {}
  }

  private static final class RolsServiceMethodDescriptorSupplier
      extends RolsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RolsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RolsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RolsServiceFileDescriptorSupplier())
              .addMethod(getAddRolMethod())
              .build();
        }
      }
    }
    return result;
  }
}
