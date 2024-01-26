package com.gildedtros;

class GildedTros {
    private static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    private static final String GOOD_WINE = "Good Wine";
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedTros(final Item[] items) {
        this.items = items.clone();
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (!GOOD_WINE.equals(item.name)
                    && !BACKSTAGE_PASSES_FOR_RE_FACTOR.equals(item.name)
                    && !BACKSTAGE_PASSES_FOR_HAXX.equals(item.name)) {
                if (item.quality > 0 && (!B_DAWG_KEYCHAIN.equals(item.name))) {
                        item.quality = item.quality - 1;

                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (BACKSTAGE_PASSES_FOR_RE_FACTOR.equals(item.name) || BACKSTAGE_PASSES_FOR_HAXX.equals(item.name)) {
                        if (item.sellIn < 11 && (item.quality < MAX_QUALITY)) {
                                item.quality = item.quality + 1;

                        }

                        if (item.sellIn < 6 && (item.quality < MAX_QUALITY)) {
                                item.quality = item.quality + 1;

                        }
                    }
                }
            }

            if (!B_DAWG_KEYCHAIN.equals(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!GOOD_WINE.equals(item.name)) {
                    if (!BACKSTAGE_PASSES_FOR_RE_FACTOR.equals(item.name) && !BACKSTAGE_PASSES_FOR_HAXX.equals(item.name)) {
                        if (item.quality > 0 && (!B_DAWG_KEYCHAIN.equals(item.name))) {
                                item.quality = item.quality - 1;

                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
