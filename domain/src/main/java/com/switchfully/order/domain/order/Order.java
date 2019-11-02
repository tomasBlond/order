package com.switchfully.order.domain.order;

import com.switchfully.order.domain.costumer.Costumer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Costumer costumer;
    private double price;
    List<ItemGroup> itemGroups;

    public Order(Costumer costumer) {
        this.costumer = costumer;
        this.price = 0;
        this.itemGroups = new ArrayList<>();
    }

    public ItemGroup saveOrderItem(ItemGroup itemGroup){
        itemGroups.add(itemGroup);
        this.price = price + itemGroup.calculatePrice();
        return itemGroup;
    }
}
