package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.domain.order.ItemGroup;
import com.ihsan.eurder.domain.order.Order;
import com.ihsan.eurder.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
        int totalPriceOfOrder = 0;
      for (ItemGroup itemgroup:order.getOrders()
           ) {
          if (itemRepository.hasItemWithEnoughAmount(itemgroup.getItem().getItemId(), itemgroup.getAmount())) {
              itemgroup.setShippingDate(LocalDate.now().plusDays(1));
          }
          else {
              itemgroup.setShippingDate(LocalDate.now().plusDays(7));
          }
          totalPriceOfOrder += itemgroup.getPrice();
      }
      order.setTotalPrice(totalPriceOfOrder);
      orderRepository.addOrder(order);
      return order;
  }





}
