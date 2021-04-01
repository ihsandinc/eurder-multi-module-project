package com.ihsan.eurder.api.order;

public class ItemShippingTodayDto {
    private GetItemGroupDto itemShippingToday;
    private String adressToShip;

    public ItemShippingTodayDto() {
    }

    public ItemShippingTodayDto(GetItemGroupDto itemShippingToday, String adressToShip) {
        this.itemShippingToday = itemShippingToday;
        this.adressToShip = adressToShip;
    }

    public GetItemGroupDto getItemShippingToday() {
        return itemShippingToday;
    }

    public String getAdressToShip() {
        return adressToShip;
    }

    @Override
    public String toString() {
        return "itemShippingToday=" + itemShippingToday +
                ", adressToShip='" + adressToShip + '\'' +
                '}';
    }
}
