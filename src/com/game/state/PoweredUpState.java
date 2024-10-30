package com.game.state;

import com.game.Character;

public class PoweredUpState implements State {
    @Override
    public void attack(Character character) {
        System.out.println("Powered-up attack!");
        character.performAttack(character);
    }

    @Override
    public void defend(Character character) {
        System.out.println("Powered-up defense.");
        character.performDefend();
    }
}
