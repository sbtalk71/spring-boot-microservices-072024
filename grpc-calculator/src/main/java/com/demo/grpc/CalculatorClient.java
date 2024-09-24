package com.demo.grpc;

import com.demo.grpc.CalculatorGrpc.CalculatorBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder
								.forAddress("localhost", 9000)
								.usePlaintext()
								.build();
		
		CalculatorBlockingStub stub= CalculatorGrpc.newBlockingStub(channel);
		
		MathRequest request= MathRequest.newBuilder().setNum1(20).setNum2(30).build();
		
		MathResponse response=stub.add(request);
		
		System.out.println(response.getResult());
		
		channel.shutdown();

	}

}
