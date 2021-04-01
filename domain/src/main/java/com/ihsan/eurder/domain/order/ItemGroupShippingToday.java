package com.ihsan.eurder.domain.order;

import com.ihsan.eurder.domain.customer.Customer;

public class ItemGroupShippingToday {
    private ItemGroup itemGroup;
    private String adress;

    public ItemGroupShippingToday(ItemGroup itemGroup, String adress) {
        this.itemGroup = itemGroup;
        this.adress = adress;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public String getAdress() {
        return adress;
    }
}
