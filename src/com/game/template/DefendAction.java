package com.game.template;

import com.game.Character;

public class DefendAction extends GameAction {
    @Override
    protected void prepare() {
        System.out.println("Preparing to defend...");
    }

    @Override
    protected void action(Character defender, Character unused) {
        defender.performDefend();
    }

    @Override
    protected void conclude() {
        System.out.println("Defense completed.");
    }
}
