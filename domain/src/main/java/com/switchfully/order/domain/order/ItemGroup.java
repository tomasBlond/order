package com.switchfully.order.domain.order;

import java.time.LocalDate;

public class ItemGroup {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;
    private double price;

    public ItemGroup(String itemId, int amount) {
        if (amount < 1){
            throw new IllegalArgumentException("To place an order, amount must be bigger than 1");
        }
        this.itemId = itemId;
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public double getPrice() {
        return price;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
