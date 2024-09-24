package com.demo.grpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class CalculatorServer {

	public static void main(String[] args) throws Exception{

		Server server = ServerBuilder
				.forPort(9000)
				.addService(new CalculatorImpl())
				.build();
		
		System.out.println("Server Started....");
		server.start();
		
		server.awaitTermination();
		
	}
}
