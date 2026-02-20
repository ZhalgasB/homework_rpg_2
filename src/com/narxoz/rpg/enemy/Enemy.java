package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.AI;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Base interface for all enemies in the RPG system.
 *
 * Every enemy — from a lowly Goblin to an Ancient Dragon — shares
 * certain characteristics: they have stats, abilities, and loot.
 * But HOW they are created varies dramatically.
 *
 * ============================================================
 * WHY THIS INTERFACE MATTERS FOR DESIGN PATTERNS:
 * ============================================================
 *
 * Builder Pattern:
 *   Complex enemies have many fields (stats, abilities, phases, loot, AI).
 *   The Builder pattern constructs enemies step-by-step instead of
 *   cramming everything into one monstrous constructor.
 *   → Think: Should Enemy be immutable once built? (Hint: YES!)
 *
 * Prototype Pattern:
 *   This interface includes a clone() method. Enemies must be CLONABLE
 *   so we can create variants efficiently:
 *     Base Goblin → Elite Goblin → Goblin Champion → Goblin King
 *   → Think: What needs DEEP copying? What can be SHALLOW copied?
 *
 * Factory Method:
 *   The Builder's build() method IS a factory method — it produces
 *   Enemy objects. Different builders produce different enemy types.
 *
 * Abstract Factory:
 *   Enemy components (abilities, loot) come from themed factories.
 *   A FireComponentFactory guarantees all components match the fire theme.
 *
 * ============================================================
 * YOUR TASKS:
 * ============================================================
 *
 * TODO: Decide — should this be an interface or abstract class?
 *   - Interface: If implementations are very different
 *   - Abstract class: If you want shared fields (name, health, etc.)
 *   Hint: An abstract class with shared stat fields might be cleaner.
 *
 * TODO: Define the core enemy contract.
 *   Every enemy should provide:
 *   - Basic stats (health, damage, defense, speed)
 *   - Abilities they can use
 *   - Loot they drop when defeated
 *   - Information display (for the demo)
 *   - Clone method (for Prototype pattern)
 *
 * TODO: Think about immutability.
 *   - Once built by the Builder, should enemy stats change?
 *   - Should clone() return a mutable or immutable copy?
 *   - How do you allow Prototype to modify cloned stats?
 */
public abstract class Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element = "NONE";
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;
    protected AI aiBehavior = AI.NEUTRAL;

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public String getElement() { return element; }
    public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    public LootTable getLootTable() { return lootTable; }
    public AI getAIBehavior() { return aiBehavior; }

    // Public setters for Builder + Prototype variants (acceptable for homework)
    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setElement(String element) { this.element = element; }
    public void setAbilities(List<Ability> abilities) { this.abilities = new ArrayList<>(abilities); }
    public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }
    public void setAI(AI ai) { this.aiBehavior = ai; }

    public void addAbility(Ability a) { abilities.add(a); }

    public void multiplyStats(double multiplier) {
        if (multiplier <= 0) throw new IllegalArgumentException("Multiplier must be > 0");
        health = (int) (health * multiplier);
        damage = (int) (damage * multiplier);
        defense = (int) (defense * multiplier);
        speed = (int) (speed * multiplier);
    }

    public abstract void displayInfo();
    public abstract Enemy clone();   // DEEP COPY!
}
