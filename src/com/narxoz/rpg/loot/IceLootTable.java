package com.narxoz.rpg.loot;

import java.util.List;

public class IceLootTable implements LootTable{
    private final List<String> items = List.of("Frost Shard", "Glacial Crystal", "Frozen Heart", "Ice Rune", "Snowflake Core", "Abyssal Ice", "Yeti Fur");
    private final int gold = 160;
    private final int experience = 420;
    private final String lootInfo = "Ice-themed drops: crystals, frozen hearts and runes. ";

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return gold;
    }

    @Override
    public int getExperienceDrop() {
        return experience;
    }

    @Override
    public String getLootInfo() {
        return lootInfo;
    }

    @Override
    public LootTable clone() {
        return new IceLootTable();
    }
}
