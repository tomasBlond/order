package com.switchfully.order.domain.item;

public class Item {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int stockAmount;
    private StockIndicator stockIndicator;

    public Item(String name, String description, double price, int stockAmount) {
        this.itemId = name;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
        this.stockIndicator = defineStockIndicator(stockAmount);
    }

    private StockIndicator defineStockIndicator(int stockAmount){
        if (stockAmount < 5){
            return StockIndicator.STOCK_LOW;
        }
        if (stockAmount < 10){
            return StockIndicator.STOCK_MEDIUM;
        }
        return StockIndicator.STOCK_HIGH;
    }

    public StockIndicator getStockIndicator() {
        return stockIndicator;
    }

    public void setStockIndicator(StockIndicator stockIndicator) {
        this.stockIndicator = stockIndicator;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
