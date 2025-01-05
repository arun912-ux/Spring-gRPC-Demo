package com.example.springbootgrpc;

import com.example.springbootgrpc.client.ProductServiceGrpcClient;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootGRpcClientApplication implements CommandLineRunner {

    /*-----------------------------------------------------------------------------------------
     * There are two ways to create a gRPC client:
     * 1. Annotated using @GrpcClient - need to add properties in application.yml
     * 2. Using GRPCClient class implementation - manually create managed channel and stub
     ----------------------------------------------------------------------------------------- */

    @Autowired
    private ProductServiceGrpcClient productServiceGrpcClient;

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub productServiceStub;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootGRpcClientApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // GRPC client created using GRPCClient class
        Product.ProductResponse productResponse = productServiceGrpcClient.getProduct(101);
        log.info("Call to GRPC server returned: {}", productResponse.toString());

        // Annotated gRPC client
        Product.ProductRequest request = Product.ProductRequest.newBuilder().setId(103).build();
        Product.ProductResponse response = productServiceStub.getProduct(request);
        log.info("Annotated GRPC client returned: {}", response);
    }
}
