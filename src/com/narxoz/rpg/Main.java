package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.combat.AI;
import com.narxoz.rpg.combat.FlameBreathe;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.builder.EnemyRegister;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemies ===\n");

        // Part 1
        System.out.println("Part 1: Factories");
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        System.out.println("Fire abilities: " + fireFactory.createAbilities().size());
        System.out.println("Fire loot: " + fireFactory.createLootTable().getLootInfo());


        // Part 2: Different enemies with Builder
        System.out.println("\nPart 2: Different enemies");

        // Goblin (simple enemy)
        System.out.println("\n--- Goblin ---");
        Enemy goblin = new BasicEnemyBuilder()
                .setName("Forest Goblin")
                .setHealth(120)
                .setDamage(18)
                .setAI(AI.AGGRESSIVE)
                .build();
        goblin.displayInfo();

        // Dragon Boss (complex boss)
        System.out.println("\n--- Dragon Boss ---");
        BossEnemyBuilder bossBuilder = new BossEnemyBuilder();
        EnemyDirector director = new EnemyDirector(bossBuilder);
        Enemy dragon = director.createRaidBoss(fireFactory);
        dragon.displayInfo();

        // Simple minion (from director)
        System.out.println("\n--- Minion ---");
        Enemy minion = director.createMinion(fireFactory);
        minion.displayInfo();

        // Part 3: Prototype - variants
        System.out.println("\nPart 3: Prototype - variants");
        EnemyRegister registry = new EnemyRegister();
        registry.registerTemplate("goblin", goblin);
        registry.registerTemplate("dragon", dragon);

        // Elite Goblin
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(1.5);
        eliteGoblin.setElement("POISON");
        eliteGoblin.displayInfo();

        // Mythic Dragon
        Enemy mythicDragon = registry.createFromTemplate("dragon");
        mythicDragon.multiplyStats(4.0);
        mythicDragon.setElement("ANCIENT");
        mythicDragon.displayInfo();

        // Check deep copy
        eliteGoblin.addAbility(new FlameBreathe());
        System.out.println("Original goblin abilities count: " + goblin.getAbilities().size());

        // Part 4
        System.out.println("\nPart 4: All together");
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        Enemy shadowBoss = new BossEnemyBuilder()
                .setName("Shadow Boss")
                .setHealth(80000)
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .build();

        registry.registerTemplate("shadow-overlord", shadowBoss);
        Enemy mythicShadow = registry.createFromTemplate("shadow-overlord");
        mythicShadow.multiplyStats(3.0);
        mythicShadow.displayInfo();

        System.out.println("\n=== Done ===");
    }
}