package com.switchfully.order.api.order.orderDto;

import java.time.LocalDate;

public class ItemGroupDto {
    private String id;
    private int amount;
    private LocalDate shippingDate;
    private double unitPrice;
    private double price;

    public double getUnitPrice() {
        return unitPrice;
    }

    public ItemGroupDto setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public ItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemGroupDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public ItemGroupDto setId(String id) {
        this.id = id;
        return this;
    }

    public ItemGroupDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getPrice() {
        return price;
    }
}
