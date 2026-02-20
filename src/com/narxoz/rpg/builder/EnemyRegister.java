package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import java.util.HashMap;
import java.util.Map;

public class EnemyRegister{
    private final Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template) {
        templates.put(key, template);
    }

    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) throw new IllegalArgumentException("Unknown template: " + key);
        return template.clone();
    }

    public void listTemplates() {
        System.out.println("Registered templates: " + templates.keySet());
    }
}