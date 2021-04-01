package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.item.ItemRepository;
import com.ihsan.eurder.domain.order.ItemGroup;
import com.ihsan.eurder.domain.order.ItemGroupShippingToday;
import com.ihsan.eurder.domain.order.Order;
import com.ihsan.eurder.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
              subtractItemAmountFromRepo(itemId, amountOfOrder);
          }
          else {
              itemgroup.setShippingDate(LocalDate.now().plusDays(7));
              subtractItemAmountFromRepo(itemId, itemRepository.getItemById(itemId).getAmount());
          }
          totalPriceOfOrder += itemgroup.getPrice();
      }
      order.setTotalPrice(totalPriceOfOrder);
      orderRepository.addOrder(order);
      return order;
  }

  public void subtractItemAmountFromRepo(UUID itemId,int amount) {
        itemRepository.subtractItemAfterOrder(itemId,amount);
  }


    public List<ItemGroupShippingToday> getItemGroupsShippingToday() {
        List<Order> orders = orderRepository.getAllOrders();
        List <ItemGroupShippingToday> itemGroupsShippingTodayList = new ArrayList<>();
        for (Order order: orders
             ) {
            for (ItemGroup itemGroup: order.getOrders()
                 ) {
                if (itemGroup.getShippingDate().equals(LocalDate.now().plusDays(1))) {
                    itemGroupsShippingTodayList.add(new ItemGroupShippingToday(itemGroup, order.getCustomer().getAdress()));
                }
            }
        }
        return itemGroupsShippingTodayList;
    }
}
