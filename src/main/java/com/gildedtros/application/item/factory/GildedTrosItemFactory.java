package com.gildedtros.application.item.factory;

import com.gildedtros.Item;
import com.gildedtros.domain.item.model.*;
import com.gildedtros.domain.item.model.implementation.BackstagePassesItem;
import com.gildedtros.domain.item.model.implementation.DefaultItem;
import com.gildedtros.domain.item.model.implementation.IncreasingQualityItem;
import com.gildedtros.domain.item.model.implementation.LegendaryItem;

public final class GildedTrosItemFactory implements com.gildedtros.domain.item.factory.UpdatableItemFactory {

    public GildedTrosItemFactory() {
    }

    @Override
    public UpdatableItem createItem(final Item item) {

        if (item.name.equals("B-DAWG Keychain")) {
            return new LegendaryItem(item);
        } else if (item.name.equals("Good Wine")) {
            return new IncreasingQualityItem(item);
        } else if (item.name.startsWith("Backstage passes")) {
            return new BackstagePassesItem(item);
        } else {
            return new DefaultItem(item);
        }

    }
}
