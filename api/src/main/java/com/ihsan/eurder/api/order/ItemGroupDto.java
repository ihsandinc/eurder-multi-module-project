package com.ihsan.eurder.api.order;

public class ItemGroupDto {
    private String itemId;
    private int amount;

    public ItemGroupDto(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
