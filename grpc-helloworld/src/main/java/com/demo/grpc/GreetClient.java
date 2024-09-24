package com.demo.grpc;



import com.example.grpc.GreeterGrpc;
import com.example.grpc.GreeterGrpc.GreeterBlockingStub;
import com.example.grpc.HelloReply;
import com.example.grpc.HelloRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetClient {

	public static void main(String[] args) {
		ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost", 9001).usePlaintext().build();
		
		GreeterBlockingStub stub= GreeterGrpc.newBlockingStub(channel);
		
		HelloRequest request= HelloRequest.newBuilder().setName("Bhola").build();
		
		HelloReply reply=stub.sayHello(request);
		
		System.out.println(reply.getMessage());
		

	}

}
