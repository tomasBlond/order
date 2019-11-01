package com.switchfully.order.api;

import com.switchfully.order.api.costumer.dto.CostumerDto;
import com.switchfully.order.api.costumer.dto.CreateCostumerDto;
import com.switchfully.order.api.item.dto.CreateItemDto;
import com.switchfully.order.api.item.dto.ItemDto;
import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    public CostumerDto costumerToDto(Costumer costumer){
        CostumerDto myDto = new CostumerDto();
        myDto.setAddress(costumer.getAddress());
        myDto.setEmail(costumer.getEmail());
        myDto.setFirstName(costumer.getFirstName());
        myDto.setLastName(costumer.getLastName());
        myDto.setPhoneNumber(costumer.getPhoneNumber());
        return myDto;
    }

    public Costumer createCostumerDtoToCostumer(CreateCostumerDto createCostumerDto){
        return new Costumer(
                createCostumerDto.getFirstName(),
                createCostumerDto.getLastName(),
                createCostumerDto.getEmail(),
                createCostumerDto.getAddress(),
                createCostumerDto.getPhoneNumber());
    }

    public Item createItemDtoToItem(CreateItemDto createItemDto) {
        return new Item(
                createItemDto.getName(),
                createItemDto.getDescription(),
                createItemDto.getPrice(),
                createItemDto.getStockAmount());
    }

    public ItemDto itemToDto(Item item){
        ItemDto myDto = new ItemDto();
        myDto.setName(item.getName());
        myDto.setDescription(item.getDescription());
        myDto.setPrice(item.getPrice());
        myDto.setStockAmount(item.getStockAmount());
        return myDto;
    }
}
