package com.switchfully.order.api.order.orderDto;

public class CreateItemGroupDto {
    private String itemId;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public CreateItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public CreateItemGroupDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

}
