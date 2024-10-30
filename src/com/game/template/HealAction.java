package com.game.template;

import com.game.Character;

public class HealAction extends GameAction {
    @Override
    protected void prepare() {
        System.out.println("Preparing to heal...");
    }

    @Override
    protected void action(Character healer, Character unused) {
        healer.heal(1);
    }

    @Override
    protected void conclude() {
        System.out.println("Healing completed.");
    }
}
