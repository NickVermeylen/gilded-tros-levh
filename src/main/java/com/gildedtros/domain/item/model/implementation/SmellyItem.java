package com.gildedtros.domain.item.model.implementation;

import com.gildedtros.Item;

public class SmellyItem extends DefaultItem{

    public SmellyItem(final Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        decreaseQualityBy(2);
    }
}
