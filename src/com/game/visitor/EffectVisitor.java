package com.game.visitor;

import com.game.Character;

public interface EffectVisitor {
    void applyBoost(Character character);
    void applyDamage(Character character);
}
