package com.gildedtros.domain.item.model.implementation;

import com.gildedtros.domain.item.Item;

public class BackstagePassesItem extends DefaultItem {

    public BackstagePassesItem(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (sellInDayIsOver(10)) {
            increaseQualityBy(1);
        } else if (sellInDayIsOver(5)) {
            increaseQualityBy(2);
        } else if (sellInDayIsOver(0)) {
            increaseQualityBy(3);
        } else if (sellInDayIsOver(-1)) {
            setQualityToMinValue();
        }

    }
}
