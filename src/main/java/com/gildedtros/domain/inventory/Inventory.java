package com.gildedtros.domain.inventory;

import com.gildedtros.domain.item.Item;
import com.gildedtros.domain.item.factory.UpdatableItemFactory;
import com.gildedtros.domain.item.model.UpdatableItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private final List<UpdatableItem> inventoryItems;

    public Inventory(final Item[] items,final UpdatableItemFactory updatableItemFactory ) {
        inventoryItems = Arrays.stream(items)
                .map(updatableItemFactory::createGildedTrosItem)
                .collect(Collectors.toList());
    }

    public void update(){
        inventoryItems.forEach(UpdatableItem::updateItem);
    }
}
