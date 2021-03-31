package com.ihsan.eurder.domain.order;

import com.ihsan.eurder.domain.item.Item;

import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private int amount;
    private double price;
    private LocalDate shippingDate;


    public ItemGroup(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.price = item.getPrice()*amount;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
