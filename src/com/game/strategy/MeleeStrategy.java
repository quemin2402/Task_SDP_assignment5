package com.game.strategy;

import com.game.Character;

public class MeleeStrategy implements FightingStrategy {
    @Override
    public void fight(Character target) {
        System.out.println("Melee attack!");
        target.receiveDamage(2);
    }
}
