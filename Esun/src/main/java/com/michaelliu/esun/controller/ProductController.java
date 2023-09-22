package com.michaelliu.esun.controller;

import com.michaelliu.esun.dto.ProductRequest;
import com.michaelliu.esun.model.Product;
import com.michaelliu.esun.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productid}")
    public ResponseEntity<Product>getProduct(@PathVariable String productid){
        Product product = productService.getProductById(productid);
        if(product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product>createProduct(@RequestBody @Valid ProductRequest productRequest){
        String productid = productService.createProduct(productRequest);
        Product product =productService.getProductById(productid);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productid}")
    public ResponseEntity<Product>updateProduct(@PathVariable String productid,
                                                @RequestBody @Valid ProductRequest productRequest){
        //檢查Product是否存在
        Product product =productService.getProductById(productid);
        if(productid == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品的數據
        productService.updateProduct(productid,productRequest);
        Product updatedProduct = productService.getProductById(productid);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{productid}")
    public ResponseEntity<?>deleteProduct(@PathVariable String productid){
        productService.deleteProduct(productid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}