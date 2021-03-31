package com.ihsan.eurder.api.item;

import com.ihsan.eurder.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoMapper {

    public Item mapCreateItemDtoToItem(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmount());
    }

    public CreateItemDto mapItemToCreateItemDto(Item item){
        return new CreateItemDto(item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
    }

}

