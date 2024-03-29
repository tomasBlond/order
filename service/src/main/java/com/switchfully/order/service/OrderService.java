package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemRepository;
import com.switchfully.order.domain.item.StockIndicator;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderService {
    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public Item createItem(Item item){
        itemRepository.save(item);
        return item;
    }

    public Order placeOrder(Order order){
        setItemGroupsPrice(order);
        setItemGroupsDeliveryDate(order);
        order.setPrice(order.getItemGroups().stream().mapToDouble(ItemGroup::getPrice).sum());
        orderRepository.placeOrder(order);
        changeStockAfterOrder(order);
        return order;
    }

    private void setStockAmount(String itemId, int amount){
        itemRepository.getItemById(itemId)
                .setStockAmount(itemRepository.getItemById(itemId).getStockAmount() - amount);
    }

    private void changeStockAfterOrder(Order order){
        order.getItemGroups().forEach(itemGroup -> setStockAmount(itemGroup.getItemId(), itemGroup.getAmount()));
    }

    private void setItemGroupsDeliveryDate(Order order) {
        order.getItemGroups()
                .forEach(itemGroup -> itemGroup.setShippingDate
                        (setDate(itemGroup.getItemId(), itemGroup.getAmount())));
    }

    private void setItemGroupsPrice(Order order) {
        order.getItemGroups()
                .forEach(itemGroup -> itemGroup.setPrice(
                        calculatePrice(itemGroup.getItemId(), itemGroup.getAmount())));
    }

    private double calculatePrice(String itemId, int amount){
        return itemRepository.getItemById(itemId).getPrice() * amount;
    }

    private LocalDate setDate(String itemId, int amount){
        LocalDate shippingDate;
        int shippingDaysIfInStock = 1;
        int shippingDaysIfNOTInStock = 7;
        if (itemRepository.getItemById(itemId).getStockAmount() > amount){
            shippingDate = LocalDate.now().plusDays(shippingDaysIfInStock);
        } else {
            shippingDate = LocalDate.now().plusDays(shippingDaysIfNOTInStock);
        }
        return shippingDate;
    }
    public double calculateTotalSpent(List<Order> orderList) {
        return orderList.stream().mapToDouble(Order::getPrice).sum();
    }

    public List<Order> getReport(String costumerId) {
        return orderRepository.getOrdersFromCostumer(costumerId);
    }
    OrderRepository getOrderRepository() {
        return orderRepository;
    }
    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public List<Item> getItemsStockReport(String stockIndicator) {
        List<Item> allItems = getItemRepository().getAll();
        if (stockIndicator != null && !stockIndicator.isEmpty()){
            return allItems = getItemsByStockIndicator(allItems, stockIndicator);
        }
        return allItems;
    }

    private List<Item> getItemsByStockIndicator(List<Item> allItems, String stockIndicator) {
        if (stockIndicator.toUpperCase().equals(StockIndicator.STOCK_HIGH.toString()) ||
                stockIndicator.toUpperCase().equals(StockIndicator.STOCK_MEDIUM.toString()) ||
                stockIndicator.toUpperCase().equals(StockIndicator.STOCK_LOW.toString())){
            return allItems.stream()
                    .filter(item -> item.getStockIndicator().name().equals(stockIndicator))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("couldn't find items with this stock indicator");
    }
}
