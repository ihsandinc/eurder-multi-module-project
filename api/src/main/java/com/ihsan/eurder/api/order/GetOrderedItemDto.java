package com.ihsan.eurder.api.order;

import com.ihsan.eurder.api.customer.CreateCustomerDto;
import com.ihsan.eurder.api.item.CreateItemDto;
import com.ihsan.eurder.infrastructure.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class GetOrderedItemDto {
    private final CreateCustomerDto customerDto;
    private final List<GetItemGroupDto> orders;
    private final double totalPrice;

    public GetOrderedItemDto(CreateCustomerDto customerDto, List<GetItemGroupDto> orders, double totalPrice) {
        this.customerDto = customerDto;
        this.orders = orders;
        this.totalPrice = totalPrice;
    }

    public void addOrder(GetItemGroupDto getItemGroupDto) {
        orders.add(getItemGroupDto);
    }

    public CreateCustomerDto getCustomerDto() {
        return customerDto;
    }

    public List<GetItemGroupDto> getOrders() {
        return orders;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
