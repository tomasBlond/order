package com.switchfully.order.domain.order;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderRepository {
    private Map<String, Order> orderRepository = new HashMap<>();

    public Order placeOrder(Order order){
        orderRepository.put(order.getCostumerId(), order);
        return order;
    }

    public Map<String, Order> getOrderRepository() {
        return orderRepository;
    }
}
