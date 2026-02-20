package com.narxoz.rpg.loot;

import java.util.List;

public class ShadowLootTable implements LootTable{
    private final List<String> items = List.of("Shadow Essence", "Void Crystal", "Night Opal", "Dark Rune", "Abyssal Fragment", "Umbral Silk", "Wraith Cloth");
    private final int gold = 220;
    private final int experience = 520;
    private final String lootInfo = "Shadow-themed loot: essences, void crystals and dark runes. ";

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
        return new ShadowLootTable();
    }
}
