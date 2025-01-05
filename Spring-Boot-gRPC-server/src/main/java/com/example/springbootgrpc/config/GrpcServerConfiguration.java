//package com.example.springbootgrpc.config;
//
//import com.example.springbootgrpc.interceptor.AuthInterceptor;
//import com.example.springbootgrpc.service.ProductGrpcServiceImpl;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class GrpcServerConfiguration {
//
//    @Bean
//    public Server grpcServerBuilderConfigurer(ProductGrpcServiceImpl productGrpcService, AuthInterceptor authInterceptor) {
//
//        try {
//            return ServerBuilder.forPort(9092)
//                    .intercept(authInterceptor)
//                    .addService(productGrpcService)
//                    .build().start();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
