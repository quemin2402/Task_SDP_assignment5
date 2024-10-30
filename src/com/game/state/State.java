package com.game.state;

import com.game.Character;

public interface State {
    void attack(Character character);
    void defend(Character character);
}
