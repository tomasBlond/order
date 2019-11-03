package com.switchfully.order.api.order.itemGroupDtos;

import com.switchfully.order.domain.item.Item;

import java.time.LocalDate;

public class ItemGroupDto {
    private Item item;
    private String id;
    private int amount;
    private LocalDate shippingDate;

    public Item getItem() {
        return item;
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

    public ItemGroupDto setItem(Item item) {
        this.item = item;
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
}
