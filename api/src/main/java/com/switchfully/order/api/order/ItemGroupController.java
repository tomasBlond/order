package com.switchfully.order.api.order;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.order.itemGroupDtos.CreateItemGroupDto;
import com.switchfully.order.api.order.itemGroupDtos.ItemGroupDto;
import com.switchfully.order.domain.order.ItemGroupRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/itemGroups")
public class ItemGroupController {
    private ItemGroupRepository itemGroupRepository;
    private DtoMapper dtoMapper;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ItemGroupDto addItemGroupToOrder(@RequestBody CreateItemGroupDto createItemGroupDto){
        var itemGroup = dtoMapper.createItemGroupDtoToItemGroup(createItemGroupDto);
        itemGroupRepository.saveOrderItem(itemGroup);
        return dtoMapper.itemGroupToDto(itemGroup);
    }
}
