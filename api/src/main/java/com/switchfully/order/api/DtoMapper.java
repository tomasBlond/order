package com.switchfully.order.api;

import com.switchfully.order.api.costumer.dto.CostumerDto;
import com.switchfully.order.api.costumer.dto.CreateCostumerDto;
import com.switchfully.order.api.item.dto.CreateItemDto;
import com.switchfully.order.api.item.dto.ItemDto;
import com.switchfully.order.api.order.itemGroupDtos.CreateItemGroupDto;
import com.switchfully.order.api.order.itemGroupDtos.ItemGroupDto;
import com.switchfully.order.api.order.orderDto.CreateOrderDto;
import com.switchfully.order.api.order.orderDto.OrderDto;
import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    public CostumerDto costumerToDto(Costumer costumer){
        CostumerDto myDto = new CostumerDto();
        myDto.setId(costumer.getId());
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

    public ItemGroup createItemGroupDtoToItemGroup(CreateItemGroupDto createItemGroupDto) {
        return new ItemGroup(
                createItemGroupDto.getItem(),
                createItemGroupDto.getAmount());
    }

    public ItemGroupDto itemGroupToDto(ItemGroup itemGroup){
        ItemGroupDto myDto = new ItemGroupDto();
        myDto.setAmount(itemGroup.getAmount());
        myDto.setItem(itemGroup.getItem());
        myDto.setShippingDate(itemGroup.getShippingDate());
        myDto.setId(itemGroup.getId());
        return myDto;
    }

    public Order createOrderDtoToOrder(CreateOrderDto createOrderDto) {
        return new Order(
                createOrderDto.getCostumer()
        );
    }

    public OrderDto orderToOrderDto(Order order){
        OrderDto myDto = new OrderDto();
        myDto.setCostumer(order.getCostumer());
        myDto.setItemGroupRepository(order.getItemGroupRepository());
        myDto.setPrice(order.getPrice());
        return myDto;
    }
}
