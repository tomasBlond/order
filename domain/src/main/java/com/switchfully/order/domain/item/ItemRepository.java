package com.switchfully.order.domain.item;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ItemRepository {
    private List<Item> itemRepository = new ArrayList<>();

    public void save(Item item) {
        if (isIn(item)){
            throw new IllegalArgumentException("Item is already in");
        } else {
           itemRepository.add(item);
        }
    }

    public Item getItemById(String itemId) {
        return itemRepository.stream().filter(item -> item.getItemId().equals(itemId)).findFirst().get();
    }

    private boolean isIn(Item item) {
        return itemRepository.contains(item);
    }

    public List<Item> getAll(){
        return itemRepository;
    }

}
