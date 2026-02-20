package com.narxoz.rpg.combat;

public class MeteorSrorm implements  Ability{
    String name = "Meteor Storm";
    int damage = 120;
    String description = "Summons a rain of meteors";

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
        return new MeteorSrorm();
    }
}
