package com.switchfully.order.api.order.orderDto;

import java.util.List;

public class OrderDto {
    private String costumerId;
    private double totalOrderPrice;
    private List<ItemGroupDto> itemGroups;

    public OrderDto setCostumerId(String costumerId) {
        this.costumerId = costumerId;
        return this;
    }

    public OrderDto setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
        return this;
    }

    public OrderDto setItemGroups(List<ItemGroupDto> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public String getCostumerId() {
        return costumerId;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public List<ItemGroupDto> getItemGroups() {
        return itemGroups;
    }
}
