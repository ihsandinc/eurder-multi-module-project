package com.ihsan.eurder.domain.item;

import com.ihsan.eurder.infrastructure.ValidationUtil;

import java.util.UUID;

public class Item {

    private UUID itemId;
    private String name;
    private String description;
    private double price;
    private int amount;


    public Item(String name, String description, double price, int amount) {
        itemId = UUID.randomUUID();
        ValidationUtil.throwExceptionIfNull(name,"Name");
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
