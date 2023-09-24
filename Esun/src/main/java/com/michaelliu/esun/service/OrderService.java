package com.michaelliu.esun.service;

import com.michaelliu.esun.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer memberid, CreateOrderRequest createOrderRequest);
}
