package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.item.Item;
import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.infrastructure.exceptions.CustomerNotFoundException;
import com.ihsan.eurder.infrastructure.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {
    ItemRepository itemRepository = new ItemRepository();
    ItemService itemService = new ItemService(itemRepository);
    Item item;
    Item item2;


    @BeforeEach
    void init() {
        item = new Item("Doritos","Nacho Chips",1.5,2);
        item2 = new Item("Lays","Nacho Chips",1.2,5);
    }

    @Test
    void givenAnItem_whenAddingToService_thenItemIsAdded() {
        itemService.addItem(item);

        assertNotNull(itemRepository.getItemById(item.getItemId()));
        assertEquals(2,itemRepository.getItemById(item.getItemId()).getAmount());
    }

    @Test
    void givenCustomerId_IfItsNotFound_ThanThrowCustomerNotFoundException() {
        assertThrows(ItemNotFoundException.class,() -> itemRepository.getItemById(UUID.fromString("123e4567-e89b-12d3-a456-556642449600")));
    }

    @Test
    void getAllItemsFromRepository() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);

        itemService.addItem(item);
        itemService.addItem(item2);

        assertEquals(itemService.getItems(),itemList);


    }

}