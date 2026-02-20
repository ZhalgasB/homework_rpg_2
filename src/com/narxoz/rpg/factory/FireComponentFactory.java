package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.FireLootTable;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {


    @Override
    public List<Ability> createAbilities() {
        return List.of(new FireShield(),new FlameBreathe(),new MeteorSrorm());
    }

    @Override
    public LootTable createLootTable() {
        return new FireLootTable();
    }

    @Override
    public AI createAIBehavior() {
        return AI.AGGRESSIVE;
    }
}
