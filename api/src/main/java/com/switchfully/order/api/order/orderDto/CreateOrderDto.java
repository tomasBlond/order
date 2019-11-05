package com.switchfully.order.api.order.orderDto;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderDto {
    private String costumerId;
    private List<CreateItemGroupDto> createItemGroups = new ArrayList<>();

    public String getCostumerId() {
        return costumerId;
    }

    public List<CreateItemGroupDto> getCreateItemGroups() {
        return createItemGroups;
    }


}
