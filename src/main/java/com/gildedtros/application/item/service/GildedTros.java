package com.gildedtros.application.item.service;

import com.gildedtros.Item;
import com.gildedtros.application.item.factory.GildedTrosItemFactory;
import com.gildedtros.domain.item.factory.UpdatableItemFactory;
import com.gildedtros.domain.item.model.UpdatableItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedTros {

    Item[] items;
    private final List<UpdatableItem> inventory;

    public GildedTros(final Item[] items) {
        this.items = items;
        final UpdatableItemFactory updatableItemFactory = new GildedTrosItemFactory();
        inventory = Arrays.stream(items)
                .map(updatableItemFactory::createGildedTrosItem)
                .collect(Collectors.toList());
    }

    public void updateQuality() {
        inventory
                .forEach(UpdatableItem::updateItem);
    }
}
