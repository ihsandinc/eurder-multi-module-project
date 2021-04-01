package com.ihsan.eurder.domain.item;

import com.ihsan.eurder.infrastructure.ValidationUtil;

import java.util.Objects;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name);
    }
}
