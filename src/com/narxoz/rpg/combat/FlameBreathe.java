package com.narxoz.rpg.combat;

public class FlameBreathe implements Ability {

    String name = "FlameBreathe";
    int damage = 45;
    String description = "Breathes a cone of fire";


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
        return new FlameBreathe();
    }




}
