package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.AI;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private final EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        builder.reset();
        return builder
                .setName("Minion")
                .setHealth(80)
                .setDamage(20)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        builder.reset();
        return builder
                .setName("Raid Boss")
                .setHealth(120000)
                .setDamage(1200)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .addPhase(1, 120000)
                .addPhase(2, 60000)
                .addPhase(3, 30000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(40)
                .setAI(factory.createAIBehavior())
                .build();
    }
}