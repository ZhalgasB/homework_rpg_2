package com.narxoz.rpg.combat;

public class IceShield  implements Ability{
    String name = "Ice Shield";
    int damage = 0;
    String description = "Creates an ice barrier that absorbs up";

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
        return new IceShield();
    }
}
