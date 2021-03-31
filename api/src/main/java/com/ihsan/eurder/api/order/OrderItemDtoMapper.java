package com.ihsan.eurder.api.order;

import com.ihsan.eurder.api.customer.CustomerDtoMapper;
import com.ihsan.eurder.api.item.ItemDtoMapper;
import com.ihsan.eurder.domain.customer.CustomerRepository;
import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.domain.order.ItemGroup;
import com.ihsan.eurder.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderItemDtoMapper {
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final ItemDtoMapper itemDtoMapper;
    private final CustomerDtoMapper customerDtoMapper;

    public OrderItemDtoMapper(ItemRepository itemRepository, CustomerRepository customerRepository, ItemDtoMapper itemDtoMapper, CustomerDtoMapper customerDtoMapper) {
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
        this.itemDtoMapper = itemDtoMapper;
        this.customerDtoMapper = customerDtoMapper;
    }

    public Order mapOrderItemDtoToOrder(OrderItemDto orderItemDto,String customerId) {
         return new Order(customerRepository.getCustomerMap().get(UUID.fromString(customerId)),
                 orderItemDto.getItemGroupDtos().stream().map(this::mapItemGroupDtoToItemGroup).collect(Collectors.toList()));

    }


    public ItemGroup mapItemGroupDtoToItemGroup(ItemGroupDto itemGroupDto) {
        return new ItemGroup(itemRepository.getItemById(UUID.fromString(itemGroupDto.getItemId())), itemGroupDto.getAmount());
    }


    public GetOrderedItemDto mapOrderToGetOrderedItemDto(Order order) {
        return new GetOrderedItemDto(customerDtoMapper.mapCustomerToCreateCustomerDto(order.getCustomer()),
                order.getOrders().stream().map(this::mapItemGroupToGetItemGroupDto).collect(Collectors.toList()),
                order.getTotalPrice());
    }


    public GetItemGroupDto mapItemGroupToGetItemGroupDto(ItemGroup itemGroup) {
        return new GetItemGroupDto(itemDtoMapper.mapItemToCreateItemDto(itemGroup.getItem()), itemGroup.getPrice(), itemGroup.getShippingDate());
    }


}
