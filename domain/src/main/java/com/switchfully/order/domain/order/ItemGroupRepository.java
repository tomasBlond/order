package com.switchfully.order.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ItemGroupRepository {
    private List<ItemGroup> itemGroups = new ArrayList<>();

    public ItemGroup saveOrderItem(ItemGroup itemGroup){
        itemGroups.add(itemGroup);
        return itemGroup;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
