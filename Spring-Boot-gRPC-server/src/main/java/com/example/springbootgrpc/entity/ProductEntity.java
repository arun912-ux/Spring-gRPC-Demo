package com.example.springbootgrpc.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "category")
    private String category;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "location")
    private String location;

    @Column(name = "is_available")
    private String isAvailable;

    @Column(name = "purchase_date")
    private Date purchaseDate;

}
