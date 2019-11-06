package com.switchfully.order.api.order;

import com.switchfully.order.api.order.orderDto.OrderDto;
import com.switchfully.order.domain.order.Order;

import java.util.List;

public class OrderReportDto {
    private List<OrderDto> orderList;
    private double totalSpent;

    public OrderReportDto setOrderList(List<OrderDto> orderList) {
        this.orderList = orderList;
        return this;
    }
    public OrderReportDto setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
        return this;
    }

    public List<OrderDto> getOrderList() {
        return orderList;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
}
