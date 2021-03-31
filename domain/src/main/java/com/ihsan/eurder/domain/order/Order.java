package com.ihsan.eurder.domain.order;

import com.ihsan.eurder.domain.customer.Customer;
import com.ihsan.eurder.infrastructure.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final Customer customer;
    private final List<ItemGroup> orders;
    private int totalPrice;

    public Order(Customer customer, List<ItemGroup> orders) {
        orderId = UUID.randomUUID();
        this.customer = customer;
        this.orders = orders;
    }

    public void addOrder(ItemGroup item) {
        ValidationUtil.throwExceptionIfNull(item,"Item");
        orders.add(item);
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getOrders() {
        return orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
