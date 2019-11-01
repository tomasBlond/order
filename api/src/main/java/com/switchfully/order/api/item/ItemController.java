package com.switchfully.order.api.item;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.item.dto.CreateItemDto;
import com.switchfully.order.api.item.dto.ItemDto;
import com.switchfully.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private ItemService itemService;
    private DtoMapper dtoMapper;

    @Autowired
    public ItemController(ItemService itemService, DtoMapper dtoMapper) {
        this.itemService = itemService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto createItemDto){
        var item = dtoMapper.createItemDtoToItem(createItemDto);
        itemService.createItem(item);
        return  dtoMapper.itemToDto(item);
    }
}
