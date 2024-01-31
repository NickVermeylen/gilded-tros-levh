package com.gildedtros.domain.item.model.implementation;

import com.gildedtros.domain.item.Item;

public class SmellyItem extends DefaultItem {

    public SmellyItem(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQualityBy(2);
    }
}
