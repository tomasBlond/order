package com.switchfully.order.api.order.orderDto;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.order.ItemGroupRepository;

public class CreateOrderDto {
    private String costumerId;
    private double price;
    private ItemGroupRepository itemGroupRepository;

    public String getCostumerId() {
        return costumerId;
    }

    public double getPrice() {
        return price;
    }

    public ItemGroupRepository getItemGroupRepository() {
        return itemGroupRepository;
    }

    public CreateOrderDto setCostumerId(String costumerId) {
        this.costumerId = costumerId;
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
