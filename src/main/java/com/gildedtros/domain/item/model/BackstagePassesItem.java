package com.gildedtros.domain.item.model;

import com.gildedtros.Item;

public class BackstagePassesItem implements UpdatableItem {

    private final Item item;

    public BackstagePassesItem(final Item item) {
        this.item = item;
    }

    @Override
    public void updateItem() {
        //TODO add logic for events
    }
}
