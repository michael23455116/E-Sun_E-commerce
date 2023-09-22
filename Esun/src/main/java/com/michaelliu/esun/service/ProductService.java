package com.michaelliu.esun.service;

import com.michaelliu.esun.dto.ProductRequest;
import com.michaelliu.esun.model.Product;

public interface ProductService {
    Product getProductById(String productid);
    String createProduct(ProductRequest productRequest);
    void updateProduct(String productid,ProductRequest productRequest);
    void deleteProduct(String productid);
}
