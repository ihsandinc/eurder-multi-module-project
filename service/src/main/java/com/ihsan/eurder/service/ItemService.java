package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.item.Item;
import com.ihsan.eurder.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item itemToAdd) {
        itemRepository.addItemToRepository(itemToAdd);
    }
}
