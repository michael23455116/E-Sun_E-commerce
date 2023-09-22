package com.michaelliu.esun.dao;

import com.michaelliu.esun.model.Product;

public interface ProductDao {
    Product getProductById(String productid);
}
