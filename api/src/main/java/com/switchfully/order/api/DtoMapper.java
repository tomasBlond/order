package com.switchfully.order.api;

import com.switchfully.order.api.costumer.dto.CostumerDto;
import com.switchfully.order.api.costumer.dto.CreateCostumerDto;
import com.switchfully.order.api.item.dto.CreateItemDto;
import com.switchfully.order.api.item.dto.ItemDto;
import com.switchfully.order.api.item.dto.ItemStockIndicatorDto;
import com.switchfully.order.api.order.OrderReportDto;
import com.switchfully.order.api.order.orderDto.CreateItemGroupDto;
import com.switchfully.order.api.order.orderDto.ItemGroupDto;
import com.switchfully.order.api.order.orderDto.CreateOrderDto;
import com.switchfully.order.api.order.orderDto.OrderDto;
import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    public CostumerDto costumerToDto(Costumer costumer) {
        return new CostumerDto().setId(costumer.getId())
                .setAddress(costumer.getAddress())
                .setEmail(costumer.getEmail())
                .setFirstName(costumer.getFirstName())
                .setLastName(costumer.getLastName())
                .setPhoneNumber(costumer.getPhoneNumber());
    }

    public Costumer createCostumerDtoToCostumer(CreateCostumerDto createCostumerDto) {
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

    public ItemDto itemToDto(Item item) {
        return new ItemDto()
                .setItemId(item.getItemId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setStockAmount(item.getStockAmount());
    }

    public ItemStockIndicatorDto itemToItemStockIndicatorDto(Item item){
        return new ItemStockIndicatorDto()
                .setItemId(item.getItemId())
                .setName(item.getName())
                .setStockAmount(item.getStockAmount())
                .setStockIndicator(item.getStockIndicator());
    }

    public ItemGroup createItemGroupDtoToItemGroup(CreateItemGroupDto createItemGroupDto) {
        return new ItemGroup(
                createItemGroupDto.getItemId(),
                createItemGroupDto.getAmount());
    }

    public ItemGroupDto itemGroupToDto(ItemGroup itemGroup) {
        return new ItemGroupDto()
                .setAmount(itemGroup.getAmount())
                .setShippingDate(itemGroup.getShippingDate())
                .setId(itemGroup.getItemId())
                .setPrice(itemGroup.getPrice())
                .setUnitPrice(itemGroup.getPrice()/itemGroup.getAmount());
    }

    public Order createOrderDtoToOrder(CreateOrderDto createOrderDto) {
        return new Order(
                createOrderDto.getCostumerId(),
                createOrderDto.getCreateItemGroups()
                        .stream().map(this::createItemGroupDtoToItemGroup).collect(Collectors.toList()));
    }

    public OrderDto orderToOrderDto(Order order) {
        return new OrderDto()
        .setCostumerId(order.getCostumerId())
                .setTotalOrderPrice(order.getPrice())
                .setItemGroups(order.getItemGroups()
                        .stream().map(this::itemGroupToDto).collect(Collectors.toList()));
    }

    public OrderReportDto orderReportToDto(List<Order> orderList, double totalSpent) {
        return new OrderReportDto()
                .setTotalSpent(totalSpent)
                .setOrderList(orderList.stream()
                        .map(this::orderToOrderDto)
                        .collect(Collectors.toList()));
    }

}
