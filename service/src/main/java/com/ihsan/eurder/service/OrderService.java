package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.domain.order.ItemGroup;
import com.ihsan.eurder.domain.order.Order;
import com.ihsan.eurder.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

  public Order orderItems(Order order) {
        double totalPriceOfOrder = 0;
      for (ItemGroup itemgroup:order.getOrders()
           ) {
          UUID itemId = itemgroup.getItem().getItemId();
          int amountOfOrder = itemgroup.getAmount();
          if (itemRepository.hasItemWithEnoughAmount(itemId, amountOfOrder)) {
              itemgroup.setShippingDate(LocalDate.now().plusDays(1));
              itemRepository.subtractItemAfterOrder(itemId, amountOfOrder);
          }
          else {
              itemgroup.setShippingDate(LocalDate.now().plusDays(7));
              itemRepository.subtractItemAfterOrder(itemId, itemRepository.getItemById(itemId).getAmount());
          }
          totalPriceOfOrder += itemgroup.getPrice();
      }
      order.setTotalPrice(totalPriceOfOrder);
      orderRepository.addOrder(order);
      return order;
  }





}
