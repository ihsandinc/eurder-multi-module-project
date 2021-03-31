package com.ihsan.eurder.domain.item;

import com.ihsan.eurder.domain.item.Item;
import com.ihsan.eurder.infrastructure.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class ItemRepository {
    private final HashMap<UUID, Item> itemStock;


    public ItemRepository() {
        itemStock = new HashMap<>();
    }

    public void addItemToRepository(Item itemToAdd) {
        itemStock.put(itemToAdd.getItemId(),itemToAdd);
    }

    public Item getItemById(UUID itemId) {
        if (!hasItem(itemId)) {
            throw new ItemNotFoundException();
        }
        else
            return itemStock.get(itemId);

    }

    public boolean hasItem(UUID itemId) {
        return itemStock.get(itemId) != null;
    }

    public boolean hasItemWithEnoughAmount(UUID itemId,int orderAmount) {
        return hasItem(itemId) && getItemById(itemId).getAmount() >= orderAmount;
    }

}
