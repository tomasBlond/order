package com.switchfully.order.domain.order;

import java.util.List;
import java.util.UUID;

public class Order {
    private String orderID;
    private String costumerId;
    private double price;
    private List<ItemGroup> itemGroups;

    public Order(String costumerId, List<ItemGroup> itemGroups) {
        this.costumerId = costumerId;
        this.itemGroups = itemGroups;
        this.orderID = createOrderId();
    }

    private String createOrderId() {
        return costumerId + UUID.randomUUID().toString().substring(0,5);
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

    public String getOrderID() {
        return orderID;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
