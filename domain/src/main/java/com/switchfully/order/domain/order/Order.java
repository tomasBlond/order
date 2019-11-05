package com.switchfully.order.domain.order;

import java.util.List;

public class Order {
    private String costumerId;
    private double price;
    private List<ItemGroup> itemGroups;

    public Order(String costumerId, List<ItemGroup> itemGroups) {
        this.costumerId = costumerId;
        this.itemGroups = itemGroups;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public String getCostumerId() {
        return costumerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
