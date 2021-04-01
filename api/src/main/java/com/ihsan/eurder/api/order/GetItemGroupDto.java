package com.ihsan.eurder.api.order;

import com.ihsan.eurder.api.item.CreateItemDto;
import com.ihsan.eurder.domain.item.Item;

import java.time.LocalDate;

public class GetItemGroupDto {
    private CreateItemDto item;
    private double price;
    private LocalDate shippingDate;

    public GetItemGroupDto(CreateItemDto item, double price, LocalDate shippingDate) {
        this.item = item;
        this.price = price;
        this.shippingDate = shippingDate;
    }

    public CreateItemDto getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }




}
