package com.switchfully.order.api.order.orderDto;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.order.ItemGroupRepository;

public class CreateOrderDto {
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

    public CreateOrderDto setCostumer(Costumer costumer) {
        this.costumer = costumer;
        return this;
    }

    public CreateOrderDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public CreateOrderDto setItemGroupRepository(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
        return this;
    }
}
