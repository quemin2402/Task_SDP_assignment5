package com.game.state;

import com.game.Character;

public class DefeatedState implements State {
    @Override
    public void attack(Character character) {
        System.out.println("Cannot attack; character is defeated.");
    }
    @Override
    public void defend(Character character) {
        System.out.println("Cannot defend; character is defeated.");
    }
}
