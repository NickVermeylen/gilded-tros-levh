package com.gildedtros.application.item.factory;

import com.gildedtros.Item;
import com.gildedtros.domain.item.factory.UpdatableItemFactory;
import com.gildedtros.domain.item.model.UpdatableItem;
import com.gildedtros.domain.item.model.implementation.BackstagePassesItem;
import com.gildedtros.domain.item.model.implementation.DefaultItem;
import com.gildedtros.domain.item.model.implementation.IncreasingQualityItem;
import com.gildedtros.domain.item.model.implementation.LegendaryItem;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public final class GildedTrosItemFactory implements UpdatableItemFactory {

    private final HashMap<Predicate<String>,
            Function<Item, UpdatableItem>> itemTypes = new HashMap<>();
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES = "Backstage passes";

    public GildedTrosItemFactory() {
        itemTypes.put(equalsString(B_DAWG_KEYCHAIN), LegendaryItem::new);
        itemTypes.put(equalsString(GOOD_WINE), IncreasingQualityItem::new);
        itemTypes.put(startsWith(BACKSTAGE_PASSES), BackstagePassesItem::new);
    }

    private Function<Item, UpdatableItem> createItem = DefaultItem::new;

    @Override
    public UpdatableItem createGildedTrosItem(final Item item) {
        itemTypes.forEach(
                (key, entry) -> {
                    if (isNonDefaultItem(item, key)) {
                        createItem = entry;
                    }
                }
        );
        return createItem.apply(item);
    }

    private static boolean isNonDefaultItem(final Item item, final Predicate<String> key) {
        return key.test(item.name);
    }

    private Predicate<String> equalsString(final String value) {
        return s -> s.equals(value);
    }

    private Predicate<String> startsWith(final String value) {
        return s -> s.startsWith(value);
    }
}
