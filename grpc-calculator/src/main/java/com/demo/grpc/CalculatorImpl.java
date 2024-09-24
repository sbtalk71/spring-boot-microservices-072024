package com.demo.grpc;

import com.demo.grpc.CalculatorGrpc.CalculatorImplBase;

import io.grpc.stub.StreamObserver;

public class CalculatorImpl extends CalculatorImplBase {

	@Override
	public void add(MathRequest request, StreamObserver<MathResponse> responseObserver) {

		responseObserver.onNext(MathResponse.newBuilder().setResult(request.getNum1() + request.getNum2()).build());
		responseObserver.onCompleted();
	}

	@Override
	public void multiply(MathRequest request, StreamObserver<MathResponse> responseObserver) {

		super.multiply(request, responseObserver);
	}

	@Override
	public void divide(MathRequest request, StreamObserver<MathResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.divide(request, responseObserver);
	}

	@Override
	public void subtract(MathRequest request, StreamObserver<MathResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.subtract(request, responseObserver);
	}

}
