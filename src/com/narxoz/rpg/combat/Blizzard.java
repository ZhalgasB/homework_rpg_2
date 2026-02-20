package com.narxoz.rpg.combat;

public class Blizzard implements Ability{
    String name = "Blizzard";
    int damage = 80;
    String description = "Longe distance Ability!";

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
        return new Blizzard();
    }
}
