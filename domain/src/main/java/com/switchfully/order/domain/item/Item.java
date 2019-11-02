package com.switchfully.order.domain.item;

import java.util.UUID;

public class
Item {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stockAmount;

    public Item(String name, String description, double price, int stockAmount) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }
}
