package com.example.springbootgrpc.service;

import com.example.springbootgrpc.Product;
import com.example.springbootgrpc.ProductRepository;
import com.example.springbootgrpc.ProductServiceGrpc;
import com.example.springbootgrpc.entity.ProductEntity;
import com.example.springbootgrpc.mapper.ProductMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.grpc.server.service.GrpcService;

import java.util.Optional;

@Slf4j
@GrpcService
public class ProductGrpcServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    public ProductGrpcServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * This class implements the ProductGrpcService.
     * It is responsible for handling gRPC requests and sending responses.
     */
    @Override
    public void getProduct(Product.ProductRequest request, StreamObserver<Product.ProductResponse> responseObserver) {
        log.info("inside getProduct method");

        int id = request.getId();
        log.info("id: {}", id);
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        log.info("optionalProduct: {}", optionalProduct.orElse(null));

        optionalProduct.ifPresentOrElse(productEntity -> {
                    Product.ProductResponse productResponse = ProductMapper.mapProductEntityToProductResponse(productEntity);
                    responseObserver.onNext(productResponse);
                },
                () -> {
                    responseObserver.onNext(null);
                });

        log.info("Response sent");
        responseObserver.onCompleted();

    }
}
