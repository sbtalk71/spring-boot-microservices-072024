package com.demo.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GreetServer {

	public static void main(String[] args) throws Exception {
		GreetImpl service = new GreetImpl();

		Server server = ServerBuilder.forPort(9001).addService(service).build();

		System.out.println("Server Started ...");
		server.start();

		server.awaitTermination();

	}

}
