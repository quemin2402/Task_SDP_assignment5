package com.game.strategy;

import com.game.Character;

public class RangedStrategy implements FightingStrategy {
    @Override
    public void fight(Character target) {
        System.out.println("Ranged attack!");
        target.receiveDamage(1);
    }
}
