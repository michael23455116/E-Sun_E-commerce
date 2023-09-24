package com.michaelliu.esun.service.impl;

import com.michaelliu.esun.dao.OrderDao;
import com.michaelliu.esun.dao.ProductDao;
import com.michaelliu.esun.dto.BuyItem;
import com.michaelliu.esun.dto.CreateOrderRequest;
import com.michaelliu.esun.model.Order;
import com.michaelliu.esun.model.Product;
import com.michaelliu.esun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public Integer createOrder(Integer memberid, CreateOrderRequest createOrderRequest) {

        BigDecimal itemPrice = BigDecimal.ZERO;
        for(BuyItem buyItem :createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductid());
            //當前單價
            BigDecimal standprice = product.getPrice();

            //計算總價
            BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(buyItem.getQuantity()));
            itemPrice = itemPrice.add(total);
        }
        //創建訂單
        String  orderid = OrderDao.createOrder();
        orderDao.createOrderItem();
        return orderid;
    }
}
