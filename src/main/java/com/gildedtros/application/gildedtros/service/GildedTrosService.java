package com.gildedtros.application.gildedtros.service;

import com.gildedtros.application.gildedtros.factory.GildedTrosItemFactory;
import com.gildedtros.domain.inventory.Inventory;
import com.gildedtros.domain.item.model.Item;

class GildedTrosService {

    Item[] items;
    private final Inventory inventory;

    public GildedTrosService(final Item[] items) {
        this.items = items;
        inventory = new Inventory(this.items, new GildedTrosItemFactory());

    }

    public void updateQuality() {
        inventory.update();
    }
}
