package com.example.springbootgrpc.mapper;

import com.example.springbootgrpc.Product;
import com.example.springbootgrpc.entity.ProductEntity;
import com.google.protobuf.Timestamp;

import java.sql.Date;


public class ProductMapper {

    public static Product.ProductResponse mapProductEntityToProductResponse(ProductEntity source) {

        Date expirationDate = source.getExpirationDate();
        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(expirationDate.getTime() / 1000)
                .build();

        Timestamp purchaseDate = Timestamp.newBuilder()
                .setSeconds(source.getPurchaseDate().getTime() / 1000)
                .build();

        return Product.ProductResponse.newBuilder()
                .setId(source.getId())
                .setCategory(source.getCategory())
                .setProductName(source.getProductName())
                .setExpirationDate(timestamp)
                .setQuantity(source.getQuantity())
                .setPrice(source.getPrice())
                .setManufacturer(source.getManufacturer())
                .setStockSymbol(source.getStockSymbol())
                .setLocation(source.getLocation())
                .setIsAvailable(source.getIsAvailable())
                .setPurchaseDate(purchaseDate)
                .build();
    }


    public static ProductEntity mapProductToProductEntity(Product.ProductResponse source) {

        ProductEntity entity = new ProductEntity();

        entity.setId(source.getId());
        entity.setCategory(source.getCategory());
        entity.setProductName(source.getProductName());
        entity.setExpirationDate(new Date(source.getExpirationDate().getSeconds() * 1000));
        entity.setQuantity(source.getQuantity());
        entity.setPrice(source.getPrice());
        entity.setManufacturer(source.getManufacturer());
        entity.setStockSymbol(source.getStockSymbol());
        entity.setLocation(source.getLocation());
        entity.setIsAvailable(source.getIsAvailable());
        entity.setPurchaseDate(new Date(source.getPurchaseDate().getSeconds() * 1000));

        return entity;
    }

}
