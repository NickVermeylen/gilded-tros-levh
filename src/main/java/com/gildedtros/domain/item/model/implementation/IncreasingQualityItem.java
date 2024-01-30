package com.gildedtros.domain.item.model.implementation;

import com.gildedtros.Item;
import com.gildedtros.domain.item.model.InventoryItem;

public class IncreasingQualityItem extends InventoryItem {

    public IncreasingQualityItem(final Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        increaseQualityBy(1);
        passDay();
    }
}
