package com.ihsan.eurder.domain.item;

import java.util.Objects;

public class ItemStockOverview implements Comparable<ItemStockOverview> {
    private Item item;
    private StockUrgencyIndicator stockUrgency;

    public ItemStockOverview() {
    }

    public ItemStockOverview(Item item) {
        this.item = item;
        if (item.getAmount() < 5 ) {
            stockUrgency = StockUrgencyIndicator.STOCK_LOW;
        }
        else if (item.getAmount() < 10) {
            stockUrgency = StockUrgencyIndicator.STOCK_MEDIUM;
        }
        else {
            stockUrgency = StockUrgencyIndicator.STOCK_HIGH;
        }
    }

    public Item getItem() {
        return item;
    }

    public StockUrgencyIndicator getStockUrgency() {
        return stockUrgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStockOverview that = (ItemStockOverview) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }


    @Override
    public int compareTo(ItemStockOverview o) {
        return item.getAmount() - o.item.getAmount();
    }

    @Override
    public String toString() {
        return "ItemStockOverview{" +
                "item=" + item +
                ", stockUrgency=" + stockUrgency +
                '}';
    }
}
