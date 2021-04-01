package com.ihsan.eurder.domain.order;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
     private Map<UUID,Order> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(),order);
    }

    public Order getOrderById(UUID id) {
        return orders.get(id);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }





}
