package com.gildedtros.application.GildedTros.service;

import com.gildedtros.domain.item.Item;
import com.gildedtros.application.GildedTros.factory.GildedTrosItemFactory;
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
