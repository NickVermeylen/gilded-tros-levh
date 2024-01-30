package com.gildedtros.domain.model;

import com.gildedtros.Item;

public class DefaultItem implements UpdatableItem {

    private final Item item;

    public DefaultItem(final Item item) {
        this.item = item;
    }

    @Override
    public void updateItem() {
        //TODO implement logic
    }
}
