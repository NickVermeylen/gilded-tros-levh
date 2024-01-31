package com.gildedtros.domain.item.model.implementation;

import com.gildedtros.domain.item.Item;
import com.gildedtros.domain.item.model.InventoryItem;

public class DefaultItem extends InventoryItem {

    public DefaultItem(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (sellInDayIsOver(0)) {
            decreaseQualityBy(1);
        } else {
            decreaseQualityBy(2);
        }
    }
}
