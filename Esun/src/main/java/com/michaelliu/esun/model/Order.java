package com.michaelliu.esun.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String orderid;
    private Integer memberid;
    private BigDecimal price;
}
