package com.demo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: calculator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CalculatorGrpc {

  private CalculatorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.demo.grpc.Calculator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = com.demo.grpc.MathRequest.class,
      responseType = com.demo.grpc.MathResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getAddMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse> getAddMethod;
    if ((getAddMethod = CalculatorGrpc.getAddMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getAddMethod = CalculatorGrpc.getAddMethod) == null) {
          CalculatorGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getSubtractMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subtract",
      requestType = com.demo.grpc.MathRequest.class,
      responseType = com.demo.grpc.MathResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getSubtractMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse> getSubtractMethod;
    if ((getSubtractMethod = CalculatorGrpc.getSubtractMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getSubtractMethod = CalculatorGrpc.getSubtractMethod) == null) {
          CalculatorGrpc.getSubtractMethod = getSubtractMethod =
              io.grpc.MethodDescriptor.<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subtract"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("subtract"))
              .build();
        }
      }
    }
    return getSubtractMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getMultiplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multiply",
      requestType = com.demo.grpc.MathRequest.class,
      responseType = com.demo.grpc.MathResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getMultiplyMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse> getMultiplyMethod;
    if ((getMultiplyMethod = CalculatorGrpc.getMultiplyMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getMultiplyMethod = CalculatorGrpc.getMultiplyMethod) == null) {
          CalculatorGrpc.getMultiplyMethod = getMultiplyMethod =
              io.grpc.MethodDescriptor.<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multiply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("multiply"))
              .build();
        }
      }
    }
    return getMultiplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getDivideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "divide",
      requestType = com.demo.grpc.MathRequest.class,
      responseType = com.demo.grpc.MathResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.MathRequest,
      com.demo.grpc.MathResponse> getDivideMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse> getDivideMethod;
    if ((getDivideMethod = CalculatorGrpc.getDivideMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getDivideMethod = CalculatorGrpc.getDivideMethod) == null) {
          CalculatorGrpc.getDivideMethod = getDivideMethod =
              io.grpc.MethodDescriptor.<com.demo.grpc.MathRequest, com.demo.grpc.MathResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "divide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.MathResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("divide"))
              .build();
        }
      }
    }
    return getDivideMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorStub>() {
        @java.lang.Override
        public CalculatorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorStub(channel, callOptions);
        }
      };
    return CalculatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorBlockingStub>() {
        @java.lang.Override
        public CalculatorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorBlockingStub(channel, callOptions);
        }
      };
    return CalculatorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorFutureStub>() {
        @java.lang.Override
        public CalculatorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorFutureStub(channel, callOptions);
        }
      };
    return CalculatorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void add(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    default void subtract(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubtractMethod(), responseObserver);
    }

    /**
     */
    default void multiply(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMultiplyMethod(), responseObserver);
    }

    /**
     */
    default void divide(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDivideMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Calculator.
   */
  public static abstract class CalculatorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CalculatorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Calculator.
   */
  public static final class CalculatorStub
      extends io.grpc.stub.AbstractAsyncStub<CalculatorStub> {
    private CalculatorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorStub(channel, callOptions);
    }

    /**
     */
    public void add(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subtract(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubtractMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void multiply(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMultiplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void divide(com.demo.grpc.MathRequest request,
        io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDivideMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Calculator.
   */
  public static final class CalculatorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CalculatorBlockingStub> {
    private CalculatorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.demo.grpc.MathResponse add(com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.demo.grpc.MathResponse subtract(com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubtractMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.demo.grpc.MathResponse multiply(com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMultiplyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.demo.grpc.MathResponse divide(com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDivideMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Calculator.
   */
  public static final class CalculatorFutureStub
      extends io.grpc.stub.AbstractFutureStub<CalculatorFutureStub> {
    private CalculatorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.MathResponse> add(
        com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.MathResponse> subtract(
        com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubtractMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.MathResponse> multiply(
        com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMultiplyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.MathResponse> divide(
        com.demo.grpc.MathRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDivideMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_SUBTRACT = 1;
  private static final int METHODID_MULTIPLY = 2;
  private static final int METHODID_DIVIDE = 3;

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
        case METHODID_ADD:
          serviceImpl.add((com.demo.grpc.MathRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse>) responseObserver);
          break;
        case METHODID_SUBTRACT:
          serviceImpl.subtract((com.demo.grpc.MathRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse>) responseObserver);
          break;
        case METHODID_MULTIPLY:
          serviceImpl.multiply((com.demo.grpc.MathRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse>) responseObserver);
          break;
        case METHODID_DIVIDE:
          serviceImpl.divide((com.demo.grpc.MathRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.MathResponse>) responseObserver);
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
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.demo.grpc.MathRequest,
              com.demo.grpc.MathResponse>(
                service, METHODID_ADD)))
        .addMethod(
          getSubtractMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.demo.grpc.MathRequest,
              com.demo.grpc.MathResponse>(
                service, METHODID_SUBTRACT)))
        .addMethod(
          getMultiplyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.demo.grpc.MathRequest,
              com.demo.grpc.MathResponse>(
                service, METHODID_MULTIPLY)))
        .addMethod(
          getDivideMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.demo.grpc.MathRequest,
              com.demo.grpc.MathResponse>(
                service, METHODID_DIVIDE)))
        .build();
  }

  private static abstract class CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.grpc.CalculatorDemo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calculator");
    }
  }

  private static final class CalculatorFileDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier {
    CalculatorFileDescriptorSupplier() {}
  }

  private static final class CalculatorMethodDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CalculatorMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CalculatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getSubtractMethod())
              .addMethod(getMultiplyMethod())
              .addMethod(getDivideMethod())
              .build();
        }
      }
    }
    return result;
  }
}
