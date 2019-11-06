package com.switchfully.order.domain.order;

import com.switchfully.order.domain.costumer.Costumer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderRepository {
    private Map<String, Order> orderRepository = new HashMap<>();

    public Order placeOrder(Order order){
        orderRepository.put(order.getOrderId(), order);
        return order;
    }
}
