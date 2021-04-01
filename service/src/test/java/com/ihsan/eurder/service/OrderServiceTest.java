package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.customer.Customer;
import com.ihsan.eurder.domain.item.Item;
import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.domain.order.ItemGroup;
import com.ihsan.eurder.domain.order.Order;
import com.ihsan.eurder.domain.order.OrderRepository;
import com.ihsan.eurder.infrastructure.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
     OrderRepository orderRepository = new OrderRepository();
     ItemRepository itemRepository = new ItemRepository();
     OrderService orderService = new OrderService(orderRepository,itemRepository);
     Customer customer;
     Item item;
     Item item2;
     ItemGroup itemGroup;
     ItemGroup itemGroup2;

    @BeforeEach
    void init() {
        customer = new Customer("Ihsan","Dinc","ihsan@gmail.com","Kumtich","04444444");
        item = new Item("Doritos","Nacho Chips",1.5,2);
        item2 = new Item("Lays","Nacho Chips",1.2,5);
        itemGroup = new ItemGroup(item,3);
        itemGroup2 = new ItemGroup(item2,4);
        itemRepository.addItemToRepository(item);
        itemRepository.addItemToRepository(item2);

    }

    @Test
    void givenAnOrder_whenAddingToService_thenOrderIsAdded() {
        List<ItemGroup> itemGroupList = new ArrayList<>(List.of(itemGroup,itemGroup2));
        Order order = new Order(customer,itemGroupList);
        orderService.orderItems(order);

        assertEquals(order,orderRepository.getOrderById(order.getOrderId()));
    }

    @Test
    void givenOrder_IfItemGroupNotFoundInItemRepo_ThrowItemNotFoundException() {
        Item item3 = new Item("Algida","Ice Cream",3,4);
        ItemGroup itemGroup3 = new ItemGroup(item3,3);
        List<ItemGroup> itemGroupList = new ArrayList<>(List.of(itemGroup,itemGroup2,itemGroup3));
        Order order = new Order(customer,itemGroupList);


        assertThrows(ItemNotFoundException.class,() -> orderService.orderItems(order));

    }

    @Test
    void givenOrder_afterOrderSubtractItemAmountFromItemRepository() {
        List<ItemGroup> itemGroupList = new ArrayList<>(List.of(itemGroup,itemGroup2));
        Order order = new Order(customer,itemGroupList);
        orderService.orderItems(order);

        assertEquals(0,itemRepository.getItemById(item.getItemId()).getAmount());
         assertEquals(1,itemRepository.getItemById(item2.getItemId()).getAmount());

    }




}