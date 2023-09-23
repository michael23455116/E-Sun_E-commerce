package com.michaelliu.esun.dao;

import com.michaelliu.esun.dto.ProductRequest;
import com.michaelliu.esun.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    Product getProductById(String productid);
    String createProduct(ProductRequest productRequest);
    void updateProduct(String productid,ProductRequest productRequest);
    void deleteProduct(String productid);
}
