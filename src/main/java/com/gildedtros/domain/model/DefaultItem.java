package com.gildedtros.domain.model;

import com.gildedtros.Item;

public class DefaultItem extends Item implements UpdatableItem{

    public DefaultItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        quality--;
    }
}
