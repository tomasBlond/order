package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.Item;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private Item item;
    private String id;
    private int amount;
    private LocalDate shippingDate;

    public ItemGroup(Item item, int amount) {
        this.item = item;
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        if (item.getStockAmount() > amount){
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusDays(7);
        }
    }

    public double calculatePrice(){
        return item.getPrice() * amount;
    }

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
}
