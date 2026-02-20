package com.narxoz.rpg.combat;

public class FireShield implements Ability{
    String name = "Fire Shield";
    int damage = 0;
    String description = "Surrounds the user with a fiery barrier";

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
        return new FireShield();
    }
}
