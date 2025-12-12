package com.desafioNelio.desafio.services;

import com.desafioNelio.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double basic = order.getBasic();
        double discount = order.getDiscount();

        double totalWithDiscount = basic - (basic * (discount/100));

        return totalWithDiscount + shippingService.calculateShipping(order);
    }
}
