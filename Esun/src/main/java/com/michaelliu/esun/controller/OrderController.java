package com.michaelliu.esun.controller;

import com.michaelliu.esun.dto.CreateOrderRequest;
import com.michaelliu.esun.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/members/{memberid}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer memberid,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){
        Integer orderId = orderService.createOrder(memberid,createOrderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
