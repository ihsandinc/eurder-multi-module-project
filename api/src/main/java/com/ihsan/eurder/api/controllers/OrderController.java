package com.ihsan.eurder.api.controllers;


import com.ihsan.eurder.api.order.*;
import com.ihsan.eurder.service.AuthorizationService;
import com.ihsan.eurder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderItemDtoMapper orderItemDtoMapper;
    private final AuthorizationService authorizationService;

    @Autowired
    public OrderController(OrderService orderService, OrderItemDtoMapper orderItemDtoMapper, AuthorizationService authorizationService) {
        this.orderService = orderService;
        this.orderItemDtoMapper = orderItemDtoMapper;
        this.authorizationService = authorizationService;
    }

    @GetMapping(path = "/today" , produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemShippingTodayDto> getItemGroupsShippingToday(@RequestHeader(value = "Authorization", required = false) String adminId) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(adminId);
        return orderItemDtoMapper.mapItemGroupShippingTodayListToItemShippingTodayDtoList(orderService.getItemGroupsShippingToday());
    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public GetOrderedItemDto orderItem(@RequestHeader(value = "Authorization", required = false) String customerId, @RequestBody OrderItemDto orderItemDto) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotCustomer(customerId);
       return orderItemDtoMapper.mapOrderToGetOrderedItemDto(orderService.orderItems(orderItemDtoMapper.mapOrderItemDtoToOrder(orderItemDto,customerId)));
    }


}
