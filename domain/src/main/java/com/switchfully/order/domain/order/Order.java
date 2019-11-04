package com.switchfully.order.domain.order;

public class Order {
    private String costumerId;
    private double price;
    private ItemGroupRepository itemGroupRepository;

    public Order(String costumerId) {
        this.costumerId = costumerId;
        this.price = itemGroupRepository.getItemGroups().stream()
                .mapToDouble(ItemGroup::calculatePrice).sum();
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
