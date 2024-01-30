package com.gildedtros.domain.item.model;

import com.gildedtros.Item;

public class LegendaryItem implements UpdatableItem {

    private static final int LEGENDARY_QUALITY = 80;

    private final Item item;

    public LegendaryItem(final Item item) {
        item.quality = LEGENDARY_QUALITY;
        this.item = item;
    }

    @Override
    public void updateItem() {
        // Legendary item doesn't change
    }
}
