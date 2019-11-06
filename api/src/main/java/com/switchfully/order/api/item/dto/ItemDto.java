package com.switchfully.order.api.item.dto;

public class ItemDto {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int stockAmount;

    public String getItemId() {
        return itemId;
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

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDto setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
        return this;
    }

    public ItemDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }
}
