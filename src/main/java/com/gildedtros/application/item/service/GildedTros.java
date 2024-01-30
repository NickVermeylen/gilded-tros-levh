package com.gildedtros.application.item.service;

import com.gildedtros.domain.item.Item;
import com.gildedtros.application.item.factory.GildedTrosItemFactory;
import com.gildedtros.domain.inventory.Inventory;

class GildedTros {

    Item[] items;
    private final Inventory inventory;

    public GildedTros(final Item[] items) {
        this.items = items;
        inventory = new Inventory(items, new GildedTrosItemFactory());

    }

    public void updateQuality() {
        inventory.update();
    }
}
