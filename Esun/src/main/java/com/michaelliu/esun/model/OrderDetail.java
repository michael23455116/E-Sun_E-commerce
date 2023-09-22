package com.michaelliu.esun.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private Integer orderitemsn;
    private String orderid;
    private String productid;
    private Integer quantity;
    private BigDecimal standprice;
    private BigDecimal itemprice;
}