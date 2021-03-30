package com.ihsan.eurder.api.controllers;

import com.ihsan.eurder.api.CreateItemDto;
import com.ihsan.eurder.api.ItemDtoMapper;
import com.ihsan.eurder.service.AuthorizationService;
import com.ihsan.eurder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody CreateItemDto createItemDto,@RequestHeader(value = "Authorization", required = false) String id) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(id);
        itemService.addItem(itemDtoMapper.mapCreateItemDtoMapperToItem(createItemDto));
    }







}
