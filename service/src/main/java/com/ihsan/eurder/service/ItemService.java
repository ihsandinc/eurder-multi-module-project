package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.item.Item;
import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.domain.item.ItemStockOverview;
import com.ihsan.eurder.domain.item.StockUrgencyIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Item> getItems() {
      return itemRepository.getItemsAsList();
    }

    public List<ItemStockOverview> getStockOverview() {
        return itemRepository.getItemsAsList().stream().map(ItemStockOverview::new).sorted().collect(Collectors.toList());
    }

    public List<ItemStockOverview> getUrgentStockOverview() {
        return itemRepository.getItemsAsList().stream().map(ItemStockOverview::new).
                filter(itemStockOverview -> itemStockOverview.getStockUrgency().equals(StockUrgencyIndicator.STOCK_LOW)).collect(Collectors.toList());
    }
}
