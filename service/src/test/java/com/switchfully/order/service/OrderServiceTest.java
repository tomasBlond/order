package com.switchfully.order.service;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemRepository;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = {OrderService.class, OrderRepository.class, ItemRepository.class})
class OrderServiceTest {
    @Autowired private OrderService orderService;
    private Costumer costumer;
    private Item milk;
    private Item honing;
    private List<ItemGroup> items = new ArrayList<>();
    private Order myOrder;

    @BeforeEach
    void setup(){
        milk = new Item("milk", "milk is nice", 10, 5);
        honing = new Item("honing", "honing is cool", 20, 3);
        costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        items.add(new ItemGroup(milk.getItemId(), 3));
        items.add(new ItemGroup(honing.getItemId(), 5));
        orderService = new OrderService(new ItemRepository(), new OrderRepository());
        orderService.createItem(milk);
        orderService.createItem(honing);
        myOrder = new Order(costumer.getId(), items);
    }

    @Test
    void placeOrder_orderIsSavedInRepository(){
        orderService.placeOrder(myOrder);
        Assertions.assertTrue(orderService.getOrderRepository().getOrderRepository().containsValue(myOrder));
    }

    @Test
    void placeOrder_thenItemStockChangeWithAmountOrdered(){
        orderService.placeOrder(myOrder);
        Assertions.assertEquals(2, milk.getStockAmount());
        Assertions.assertEquals(-2, honing.getStockAmount());
        Assertions.assertNotEquals(1, milk.getStockAmount());
    }


    @Test
    void placeOrder_totalPriceIsCalculated(){
        Assertions.assertEquals(130, orderService.placeOrder(myOrder).getPrice());
    }


    @Test
    void placeOrder_whenStockIsBeggerThanOrderedAmount_thenDeliveryTimeIsNextDay(){
        orderService.placeOrder(myOrder);
        Assertions.assertEquals(LocalDate.now().plusDays(1), items.get(0).getShippingDate());
    }

    @Test
    void placeOrder_whenStockIsSmallerThanOrderedAmount_thenDeliveryTimeIsNextWeek(){
        orderService.placeOrder(myOrder);
        Assertions.assertEquals(LocalDate.now().plusDays(7), items.get(1).getShippingDate());
    }

    @Test
    void calculateTotalSpent_returnTotalSpentByCostumer(){
        Order myOrder2 = new Order(costumer.getId(), items);
        orderService.placeOrder(myOrder);
        orderService.placeOrder(myOrder2);
        Assertions.assertEquals(260,
                orderService.calculateTotalSpent(
                        orderService.getOrderRepository()
                                .getOrdersFromCostumer(costumer.getId())));
    }
}