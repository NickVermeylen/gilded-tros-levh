package com.gildedtros.domain.item.factory;

import com.gildedtros.domain.item.Item;
import com.gildedtros.domain.item.model.UpdatableItem;

@FunctionalInterface
public interface UpdatableItemFactory {

    UpdatableItem createGildedTrosItem(Item item);
}
