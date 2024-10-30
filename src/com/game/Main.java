package com.game;

import com.game.state.NormalState;
import com.game.strategy.MagicStrategy;
import com.game.strategy.MeleeStrategy;
import com.game.strategy.RangedStrategy;
import com.game.template.AttackAction;
import com.game.template.DefendAction;
import com.game.template.HealAction;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character player = new Character(new NormalState(), new MeleeStrategy());
        Character opponent = new Character(new NormalState(), new RangedStrategy());
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (player.getHealth() > 0 && opponent.getHealth() > 0) {
            int opponentAction = random.nextInt(5);
            System.out.println("Opponent chooses an action...");
            switch (opponentAction) {
                case 0:
                    System.out.println("Opponent uses melee attack!");
                    opponent.setStrategy(new MeleeStrategy());
                    new AttackAction().executeAction(opponent, player);
                    break;
                case 1:
                    System.out.println("Opponent uses ranged attack!");
                    opponent.setStrategy(new RangedStrategy());
                    new AttackAction().executeAction(opponent, player);
                    break;
                case 2:
                    System.out.println("Opponent uses magic!");
                    opponent.setStrategy(new MagicStrategy());
                    if (random.nextBoolean()) {
                        new AttackAction().executeAction(opponent, player);
                    } else {
                        System.out.println("Magic attack missed!");
                    }
                    break;
                case 3:
                    System.out.println("Opponent defends!");
                    new DefendAction().executeAction(opponent, null);
                    break;
                case 4:
                    System.out.println("Opponent heals!");
                    new HealAction().executeAction(opponent, null);
                    break;
            }

            if (player.getHealth() <= 0) {
                System.out.println("Player has lost!");
                break;
            }

            System.out.println("\nYour turn! Choose an action:");
            System.out.println("1. Melee attack");
            System.out.println("2. Ranged attack");
            System.out.println("3. Magic attack");
            System.out.println("4. Defend");
            System.out.println("5. Heal");

            int playerAction = scanner.nextInt();
            switch (playerAction) {
                case 1:
                    System.out.println("You use melee attack!");
                    player.setStrategy(new MeleeStrategy());
                    new AttackAction().executeAction(player, opponent);
                    break;
                case 2:
                    System.out.println("You use ranged attack!");
                    player.setStrategy(new RangedStrategy());
                    new AttackAction().executeAction(player, opponent);
                    break;
                case 3:
                    System.out.println("You use magic!");
                    player.setStrategy(new MagicStrategy());
                    if (random.nextBoolean()) {
                        new AttackAction().executeAction(player, opponent);
                    } else {
                        System.out.println("Magic attack missed!");
                    }
                    break;
                case 4:
                    System.out.println("You defend!");
                    new DefendAction().executeAction(player, null);
                    break;
                case 5:
                    System.out.println("You heal!");
                    new HealAction().executeAction(player, null);
                    break;
                default:
                    System.out.println("Invalid choice! Turn skipped.");
                    break;
            }

            if (opponent.getHealth() <= 0) {
                System.out.println("Opponent defeated! You won!");
                break;
            }

            System.out.println("Player Health: " + player.getHealth());
            System.out.println("Opponent Health: " + opponent.getHealth());
            System.out.println();
        }

        scanner.close();
    }
}
