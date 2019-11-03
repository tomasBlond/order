package com.switchfully.order.domain.order;

import com.switchfully.order.domain.costumer.Costumer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Costumer costumer;
    private double price;
    private ItemGroupRepository itemGroupRepository;

    public Order(Costumer costumer) {
        this.costumer = costumer;
        this.price = 0;
    }

    public double calculateOrderPrice(){
        this.price = itemGroupRepository.getItemGroups().stream()
                .mapToDouble(ItemGroup::calculatePrice).sum();
        return price;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public double getPrice() {
        return price;
    }

    public ItemGroupRepository getItemGroupRepository() {
        return itemGroupRepository;
    }
}
