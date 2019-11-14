package com.switchfully.order.api.item.dto;

import com.switchfully.order.domain.item.StockIndicator;

public class ItemStockIndicatorDto {
    private String itemId;
    private String name;
    private int stockAmount;
    private StockIndicator stockIndicator;

    public StockIndicator getStockIndicator() {
        return stockIndicator;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public ItemStockIndicatorDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemStockIndicatorDto setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
        return this;
    }

    public ItemStockIndicatorDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemStockIndicatorDto setStockIndicator(StockIndicator stockIndicator) {
        this.stockIndicator = stockIndicator;
        return this;
    }
}
