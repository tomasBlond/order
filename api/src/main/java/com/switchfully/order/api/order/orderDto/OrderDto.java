package com.switchfully.order.api.order.orderDto;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.order.ItemGroupRepository;

public class OrderDto {
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

    public OrderDto setCostumerId(String costumerId) {
        this.costumerId = costumerId;
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
