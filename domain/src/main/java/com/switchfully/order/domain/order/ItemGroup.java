package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemRepository;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;
    private double price;

    public ItemGroup(String itemId, int amount) {
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
