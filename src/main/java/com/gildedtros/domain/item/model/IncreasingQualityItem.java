package com.gildedtros.domain.item.model;

import com.gildedtros.Item;

public class IncreasingQualityItem implements UpdatableItem {

    private final Item item;

    public IncreasingQualityItem(final Item item) {
        this.item = item;
    }

    @Override
    public void updateItem() {
        //TODO check max
    }
}
