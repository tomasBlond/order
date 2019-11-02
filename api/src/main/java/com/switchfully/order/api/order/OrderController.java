package com.switchfully.order.api.order;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.domain.order.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private Order orders;
    private DtoMapper dtoMapper;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ItemGroupDto addItemGroupToOrder(@RequestBody CreateItemGroupDto itemGroup){
        //TODO
        return null;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public OrderDto placeOrder(@RequestBody Order order){

        //TODO
        return null;
    }
}
