package com.switchfully.order.api.order.orderDto;

public class CreateItemGroupDto {
    private String itemId;
    private int amount;


    public CreateItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
    public CreateItemGroupDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getItemId() {
        return itemId;
    }
    public int getAmount() {
        return amount;
    }

}
