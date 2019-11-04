package com.switchfully.order.domain.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String costumerId;
    private double price;
    private ItemGroupRepository itemGroupRepository;
    private List<ItemGroup> itemGroups = new ArrayList<>();

    public Order(String costumerId) {
        this.costumerId = costumerId;
        this.price = 0;
    }

    public ItemGroup saveOrderItem(ItemGroup itemGroup){
        itemGroups.add(itemGroup);
        return itemGroup;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public double calculateOrderPrice(){
        this.price = itemGroupRepository.getItemGroups().stream()
                .mapToDouble(ItemGroup::calculatePrice).sum();
        return price;
    }

    public String getCostumerId() {
        return costumerId;
    }

    public double getPrice() {
        return price;
    }

    public ItemGroupRepository getItemGroupRepository() {
        return itemGroupRepository;
    }
}
