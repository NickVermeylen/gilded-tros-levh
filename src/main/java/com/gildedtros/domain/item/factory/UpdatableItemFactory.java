package com.gildedtros.domain.item.factory;

import com.gildedtros.Item;
import com.gildedtros.domain.item.model.UpdatableItem;

@FunctionalInterface
public interface UpdatableItemFactory {

    UpdatableItem createItem(Item item);
}
