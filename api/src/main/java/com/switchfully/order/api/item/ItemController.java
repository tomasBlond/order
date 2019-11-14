package com.switchfully.order.api.item;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.item.dto.CreateItemDto;
import com.switchfully.order.api.item.dto.ItemDto;
import com.switchfully.order.api.item.dto.ItemStockIndicatorDto;
import com.switchfully.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    private OrderService orderService;
    private DtoMapper dtoMapper;

    @Autowired
    public ItemController(OrderService itemService, DtoMapper dtoMapper) {
        this.orderService = itemService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto createItemDto){
        var item = dtoMapper.createItemDtoToItem(createItemDto);
        orderService.createItem(item);
        return  dtoMapper.itemToDto(item);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemStockIndicatorDto> getItemsStockReport(@RequestParam (value = "stockIndicator", required = false) String stockIndicator){
        return orderService.getItemsStockReport(stockIndicator)
                .stream().map(item -> dtoMapper.itemToItemStockIndicatorDto(item))
                .sorted(Comparator.comparingInt(ItemStockIndicatorDto::getStockAmount))
                .collect(Collectors.toList());
    }
}
