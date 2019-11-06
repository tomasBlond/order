package com.switchfully.order.domain.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemRepositoryTest {
    private ItemRepository itemRepository = new ItemRepository();

    @Test
    void createItem_itemIsSavedInRepository(){
        Item milk = new Item("milk", "milk is nice", 10, 5);
        Item honing = new Item("honing", "honing is cool", 20, 3);
        itemRepository.save(milk);

        Assertions.assertTrue(itemRepository.getAll().contains(milk));
        Assertions.assertFalse(itemRepository.getAll().contains(honing));
    }

    @Test
    void createItem_whenItemAlreadyExists_throwException(){
        Item milk = new Item("milk", "milk is nice", 10, 5);
        itemRepository.save(milk);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemRepository.save(milk));
    }

    @Test
    void getItemById_whenItemIsInRepository_ReturnItem(){
        Item milk = new Item("milk", "milk is nice", 10, 5);
        Item honing = new Item("honing", "honing is cool", 20, 3);
        itemRepository.save(milk);
        itemRepository.save(honing);

        Assertions.assertEquals(milk, itemRepository.getItemById("milk"));
        Assertions.assertEquals(honing, itemRepository.getItemById("honing"));
    }

}