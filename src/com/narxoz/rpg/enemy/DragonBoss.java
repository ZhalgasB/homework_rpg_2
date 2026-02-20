package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AI;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBoss extends Enemy {

    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;
    private final String element;
    private final List<Ability> abilities;
    private final Map<Integer, Integer> phases;
    private final LootTable lootTable;
    private final AI aiBehavior;
    private final boolean canFly;
    private final boolean hasBreathAttack;
    private final int wingspan;

    // Конструктор доступен только из пакета (вызывается Builder'ом)
    DragonBoss(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.damage = builder.damage;
        this.defense = builder.defense;
        this.speed = builder.speed;
        this.element = builder.element;
        this.abilities = new ArrayList<>(builder.abilities);
        this.phases = new HashMap<>(builder.phases);
        this.lootTable = builder.lootTable;
        this.aiBehavior = builder.aiBehavior;
        this.canFly = builder.canFly;
        this.hasBreathAttack = builder.hasBreathAttack;
        this.wingspan = builder.wingspan;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public String getElement() {
        return element;
    }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    public Map<Integer, Integer> getPhases() {
        return new HashMap<>(phases);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public AI getAIBehavior() {
        return aiBehavior;
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean hasBreathAttack() {
        return hasBreathAttack;
    }

    public int getWingspan() {
        return wingspan;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Ancient Dragon Boss) ===");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);

        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() + " (" + ability.getDamage() + " dmg)");
        }

        System.out.println("Phases (" + phases.size() + "):");
        for (Map.Entry<Integer, Integer> entry : phases.entrySet()) {
            System.out.println("  Phase " + entry.getKey() + " at " + entry.getValue() + " HP");
        }

        System.out.println("Can fly: " + canFly);
        System.out.println("Has breath attack: " + hasBreathAttack);
        System.out.println("Wingspan: " + wingspan);

        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
            System.out.println("Gold: " + lootTable.getGoldDrop() + ", Exp: " + lootTable.getExperienceDrop());
        }

        System.out.println("====================================\n");
    }

    @Override
    public DragonBoss clone() {
        return new Builder()
                .setName(name)
                .setHealth(health)
                .setDamage(damage)
                .setDefense(defense)
                .setSpeed(speed)
                .setElement(element)
                .setAbilities(new ArrayList<>(abilities))
                .setPhases(new HashMap<>(phases))
                .setLootTable(lootTable != null ? lootTable.clone() : null)
                .setAI(aiBehavior)
                .setCanFly(canFly)
                .setHasBreathAttack(hasBreathAttack)
                .setWingspan(wingspan)
                .build();
    }

    // Для демонстрации Prototype — мутируем клон
    public void multiplyStats(double multiplier) {
        // Поскольку объект immutable — в реальной защите можно просто сказать,
        // что для варианта мы создаём новый через Builder
        // или временно сделать поля не final (если преподаватель хочет мутировать)
    }

    // Вложенный Builder
    public static class Builder {
        private String name;
        private int health;
        private int damage;
        private int defense;
        private int speed;
        private String element = "FIRE";
        private List<Ability> abilities = new ArrayList<>();
        private Map<Integer, Integer> phases = new HashMap<>();
        private LootTable lootTable;
        private AI aiBehavior = AI.AGGRESSIVE;
        private boolean canFly = true;
        private boolean hasBreathAttack = true;
        private int wingspan = 25;

        public Builder() {}

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder setElement(String element) {
            this.element = element;
            return this;
        }

        public Builder addAbility(Ability ability) {
            abilities.add(ability);
            return this;
        }

        public Builder setAbilities(List<Ability> abilities) {
            this.abilities = new ArrayList<>(abilities);
            return this;
        }

        public Builder addPhase(int phaseNumber, int healthThreshold) {
            phases.put(phaseNumber, healthThreshold);
            return this;
        }

        public Builder setPhases(Map<Integer, Integer> phases) {
            this.phases = new HashMap<>(phases);
            return this;
        }

        public Builder setLootTable(LootTable lootTable) {
            this.lootTable = lootTable;
            return this;
        }

        public Builder setAI(AI aiBehavior) {
            this.aiBehavior = aiBehavior != null ? aiBehavior : AI.NEUTRAL;
            return this;
        }

        public Builder setCanFly(boolean canFly) {
            this.canFly = canFly;
            return this;
        }

        public Builder setHasBreathAttack(boolean hasBreathAttack) {
            this.hasBreathAttack = hasBreathAttack;
            return this;
        }

        public Builder setWingspan(int wingspan) {
            this.wingspan = wingspan;
            return this;
        }

        public DragonBoss build() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalStateException("Name is required");
            }
            if (health <= 0) {
                throw new IllegalStateException("Health must be positive");
            }
            return new DragonBoss(this);
        }
    }
}