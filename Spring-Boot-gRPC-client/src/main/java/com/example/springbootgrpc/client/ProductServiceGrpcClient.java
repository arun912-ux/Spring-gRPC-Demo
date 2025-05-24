package com.example.springbootgrpc.client;

import com.example.springbootgrpc.Product;
import com.example.springbootgrpc.ProductServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ProductServiceGrpcClient {

    private final static String GRPC_SERVER_HOST = "127.0.0.1";
    private final static Integer GRPC_SERVER_PORT = 9091;

    /**
     * This class is a GRPC client for {@link ProductServiceGrpc}
     * <p>
     * It provides a convenient way to communicate with the GRPC server
     * </p>
     */
    public Product.ProductResponse getProduct(int id) {

        // Generate a GRPC client using the ManagedChannelBuilder
        ManagedChannel channel = ManagedChannelBuilder.forAddress(GRPC_SERVER_HOST, GRPC_SERVER_PORT)
                .usePlaintext()
                .build();
        ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub = ProductServiceGrpc.newBlockingStub(channel);

        Product.ProductRequest request = Product.ProductRequest.newBuilder()
                .setId(id)
                .build();

        Product.ProductResponse productResponse = productServiceBlockingStub.getProduct(request);
        log.info("GRPC response: {}", productResponse);
        channel.shutdown();
        return productResponse;

    }


}
