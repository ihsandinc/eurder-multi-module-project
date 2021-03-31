package com.ihsan.eurder.api.item;

import java.util.UUID;

public class GetItemDto {
    private UUID itemId;
    private String name;
    private String description;
    private double price;
    private int amount;

    public GetItemDto(UUID customerId, String name, String description, double price, int amount) {
        this.itemId = customerId;
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
