package com.gildedtros.application.gildedtros.factory;

import com.gildedtros.domain.item.model.Item;
import com.gildedtros.domain.item.factory.UpdatableItemFactory;
import com.gildedtros.domain.item.model.UpdatableItem;
import com.gildedtros.domain.item.model.implementation.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public final class GildedTrosItemFactory implements UpdatableItemFactory {

    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES = "Backstage passes";
    private static final List<String> SMELLY_ITEMS = Arrays.asList("Duplicate Code", "Long Methods", "Ugly Variable Names");

    private final HashMap<Predicate<String>,
            Function<Item, UpdatableItem>> itemTypesWithChecks = new HashMap<>();

    public GildedTrosItemFactory() {
        itemTypesWithChecks.put(B_DAWG_KEYCHAIN::equals, LegendaryItem::new);
        itemTypesWithChecks.put(GOOD_WINE::equals, IncreasingQualityItem::new);
        itemTypesWithChecks.put(startsWith(BACKSTAGE_PASSES), BackstagePassesItem::new);
        itemTypesWithChecks.put(SMELLY_ITEMS::contains, SmellyItem::new);
    }

    @Override
    public UpdatableItem createGildedTrosItem(final Item item) {
        return getNonDefaultItem(item)
                .orElseGet(() -> new DefaultItem(item));
    }

    private Optional<UpdatableItem> getNonDefaultItem(final Item item) {
        for (final Map.Entry<Predicate<String>, Function<Item, UpdatableItem>> itemTypeWithCheck : itemTypesWithChecks.entrySet()) {
            final Predicate<String> isItemType = itemTypeWithCheck.getKey();
            final Function<Item, UpdatableItem> itemType = itemTypeWithCheck.getValue();

            if (isItemType.test(item.name)) {
                return Optional.of(itemType.apply(item));
            }
        }
        return Optional.empty();
    }

    private Predicate<String> startsWith(final String value) {
        return s -> s.startsWith(value);
    }
}
