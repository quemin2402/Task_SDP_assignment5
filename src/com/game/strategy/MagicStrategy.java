package com.game.strategy;

import java.util.Random;
import com.game.Character;

public class MagicStrategy implements FightingStrategy {
    private Random rand = new Random();

    @Override
    public void fight(Character target) {
        if (rand.nextBoolean()) {
            System.out.println("Magic attack successful!");
            target.receiveDamage(1);
        } else {
            System.out.println("Magic attack failed.");
        }
    }
}
