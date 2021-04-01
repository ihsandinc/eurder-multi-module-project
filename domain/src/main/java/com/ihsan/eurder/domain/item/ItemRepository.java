package com.ihsan.eurder.domain.item;

import com.ihsan.eurder.domain.item.Item;
import com.ihsan.eurder.infrastructure.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Item> getItemsAsList() {
        return new ArrayList<>(itemStock.values());
    }

    public void subtractItemAfterOrder(UUID itemId,int amount) {
        Item itemAfterOrder = itemStock.get(itemId);
        itemAfterOrder.setAmount(itemAfterOrder.getAmount() - amount);
        itemStock.put(itemId,itemAfterOrder);
    }

    public void updateItem(UUID id, Item newItem) {
        if (!hasItem(id)) {
            throw new ItemNotFoundException();
        }
        else {
            itemStock.remove(id);
            itemStock.put(newItem.getItemId(),newItem);
        }
    }
}
