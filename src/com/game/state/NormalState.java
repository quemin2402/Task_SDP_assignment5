package com.game.state;

import com.game.Character;

public class NormalState implements State {
    @Override
    public void attack(Character character) {
        System.out.println("Normal attack.");
        character.performAttack(character);
    }

    @Override
    public void defend(Character character) {
        System.out.println("Normal defense activated. Incoming damage will be reduced by 50%.");
        character.setDefending(true);
    }
}
