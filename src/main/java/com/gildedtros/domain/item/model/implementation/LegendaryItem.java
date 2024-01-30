package com.gildedtros.domain.item.model.implementation;

import com.gildedtros.domain.item.Item;
import com.gildedtros.domain.item.model.InventoryItem;

public class LegendaryItem extends InventoryItem {

    private static final int LEGENDARY_QUALITY = 80;

    public LegendaryItem(final Item item) {
        super(item);
        setQualityToMaxValue();
    }

    @Override
    public int getMaxQuality() {
        return LEGENDARY_QUALITY;
    }

    @Override
    public void updateItem() {
        // Legendary item doesn't change
    }

    @Override
    public void updateQuality() {
        // Legendary item doesn't change
    }
}
