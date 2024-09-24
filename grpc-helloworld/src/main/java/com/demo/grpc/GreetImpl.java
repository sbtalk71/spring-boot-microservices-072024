package com.demo.grpc;

import com.example.grpc.HelloReply;
import com.example.grpc.HelloReplyOrBuilder;
import com.example.grpc.HelloRequest;
import com.example.grpc.GreeterGrpc.GreeterImplBase;

import io.grpc.stub.StreamObserver;

public class GreetImpl extends GreeterImplBase {
@Override
public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
	
	HelloReply reply=HelloReply.newBuilder().setMessage(request.getName()+" Welcome to GRPC").build();
	responseObserver.onNext(reply);
	responseObserver.onCompleted();
}
}
