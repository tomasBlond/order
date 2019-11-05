package com.switchfully.order.domain.order;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.item.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class OrderRepositoryTest {
    private OrderRepository orderRepository = new OrderRepository();

    @Test
    void getOrdersFromCostumers_whenCostumerExist_allOrdersFromCostumerAreReturned(){
        Item milk = new Item("milk", "milk is nice", 10, 5);
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        List<ItemGroup> items = new ArrayList<>();
        items.add(new ItemGroup(milk.getItemId(), 3));
        Order myOrder1 = new Order(costumer.getId(), items);
        Order myOrder2 = new Order(costumer.getId(), items);
        orderRepository.placeOrder(myOrder1);
        orderRepository.placeOrder(myOrder2);

        List<Order> dummyOrderList = Arrays.asList(myOrder1,myOrder2);
        Assertions.assertTrue(orderRepository.getOrdersFromCostumer(costumer.getId()).containsAll(dummyOrderList));
    }


    @Test
    void getOrdersFromCostumer_whenNoOrders_throwException(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        List<ItemGroup> items = new ArrayList<>();
        Order myOrder1 = new Order(costumer.getId(), items);

        Assertions.assertThrows(IllegalArgumentException.class, ()-> orderRepository.getOrdersFromCostumer(costumer.getId()));
    }
}