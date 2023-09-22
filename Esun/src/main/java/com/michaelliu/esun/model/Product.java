package com.michaelliu.esun.model;

import java.math.BigDecimal;

public class Product {
    String productid;
    String productname;
    BigDecimal price;
    Integer quantity;

    public String getProductid() {
        return productid;
    }

    public void setProduct_id(String  product_id) {
        this.productid = product_id;
    }

    public String getProduct_name() {
        return productname;
    }

    public void setProduct_name(String product_name) {
        this.productname = product_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
