package com.narxoz.rpg.loot;

import java.util.List;

public class FireLootTable implements LootTable{
    private final List<String> items = List.of("Fire Gem", "Dragon Scale", "Flame Rune", "Ember Core", "Burning Ash");
    private final int gold = 180;
    private final int experience = 450;
    private final String lootInfo = "Fire-themed loot: mostly gems, scales and runes. ";

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
        return new FireLootTable();
    }
}
