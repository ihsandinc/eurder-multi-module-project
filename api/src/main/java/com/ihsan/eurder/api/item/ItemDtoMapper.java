package com.ihsan.eurder.api.item;

import com.ihsan.eurder.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemDtoMapper {

    public Item mapCreateItemDtoToItem(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmount());
    }

    public CreateItemDto mapItemToCreateItemDto(Item item){
        return new CreateItemDto(item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
    }

    public GetItemDto mapItemToGetItemDto(Item item) {
        return new GetItemDto(item.getItemId(), item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
    }

    public List<CreateItemDto> mapItemListToCreateItemDtoList(List<Item> itemList) {
        return itemList.stream().map(this::mapItemToCreateItemDto).collect(Collectors.toList());
    }

    public List<GetItemDto> mapItemListToGetItemDtoList(List<Item> itemList) {
        return itemList.stream().map(this::mapItemToGetItemDto).collect(Collectors.toList());
    }

    public Item mapUpdateItemDtoToItem(UpdateItemDto updateitemDto) {
        return new Item(updateitemDto.getName(), updateitemDto.getDescription(), updateitemDto.getPrice(), updateitemDto.getAmount());
    }

}

