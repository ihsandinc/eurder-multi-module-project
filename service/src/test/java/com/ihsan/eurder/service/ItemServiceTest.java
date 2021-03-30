package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.Item;
import com.ihsan.eurder.domain.ItemRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {
    ItemRepository itemRepository = new ItemRepository();
    ItemService itemService = new ItemService(itemRepository);


    @Test
    void givenAnItem_whenAddingToRepository_thenItemIsAdded() {
        Item item = new Item("Doritos","Nacho Chips",1.5,2);
        itemService.addItem(item);

        assertNotNull(itemRepository.getItemById(item.getItemId()));
        assertEquals(2,itemRepository.getItemById(item.getItemId()).getAmount());
    }
}