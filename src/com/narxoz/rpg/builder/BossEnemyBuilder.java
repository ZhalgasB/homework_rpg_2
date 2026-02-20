package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AI;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health = 50000;
    private int damage = 500;
    private int defense = 200;
    private int speed = 50;
    private String element = "FIRE";
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable lootTable;
    private AI aiBehavior = AI.AGGRESSIVE;
    private boolean canFly = true;
    private boolean hasBreathAttack = true;
    private int wingspan = 25;

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        abilities.add(ability);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int n, int t) {
        phases.put(n, t);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public EnemyBuilder setAI(AI aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public EnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    @Override
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    @Override
    public EnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    @Override
    public EnemyBuilder reset() {
        name = null;
        health = 50000;
        damage = 500;
        defense = 200;
        speed = 50;
        element = "FIRE";
        abilities.clear();
        phases.clear();
        lootTable = null;
        aiBehavior = AI.AGGRESSIVE;
        canFly = true;
        hasBreathAttack = true;
        wingspan = 25;
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Name required!");
        }
        if (health <= 0) {
            throw new IllegalStateException("Health must be positive!");
        }

        // Используем вложенный Builder из DragonBoss
        DragonBoss.Builder innerBuilder = new DragonBoss.Builder();

        innerBuilder.setName(name);
        innerBuilder.setHealth(health);
        innerBuilder.setDamage(damage);
        innerBuilder.setDefense(defense);
        innerBuilder.setSpeed(speed);
        innerBuilder.setElement(element);
        innerBuilder.setAbilities(abilities);
        innerBuilder.setPhases(phases);
        innerBuilder.setLootTable(lootTable);
        innerBuilder.setAI(aiBehavior);
        innerBuilder.setCanFly(canFly);
        innerBuilder.setHasBreathAttack(hasBreathAttack);
        innerBuilder.setWingspan(wingspan);

        return innerBuilder.build();
    }
}