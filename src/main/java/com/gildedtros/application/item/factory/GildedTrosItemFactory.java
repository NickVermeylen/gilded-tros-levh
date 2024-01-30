package com.gildedtros.application.item.factory;

import com.gildedtros.domain.item.Item;
import com.gildedtros.domain.item.factory.UpdatableItemFactory;
import com.gildedtros.domain.item.model.UpdatableItem;
import com.gildedtros.domain.item.model.implementation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public final class GildedTrosItemFactory implements UpdatableItemFactory {

    private final HashMap<Predicate<String>,
            Function<Item, UpdatableItem>> itemTypes = new HashMap<>();
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES = "Backstage passes";
    private static final List<String> SMELLY_ITEMS = Arrays.asList("Duplicate Code", "Long Methods", "Ugly Variable Names");

    public GildedTrosItemFactory() {
        itemTypes.put(isEqualTo(B_DAWG_KEYCHAIN), LegendaryItem::new);
        itemTypes.put(isEqualTo(GOOD_WINE), IncreasingQualityItem::new);
        itemTypes.put(startsWith(BACKSTAGE_PASSES), BackstagePassesItem::new);
        itemTypes.put(SMELLY_ITEMS::contains, SmellyItem::new);
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

    private Predicate<String> isEqualTo(final String value) {
        return s -> s.equals(value);
    }

    private Predicate<String> startsWith(final String value) {
        return s -> s.startsWith(value);
    }
}
