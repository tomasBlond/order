package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemRepository;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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

    public List<Item> getAll(){
        return itemRepository.getAll();
    }

    public double calculatePrice(String itemId, int amount){
        return itemRepository.getItemById(itemId).getPrice() * amount;
    }
    public LocalDate setDate(String itemId, int amount){
        LocalDate shippingDate;
        if (itemRepository.getItemById(itemId).getStockAmount() > amount){
            shippingDate = LocalDate.now().plusDays(1);
        } else {
            shippingDate = LocalDate.now().plusDays(7);
        }
        return shippingDate;
    }

    public Order placeOrder(Order order){
        setItemGroupsPrice(order);
        setItemGroupsDeliveryDate(order);
        order.setPrice(order.getItemGroups().stream().mapToDouble(ItemGroup::getPrice).sum());
        orderRepository.placeOrder(order);
        return order;
    }

    private void setItemGroupsDeliveryDate(Order order) {
        order.getItemGroups()
                .forEach(itemGroup -> itemGroup.setShippingDate
                        (setDate(itemGroup.getItemId(), itemGroup.getAmount())) );
    }

    private void setItemGroupsPrice(Order order) {
        order.getItemGroups()
                .forEach(itemGroup -> itemGroup.setPrice(
                        calculatePrice(itemGroup.getItemId(), itemGroup.getAmount())));
    }
}
