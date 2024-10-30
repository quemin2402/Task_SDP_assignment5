package com.game.template;

import com.game.Character;

public abstract class GameAction {
    public final void executeAction(Character attacker, Character target) {  // Добавляем target
        prepare();
        action(attacker, target);
        conclude();
    }

    protected abstract void prepare();
    protected abstract void action(Character attacker, Character target);  // Изменяем метод action
    protected abstract void conclude();
}
