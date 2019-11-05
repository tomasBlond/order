package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemRepository;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

    public void setStockAmount(String itemId, int amount){
        itemRepository.getItemById(itemId)
                .setStockAmount(itemRepository.getItemById(itemId).getStockAmount() - amount);
    }

    public void changeStockAfterOrder(Order order){
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

    public double calculatePrice(String itemId, int amount){
        return itemRepository.getItemById(itemId).getPrice() * amount;
    }

    public LocalDate setDate(String itemId, int amount){
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

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public OrderReport getReport(String costumerId) {
    }
}
