package com.narxoz.rpg.combat;

public class DarkNova implements Ability {
    String name = "DarkNova";
    int damage = 100;
    String description = "Steals Ability!";
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
        return new DarkNova();
    }
}
