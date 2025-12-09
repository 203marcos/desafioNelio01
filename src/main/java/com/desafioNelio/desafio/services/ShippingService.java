package com.desafioNelio.desafio.services;

import com.desafioNelio.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double calculateShipping(Order order) {
        double basicValue = order.getBasic();

        if (basicValue >= 200.0) return 0.0;
        if (basicValue >= 100.0) return 12.0;

        return 20.0;
    }
}
