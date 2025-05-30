package com.example.springbootgrpc.client;

import com.example.springbootgrpc.ProductServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcClientConfig {

    @Bean
    ProductServiceGrpc.ProductServiceBlockingStub stub(GrpcChannelFactory channels) {
        return ProductServiceGrpc.newBlockingStub(channels.createChannel("product-service"));
    }

}
