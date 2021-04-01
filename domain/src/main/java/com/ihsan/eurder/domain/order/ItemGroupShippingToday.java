package com.ihsan.eurder.domain.order;

import com.ihsan.eurder.domain.customer.Customer;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroupShippingToday that = (ItemGroupShippingToday) o;
        return Objects.equals(itemGroup, that.itemGroup) && Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemGroup, adress);
    }
}
