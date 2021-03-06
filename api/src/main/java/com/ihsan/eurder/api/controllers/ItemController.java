package com.ihsan.eurder.api.controllers;

import com.ihsan.eurder.api.item.CreateItemDto;
import com.ihsan.eurder.api.item.GetItemDto;
import com.ihsan.eurder.api.item.ItemDtoMapper;
import com.ihsan.eurder.api.item.UpdateItemDto;
import com.ihsan.eurder.domain.item.ItemStockOverview;
import com.ihsan.eurder.service.AuthorizationService;
import com.ihsan.eurder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemDtoMapper itemDtoMapper;
    private final AuthorizationService authorizationService;

    @Autowired
    public ItemController(ItemService itemService, ItemDtoMapper itemDtoMapper, AuthorizationService authorizationService) {
        this.itemService = itemService;
        this.itemDtoMapper = itemDtoMapper;
        this.authorizationService = authorizationService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<GetItemDto> getItems() {
        return itemDtoMapper.mapItemListToGetItemDtoList(itemService.getItems());
    }

    @GetMapping(path = "/stockoverview",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemStockOverview> getStockOverview(@RequestHeader(value = "Authorization", required = false) String adminId) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(adminId);
        return itemService.getStockOverview();
    }

    @GetMapping(path = "/stockoverview/urgent",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemStockOverview> getUrgentStockOverview(@RequestHeader(value = "Authorization", required = false) String adminId) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(adminId);
        return itemService.getUrgentStockOverview();
    }


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody CreateItemDto createItemDto,@RequestHeader(value = "Authorization", required = false) String adminId) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(adminId);
        itemService.addItem(itemDtoMapper.mapCreateItemDtoToItem(createItemDto));
    }

    @PutMapping(path = "/{id}" , consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody UpdateItemDto updateItemDto, @PathVariable UUID id, @RequestHeader (value = "Authorization", required = false) String adminId) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(adminId);
        itemService.updateItem(id,itemDtoMapper.mapUpdateItemDtoToItem(updateItemDto));
    }







}
