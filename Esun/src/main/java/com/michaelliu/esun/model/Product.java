package com.michaelliu.esun.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String productid;
    private String productname;
    private BigDecimal price;
    private Integer quantity;
}
