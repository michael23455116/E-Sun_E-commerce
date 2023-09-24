package com.michaelliu.esun.dao.Impl;

import com.michaelliu.esun.dao.ProductDao;
import com.michaelliu.esun.dto.ProductRequest;
import com.michaelliu.esun.model.Product;
import com.michaelliu.esun.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
    public List<Product> getProducts() {
        String sql = "SELECT productid,productname,price,quantity " +
                "FROM product";
        Map<String,Object> map = new HashMap<>();
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return productList;
    }

    @Override
    public Product getProductById(String productid) {
        String sql="SELECT productid,productname,price,quantity " +
                "FROM product " +
                "WHERE productid=:productid";
        Map<String,Object>map = new HashMap<>();
        map.put("productid",productid);
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (!productid.isEmpty()) {
            return productList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public String createProduct(ProductRequest productrequest) {

        String sql="INSERT INTO product(productid,productname,price,quantity) " +
                "VALUES(:productid,:productname,:price,:quantity)";
            Map<String,Object>map = new HashMap<>();
            map.put("productid",productrequest.getProductid());
            map.put("productname",productrequest.getProductname());
            map.put("price",productrequest.getPrice());
            map.put("quantity",productrequest.getQuantity());
            namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
            String productid = productrequest.getProductid();
            return productid;
        }

    @Override
    public void updateProduct(String productid, ProductRequest productRequest) {
        String sql="UPDATE product SET productname = :productname,price = :price,quantity = :quantity " +
                "WHERE productid=:productid";
        Map<String,Object>map = new HashMap<>();
        map.put("productid",productRequest.getProductid());
        map.put("productname",productRequest.getProductname());
        map.put("price",productRequest.getPrice());
        map.put("quantity",productRequest.getQuantity());

        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void deleteProduct(String productid) {
        String sql ="DELETE FROM product " +
                "WHERE productid = :productid";
        Map<String,Object> map = new HashMap<>();
        map.put("productid",productid);
        namedParameterJdbcTemplate.update(sql,map);
    }
}
