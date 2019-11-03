package com.switchfully.order.api.order.orderDto;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.order.ItemGroupRepository;

public class OrderDto {
    private Costumer costumer;
    private double price;
    private ItemGroupRepository itemGroupRepository;

    public Costumer getCostumer() {
        return costumer;
    }

    public double getPrice() {
        return price;
    }

    public ItemGroupRepository getItemGroupRepository() {
        return itemGroupRepository;
    }

    public OrderDto setCostumer(Costumer costumer) {
        this.costumer = costumer;
        return this;
    }

    public OrderDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public OrderDto setItemGroupRepository(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
        return this;
    }
}
