package com.ihsan.eurder.api.order;

import java.util.List;

public class OrderItemDto {
    private final List<ItemGroupDto> itemGroupDtos;

    public OrderItemDto(List<ItemGroupDto> ordersDto) {
        this.itemGroupDtos = ordersDto;
    }

    public List<ItemGroupDto> getItemGroupDtos() {
        return itemGroupDtos;
    }
}
