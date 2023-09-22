package com.michaelliu.esun.service.impl;

import com.michaelliu.esun.dao.ProductDao;
import com.michaelliu.esun.dto.ProductRequest;
import com.michaelliu.esun.model.Product;
import com.michaelliu.esun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(String productid) {
        return productDao.getProductById(productid);
    }

    @Override
    public String createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(String productid, ProductRequest productRequest) {
        productDao.updateProduct(productid,productRequest);
    }

    @Override
    public void deleteProduct(String productid) {
        productDao.deleteProduct(productid);
    }
}
