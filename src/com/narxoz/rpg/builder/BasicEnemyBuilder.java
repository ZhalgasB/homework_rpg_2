package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AI;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health = 100;
    private int damage = 15;
    private int defense = 5;
    private int speed = 35;
    private String element = "NONE";
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private AI aiBehavior = AI.NEUTRAL;

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int h) { this.health = h; return this; }
    @Override public EnemyBuilder setDamage(int d) { this.damage = d; return this; }
    @Override public EnemyBuilder setDefense(int d) { this.defense = d; return this; }
    @Override public EnemyBuilder setSpeed(int s) { this.speed = s; return this; }
    @Override public EnemyBuilder setElement(String e) { this.element = e; return this; }
    @Override public EnemyBuilder addAbility(Ability a) { abilities.add(a); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> a) { this.abilities = new ArrayList<>(a); return this; }
    @Override public EnemyBuilder addPhase(int n, int t) { return this; }
    @Override public EnemyBuilder setLootTable(LootTable l) { this.lootTable = l; return this; }
    @Override public EnemyBuilder setAI(AI ai) { this.aiBehavior = ai; return this; }
    @Override public EnemyBuilder setCanFly(boolean b) { return this; }
    @Override public EnemyBuilder setHasBreathAttack(boolean b) { return this; }
    @Override public EnemyBuilder setWingspan(int w) { return this; }

    @Override
    public EnemyBuilder reset() {
        name = null;
        health = 100;
        damage = 15;
        defense = 5;
        speed = 35;
        element = "NONE";
        abilities.clear();
        lootTable = null;
        aiBehavior = AI.NEUTRAL;
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) throw new IllegalStateException("Name is required!");
        if (health <= 0) throw new IllegalStateException("Health must be positive!");

        Goblin goblin = new Goblin(name);
        goblin.setHealth(health);
        goblin.setDamage(damage);
        goblin.setDefense(defense);
        goblin.setSpeed(speed);
        goblin.setElement(element);
        goblin.setAbilities(abilities);
        if (lootTable != null) goblin.setLootTable(lootTable);
        goblin.setAI(aiBehavior);

        return goblin;
    }
}
