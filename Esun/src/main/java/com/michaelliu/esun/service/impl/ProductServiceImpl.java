package com.michaelliu.esun.service.impl;

import com.michaelliu.esun.dao.ProductDao;
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
}
