package com.switchfully.order.api.item.dto;

public class CreateItemDto {
    private String name;
    private String description;
    private double price;
    private int stockAmount;

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

    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public CreateItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public CreateItemDto setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
        return this;
    }
}
