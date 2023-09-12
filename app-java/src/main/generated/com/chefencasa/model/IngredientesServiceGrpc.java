package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: ingrediente.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IngredientesServiceGrpc {

  private IngredientesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.IngredientesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.IngredienteProto.Ingrediente,
      com.chefencasa.model.IngredienteProto.Ingrediente> getTraerIngredienteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TraerIngrediente",
      requestType = com.chefencasa.model.IngredienteProto.Ingrediente.class,
      responseType = com.chefencasa.model.IngredienteProto.Ingrediente.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.IngredienteProto.Ingrediente,
      com.chefencasa.model.IngredienteProto.Ingrediente> getTraerIngredienteMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.IngredienteProto.Ingrediente, com.chefencasa.model.IngredienteProto.Ingrediente> getTraerIngredienteMethod;
    if ((getTraerIngredienteMethod = IngredientesServiceGrpc.getTraerIngredienteMethod) == null) {
      synchronized (IngredientesServiceGrpc.class) {
        if ((getTraerIngredienteMethod = IngredientesServiceGrpc.getTraerIngredienteMethod) == null) {
          IngredientesServiceGrpc.getTraerIngredienteMethod = getTraerIngredienteMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.IngredienteProto.Ingrediente, com.chefencasa.model.IngredienteProto.Ingrediente>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TraerIngrediente"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.IngredienteProto.Ingrediente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.IngredienteProto.Ingrediente.getDefaultInstance()))
              .setSchemaDescriptor(new IngredientesServiceMethodDescriptorSupplier("TraerIngrediente"))
              .build();
        }
      }
    }
    return getTraerIngredienteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.IngredienteProto.Ingredientes> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.chefencasa.model.IngredienteProto.Ingredientes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.chefencasa.model.IngredienteProto.Ingredientes> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.chefencasa.model.IngredienteProto.Ingredientes> getFindAllMethod;
    if ((getFindAllMethod = IngredientesServiceGrpc.getFindAllMethod) == null) {
      synchronized (IngredientesServiceGrpc.class) {
        if ((getFindAllMethod = IngredientesServiceGrpc.getFindAllMethod) == null) {
          IngredientesServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.chefencasa.model.IngredienteProto.Ingredientes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.IngredienteProto.Ingredientes.getDefaultInstance()))
              .setSchemaDescriptor(new IngredientesServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IngredientesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngredientesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IngredientesServiceStub>() {
        @java.lang.Override
        public IngredientesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IngredientesServiceStub(channel, callOptions);
        }
      };
    return IngredientesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IngredientesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngredientesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IngredientesServiceBlockingStub>() {
        @java.lang.Override
        public IngredientesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IngredientesServiceBlockingStub(channel, callOptions);
        }
      };
    return IngredientesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IngredientesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngredientesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IngredientesServiceFutureStub>() {
        @java.lang.Override
        public IngredientesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IngredientesServiceFutureStub(channel, callOptions);
        }
      };
    return IngredientesServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void traerIngrediente(com.chefencasa.model.IngredienteProto.Ingrediente request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.IngredienteProto.Ingrediente> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTraerIngredienteMethod(), responseObserver);
    }

    /**
     */
    default void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.IngredienteProto.Ingredientes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IngredientesService.
   */
  public static abstract class IngredientesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IngredientesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IngredientesService.
   */
  public static final class IngredientesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IngredientesServiceStub> {
    private IngredientesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngredientesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngredientesServiceStub(channel, callOptions);
    }

    /**
     */
    public void traerIngrediente(com.chefencasa.model.IngredienteProto.Ingrediente request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.IngredienteProto.Ingrediente> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTraerIngredienteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.IngredienteProto.Ingredientes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IngredientesService.
   */
  public static final class IngredientesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IngredientesServiceBlockingStub> {
    private IngredientesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngredientesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngredientesServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.IngredienteProto.Ingrediente traerIngrediente(com.chefencasa.model.IngredienteProto.Ingrediente request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTraerIngredienteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.chefencasa.model.IngredienteProto.Ingredientes findAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IngredientesService.
   */
  public static final class IngredientesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IngredientesServiceFutureStub> {
    private IngredientesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngredientesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngredientesServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.IngredienteProto.Ingrediente> traerIngrediente(
        com.chefencasa.model.IngredienteProto.Ingrediente request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTraerIngredienteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.IngredienteProto.Ingredientes> findAll(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRAER_INGREDIENTE = 0;
  private static final int METHODID_FIND_ALL = 1;

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
        case METHODID_TRAER_INGREDIENTE:
          serviceImpl.traerIngrediente((com.chefencasa.model.IngredienteProto.Ingrediente) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.IngredienteProto.Ingrediente>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.IngredienteProto.Ingredientes>) responseObserver);
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
          getTraerIngredienteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.IngredienteProto.Ingrediente,
              com.chefencasa.model.IngredienteProto.Ingrediente>(
                service, METHODID_TRAER_INGREDIENTE)))
        .addMethod(
          getFindAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.chefencasa.model.IngredienteProto.Ingredientes>(
                service, METHODID_FIND_ALL)))
        .build();
  }

  private static abstract class IngredientesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IngredientesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.IngredienteProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IngredientesService");
    }
  }

  private static final class IngredientesServiceFileDescriptorSupplier
      extends IngredientesServiceBaseDescriptorSupplier {
    IngredientesServiceFileDescriptorSupplier() {}
  }

  private static final class IngredientesServiceMethodDescriptorSupplier
      extends IngredientesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IngredientesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IngredientesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IngredientesServiceFileDescriptorSupplier())
              .addMethod(getTraerIngredienteMethod())
              .addMethod(getFindAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
