package com.game;

import com.game.state.DefeatedState;
import com.game.state.State;
import com.game.strategy.FightingStrategy;

public class Character {
    private int health = 5;
    private boolean boosted = false;
    private int successfulAttacks = 0;
    private boolean defending = false;
    private State currentState;
    private FightingStrategy currentStrategy;

    public Character(State initialState, FightingStrategy initialStrategy) {
        this.currentState = initialState;
        this.currentStrategy = initialStrategy;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void setStrategy(FightingStrategy strategy) {
        this.currentStrategy = strategy;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    public void performAttack(Character opponent) {
        if (health <= 0) {
            System.out.println("This character is already defeated and cannot attack.");
            return;
        }

        if (boosted) {
            System.out.println("Using powered-up attack!");
            opponent.receiveDamage(3);
            boosted = false;
        } else {
            System.out.println("Normal attack:");
            currentStrategy.fight(opponent);
        }

        if (opponent.health > 0) {
            successfulAttacks++;
            if (successfulAttacks >= 2) {
                activatePowerBoost();
            }
        }
    }

    public void performDefend() {
        System.out.println("Defending...");
        currentState.defend(this);
    }

    public void receiveDamage(int damage) {
        if (health <= 0) {
            System.out.println("This character is already defeated and cannot receive more damage.");
            return;
        }

        int finalDamage = defending ? (int) Math.ceil(damage * 0.5) : damage;
        health -= finalDamage;

        if (health <= 0) {
            health = 0;
            setState(new DefeatedState());
            System.out.println("Character is defeated.");
        } else {
            System.out.println("Current health after damage: " + health);
        }

        defending = false;
    }

    public void heal(int amount) {
        if (health <= 0) {
            System.out.println("This character is defeated and cannot be healed.");
            return;
        }

        health = Math.min(5, health + amount);
        System.out.println("Current health after healing: " + health);
    }

    public void activatePowerBoost() {
        if (health > 0) {
            System.out.println("Power boost activated for next attack!");
            boosted = true;
            successfulAttacks = 0;
        }
    }

    public int getHealth() {
        return health;
    }

    public void displayHealth(String name) {
        System.out.println(name + " Health: " + health);
    }
}
