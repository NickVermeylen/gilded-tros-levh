package com.gildedtros.domain.model;

import com.gildedtros.Item;

public class EventItem extends Item implements UpdatableItem{

    public EventItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        //TODO add logic for events
    }
}
