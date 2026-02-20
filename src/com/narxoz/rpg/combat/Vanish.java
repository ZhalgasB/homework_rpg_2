package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    String name = "Vanish";
    int damage = 0;
    String description = "Fades into the shadows for 4 seconds";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Ability clone() {
        return new Vanish();
    }
}
