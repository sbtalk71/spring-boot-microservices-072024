// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: calculator.proto

// Protobuf Java Version: 3.25.3
package com.demo.grpc;

public final class CalculatorDemo {
  private CalculatorDemo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_demo_grpc_MathRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_demo_grpc_MathRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_demo_grpc_MathResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_demo_grpc_MathResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020calculator.proto\022\rcom.demo.grpc\"E\n\013Mat" +
      "hRequest\022\021\n\004num1\030\001 \001(\005H\000\210\001\001\022\021\n\004num2\030\002 \001(" +
      "\005H\001\210\001\001B\007\n\005_num1B\007\n\005_num2\".\n\014MathResponse" +
      "\022\023\n\006result\030\001 \001(\005H\000\210\001\001B\t\n\007_result2\231\002\n\nCal" +
      "culator\022>\n\003add\022\032.com.demo.grpc.MathReque" +
      "st\032\033.com.demo.grpc.MathResponse\022C\n\010subtr" +
      "act\022\032.com.demo.grpc.MathRequest\032\033.com.de" +
      "mo.grpc.MathResponse\022C\n\010multiply\022\032.com.d" +
      "emo.grpc.MathRequest\032\033.com.demo.grpc.Mat" +
      "hResponse\022A\n\006divide\022\032.com.demo.grpc.Math" +
      "Request\032\033.com.demo.grpc.MathResponseB!\n\r" +
      "com.demo.grpcB\016CalculatorDemoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_demo_grpc_MathRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_demo_grpc_MathRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_demo_grpc_MathRequest_descriptor,
        new java.lang.String[] { "Num1", "Num2", });
    internal_static_com_demo_grpc_MathResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_demo_grpc_MathResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_demo_grpc_MathResponse_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
