package com.switchfully.order.api.order;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.order.orderDto.CreateOrderDto;
import com.switchfully.order.api.order.orderDto.OrderDto;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto placeOrder(@RequestBody CreateOrderDto createOrderDto){
        var order = dtoMapper.createOrderDtoToOrder(createOrderDto);
        orderService.placeOrder(order);
        return dtoMapper.orderToOrderDto(order);
    }

    @GetMapping(path = "/{costumerId}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public OrderReportDto getReport(@PathVariable String costumerId){
        var orderList = orderService.getReport(costumerId);
        double totalSpent = orderService.calculateTotalSpent(orderList);
        return dtoMapper.orderReportToDto(orderList, totalSpent);
    }

}
