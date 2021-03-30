package com.ihsan.eurder.api;

import com.ihsan.eurder.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoMapper {

    public Item mapCreateItemDtoMapperToItem(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmount());
    }


}

