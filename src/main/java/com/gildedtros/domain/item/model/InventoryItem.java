package com.gildedtros.domain.item.model;

import com.gildedtros.domain.item.Item;

public abstract class InventoryItem implements UpdatableItem {

    private static final int MAX_QUALITY = 50;
    private final Item item;

    protected InventoryItem(final Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

    @Override
    public void updateItem() {
        updateQuality();
        passDay();
    }

    private void passDay() {
        item.sellIn--;
    }

    public int getMaxQuality() {
        return MAX_QUALITY;
    }

    protected void increaseQualityBy(final int value) {
        item.quality = item.quality + value;
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    protected void decreaseQualityBy(final int value) {
        item.quality = item.quality - value;
        if (item.quality <= 0) {
            item.quality = 0;
        }
    }

    protected void setQualityToMinValue() {
        item.quality = 0;
    }

    protected void setQualityToMaxValue() {
        item.quality = getMaxQuality();
    }

    protected boolean sellInDayIsOver(final int days) {
        return item.sellIn > days;
    }
}
