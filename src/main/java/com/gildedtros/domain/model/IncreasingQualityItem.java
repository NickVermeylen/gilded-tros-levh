package com.gildedtros.domain.model;

import com.gildedtros.Item;

public class IncreasingQualityItem extends Item implements UpdatableItem{

    public IncreasingQualityItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        quality++;

        //TODO check max
    }
}
