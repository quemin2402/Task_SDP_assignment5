package com.game.visitor;

import com.game.Character;

public class BoostEffect implements EffectVisitor {
    @Override
    public void applyBoost(Character character) {
        System.out.println("Boost applied!");
        character.activatePowerBoost();
    }

    @Override
    public void applyDamage(Character character) {
        // not for boost
    }
}