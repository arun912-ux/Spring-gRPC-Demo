//package com.example.springbootgrpc.interceptor;
//
//import io.grpc.Grpc;
//import io.grpc.Metadata;
//import io.grpc.ServerCall;
//import io.grpc.ServerCallHandler;
//import io.grpc.ServerInterceptor;
//import io.grpc.Status;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class AuthInterceptor implements ServerInterceptor {
//    @Override
//    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
//
//        log.info("Inside AuthInterceptor");
//
//        String authHeader = headers.get(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER));
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            call.close(Status.UNAUTHENTICATED.withDescription("Missing or invalid authorization header"), headers);
//            return new ServerCall.Listener<ReqT>() {
//            };  // Return empty listener to terminate the call
//        }
//        String token = authHeader.substring(7);  // Get token part of the header
//        if (!isValidJwt(token)) {
//            call.close(Status.UNAUTHENTICATED.withDescription("Invalid JWT token"), headers);
//            return new ServerCall.Listener<ReqT>() {
//            };
//        }
//
//        return next.startCall(call, headers);  // Proceed to the actual method
//    }
//
//    private boolean isValidJwt(String token) {
//        // Implement your JWT validation logic here
//        log.info("Validating JWT token: {}", token);
//        return true;
//    }
//
//}
