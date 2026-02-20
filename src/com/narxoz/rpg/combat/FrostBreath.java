package com.narxoz.rpg.combat;

public class FrostBreath implements Ability{
    String name = "Frost Breath";
    int damage = 40;
    String description = "Releases a chilling breath";

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
        return new FrostBreath();
    }
}
