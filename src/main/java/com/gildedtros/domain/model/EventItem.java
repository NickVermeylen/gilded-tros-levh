package com.gildedtros.domain.model;

import com.gildedtros.Item;

public class EventItem implements UpdatableItem {

    private final Item item;

    public EventItem(final Item item) {
        this.item = item;
    }

    @Override
    public void updateItem() {
        //TODO add logic for events
    }
}
