package com.switchfully.order.api.order;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.order.orderDto.CreateOrderDto;
import com.switchfully.order.api.order.orderDto.OrderDto;
import com.switchfully.order.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private Order orders;
    private DtoMapper dtoMapper;

    @Autowired
    public OrderController(Order orders, DtoMapper dtoMapper) {
        this.orders = orders;
        this.dtoMapper = dtoMapper;
    }

    //version 1: itemGroups primero y despues anadirlos a una orden

    @PostMapping(consumes = "application/json", produces = "application/json")
    public OrderDto placeOrder(@RequestBody CreateOrderDto createOrderDto){
        var order = dtoMapper.createOrderDtoToOrder(createOrderDto);
        order.calculateOrderPrice();
        return dtoMapper.orderToOrderDto(order);
    }
}
