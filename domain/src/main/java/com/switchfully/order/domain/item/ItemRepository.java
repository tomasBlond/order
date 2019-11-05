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
        }
        itemRepository.add(item);
    }

    public Item getItemById(String itemId) {
        if (itemIsIn(itemId)){
            return itemRepository.stream().filter(item -> item.getItemId().equals(itemId)).findFirst().get();
        }
        throw new IllegalArgumentException("Item with id " + itemId + " not found");
    }

    private boolean itemIsIn(String itemId) {
        return itemRepository.stream().anyMatch(item -> item.getItemId().equals(itemId));
    }

    private boolean isIn(Item item) {
        return itemRepository.contains(item);
    }

    public List<Item> getAll(){
        return itemRepository;
    }

}
