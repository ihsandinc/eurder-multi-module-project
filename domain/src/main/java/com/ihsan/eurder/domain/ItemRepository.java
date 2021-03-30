package com.ihsan.eurder.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class ItemRepository {
    private final HashMap<UUID,Item> itemStock;


    public ItemRepository() {
        itemStock = new HashMap<>();
    }

    public void addItemToRepository(Item itemToAdd) {
        itemStock.put(itemToAdd.getItemId(),itemToAdd);
    }

    public Item getItemById(UUID id) {
        return itemStock.get(id);
    }

}
