package com.gildedtros.model;

import com.gildedtros.Item;

public final class ItemMother {

    private ItemMother() {
    }

    public static Item defaultItem(final int sellIn, final int quality) {
        return new Item("foo", sellIn, quality);
    }

    public static Item goodWine(final int sellIn, final int quality) {
        return new Item("Good Wine", sellIn, quality);
    }

    public static Item bDawgKeychain() {
        return new Item("B-DAWG Keychain", Integer.MAX_VALUE, 80);
    }

    public static Item backstagePasses(final int sellIn, final int quality) {
        return new Item("Backstage passes for Re:Factor", sellIn, quality);
    }
}
