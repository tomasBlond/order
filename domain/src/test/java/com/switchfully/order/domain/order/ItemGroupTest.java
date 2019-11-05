package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemGroupTest {

    @Test
    void createItemGroup_whenAmountIsZero_then_throwException(){
        Item milk = new Item("milk", "milk is nice", 10, 5);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new ItemGroup(milk.getItemId(), 0));
    }
}