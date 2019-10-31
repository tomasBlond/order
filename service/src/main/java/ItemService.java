import item.Item;
import item.ItemRepository;

import java.nio.DoubleBuffer;
import java.util.List;

public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item){
        itemRepository.save(item);
        return item;
    }

    public List<Item> getAll(){
        return itemRepository.getAll();
    }
}
