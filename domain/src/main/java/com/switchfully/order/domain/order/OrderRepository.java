package com.switchfully.order.domain.order;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrderRepository {
    private Map<String, Order> orderRepository = new HashMap<>();

    public Order placeOrder(Order order){
        orderRepository.put(order.getOrderID(), order);
        return order;
    }

    public Map<String, Order> getOrderRepository() {
        return orderRepository;
    }

    public List<Order> getOrdersFromCostumer(String costumerId){
        return orderRepository.values().stream()
                .filter(order -> order.getCostumerId().equals(costumerId))
                .collect(Collectors.toList());
    }
}
