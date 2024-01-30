package com.gildedtros.application.item.service;

import com.gildedtros.Item;
import com.gildedtros.application.item.factory.GildedTrosItemFactory;
import com.gildedtros.domain.item.factory.UpdatableItemFactory;
import com.gildedtros.domain.item.model.UpdatableItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedTros {
    private static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    private static final String GOOD_WINE = "Good Wine";
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final int MAX_QUALITY = 50;

    Item[] items;
    private final List<UpdatableItem> inventory;
    private final UpdatableItemFactory updatableItemFactory = new GildedTrosItemFactory();

    public GildedTros(final Item[] items) {
        this.items = items;
        inventory = Arrays.stream(items)
                .map(updatableItemFactory::createItem)
                .collect(Collectors.toList());
    }

    public void updateQuality() {
        inventory
                .forEach(UpdatableItem::updateItem);
    }
}
