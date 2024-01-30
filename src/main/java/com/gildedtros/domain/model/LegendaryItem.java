package com.gildedtros.domain.model;

import com.gildedtros.Item;

public class LegendaryItem extends Item implements UpdatableItem{

    private static final int LEGENDARY_QUALITY = 80;

    public LegendaryItem(final String name) {
        super(name, Integer.MAX_VALUE, LEGENDARY_QUALITY);
    }

    @Override
    public void updateItem() {
        // Legendary item doesn't change
    }
}
