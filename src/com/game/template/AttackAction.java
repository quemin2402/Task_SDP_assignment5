package com.game.template;

import com.game.Character;

public class AttackAction extends GameAction{
    @Override
    protected void prepare() {
        System.out.println("Preparing to attack...");
    }

    @Override
    protected void action(Character attacker, Character target) {
        attacker.performAttack(target);
    }

    @Override
    protected void conclude() {
        System.out.println("Attack completed.");
    }
}
