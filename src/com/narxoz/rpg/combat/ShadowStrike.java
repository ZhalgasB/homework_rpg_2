package com.narxoz.rpg.combat;

public class ShadowStrike implements  Ability{
    String name = "Shadow Strike";
    int damage = 70;
    String description = "Strikes from the shadows";

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
        return new ShadowStrike();
    }
}
