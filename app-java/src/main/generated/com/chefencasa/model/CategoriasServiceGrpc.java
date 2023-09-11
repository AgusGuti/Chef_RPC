package com.chefencasa.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: categoria.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CategoriasServiceGrpc {

  private CategoriasServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "model.CategoriasService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.chefencasa.model.CategoriaProto.Categoria,
      com.chefencasa.model.CategoriaProto.Categoria> getTraerCategoriaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TraerCategoria",
      requestType = com.chefencasa.model.CategoriaProto.Categoria.class,
      responseType = com.chefencasa.model.CategoriaProto.Categoria.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.chefencasa.model.CategoriaProto.Categoria,
      com.chefencasa.model.CategoriaProto.Categoria> getTraerCategoriaMethod() {
    io.grpc.MethodDescriptor<com.chefencasa.model.CategoriaProto.Categoria, com.chefencasa.model.CategoriaProto.Categoria> getTraerCategoriaMethod;
    if ((getTraerCategoriaMethod = CategoriasServiceGrpc.getTraerCategoriaMethod) == null) {
      synchronized (CategoriasServiceGrpc.class) {
        if ((getTraerCategoriaMethod = CategoriasServiceGrpc.getTraerCategoriaMethod) == null) {
          CategoriasServiceGrpc.getTraerCategoriaMethod = getTraerCategoriaMethod =
              io.grpc.MethodDescriptor.<com.chefencasa.model.CategoriaProto.Categoria, com.chefencasa.model.CategoriaProto.Categoria>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TraerCategoria"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.CategoriaProto.Categoria.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chefencasa.model.CategoriaProto.Categoria.getDefaultInstance()))
              .setSchemaDescriptor(new CategoriasServiceMethodDescriptorSupplier("TraerCategoria"))
              .build();
        }
      }
    }
    return getTraerCategoriaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CategoriasServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoriasServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoriasServiceStub>() {
        @java.lang.Override
        public CategoriasServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoriasServiceStub(channel, callOptions);
        }
      };
    return CategoriasServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CategoriasServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoriasServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoriasServiceBlockingStub>() {
        @java.lang.Override
        public CategoriasServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoriasServiceBlockingStub(channel, callOptions);
        }
      };
    return CategoriasServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CategoriasServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoriasServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoriasServiceFutureStub>() {
        @java.lang.Override
        public CategoriasServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoriasServiceFutureStub(channel, callOptions);
        }
      };
    return CategoriasServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void traerCategoria(com.chefencasa.model.CategoriaProto.Categoria request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.CategoriaProto.Categoria> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTraerCategoriaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CategoriasService.
   */
  public static abstract class CategoriasServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CategoriasServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CategoriasService.
   */
  public static final class CategoriasServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CategoriasServiceStub> {
    private CategoriasServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoriasServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoriasServiceStub(channel, callOptions);
    }

    /**
     */
    public void traerCategoria(com.chefencasa.model.CategoriaProto.Categoria request,
        io.grpc.stub.StreamObserver<com.chefencasa.model.CategoriaProto.Categoria> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTraerCategoriaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CategoriasService.
   */
  public static final class CategoriasServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CategoriasServiceBlockingStub> {
    private CategoriasServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoriasServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoriasServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chefencasa.model.CategoriaProto.Categoria traerCategoria(com.chefencasa.model.CategoriaProto.Categoria request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTraerCategoriaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CategoriasService.
   */
  public static final class CategoriasServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CategoriasServiceFutureStub> {
    private CategoriasServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoriasServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoriasServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chefencasa.model.CategoriaProto.Categoria> traerCategoria(
        com.chefencasa.model.CategoriaProto.Categoria request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTraerCategoriaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRAER_CATEGORIA = 0;

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
        case METHODID_TRAER_CATEGORIA:
          serviceImpl.traerCategoria((com.chefencasa.model.CategoriaProto.Categoria) request,
              (io.grpc.stub.StreamObserver<com.chefencasa.model.CategoriaProto.Categoria>) responseObserver);
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
          getTraerCategoriaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.chefencasa.model.CategoriaProto.Categoria,
              com.chefencasa.model.CategoriaProto.Categoria>(
                service, METHODID_TRAER_CATEGORIA)))
        .build();
  }

  private static abstract class CategoriasServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CategoriasServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chefencasa.model.CategoriaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CategoriasService");
    }
  }

  private static final class CategoriasServiceFileDescriptorSupplier
      extends CategoriasServiceBaseDescriptorSupplier {
    CategoriasServiceFileDescriptorSupplier() {}
  }

  private static final class CategoriasServiceMethodDescriptorSupplier
      extends CategoriasServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CategoriasServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CategoriasServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CategoriasServiceFileDescriptorSupplier())
              .addMethod(getTraerCategoriaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
