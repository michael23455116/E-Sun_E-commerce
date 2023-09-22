package com.michaelliu.esun.dao.Impl;

import com.michaelliu.esun.dao.ProductDao;
import com.michaelliu.esun.model.Product;
import com.michaelliu.esun.rowmapper.ProductRowmaaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(String productid) {
        String sql="SELECT productid,productname,price,quantity " +
                "FROM product " +
                "WHERE ProductId=:productid";
        Map<String,Object>map = new HashMap<>();
        map.put("productid",productid);
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowmaaper());

        if (!productList.isEmpty()){
            return productList.get(0);
        }else{
            return null;
        }

    }
}
