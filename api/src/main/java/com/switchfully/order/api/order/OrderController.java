package com.switchfully.order.api.order;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.order.orderDto.CreateOrderDto;
import com.switchfully.order.api.order.orderDto.OrderDto;
import com.switchfully.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private OrderService orderService;
    private DtoMapper dtoMapper;

    @Autowired
    public OrderController(OrderService orderService, DtoMapper dtoMapper) {
        this.orderService = orderService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public OrderDto placeOrder(@RequestBody CreateOrderDto createOrderDto){
        var order = dtoMapper.createOrderDtoToOrder(createOrderDto);
        orderService.placeOrder(order);
        return dtoMapper.orderToOrderDto(order);
    }
}
