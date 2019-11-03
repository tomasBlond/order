package com.switchfully.order.service;

import com.switchfully.order.domain.order.ItemGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupService {
    private ItemGroupRepository itemGroupRepository;

    @Autowired
    public ItemGroupService(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
    }
}
