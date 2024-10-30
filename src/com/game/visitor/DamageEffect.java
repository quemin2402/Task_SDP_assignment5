package com.game.visitor;

import com.game.Character;

public class DamageEffect implements EffectVisitor {
    @Override
    public void applyBoost(Character character) {
        // not for damage
    }

    @Override
    public void applyDamage(Character character) {
        System.out.println("Damage applied.");
        character.receiveDamage(1);
    }
}