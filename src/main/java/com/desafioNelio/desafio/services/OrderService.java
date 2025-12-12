package com.desafioNelio.desafio.services;

import com.desafioNelio.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double basic = order.getBasic();
        double discount = order.getDiscount();

        double totalWithDiscount = basic - (basic * (discount/100));

        return totalWithDiscount + shippingService.calculateShipping(order);
    }
}
