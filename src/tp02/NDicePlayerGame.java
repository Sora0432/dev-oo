package tp02;

import java.util.Scanner;
import java.util.ArrayList;



class NDicePlayerGame {
    //Attributes
    DicePlayer[] playerList;
    final int OBJECTIVE = 20;

    //Constructors
    NDicePlayerGame(int nbPlayer) {
        this.playerList = new DicePlayer[nbPlayer];
        for (int i = 0; i < playerList.length; i++) {
            playerList[i] = new DicePlayer("" + i);
        }
    }

    DicePlayer[] winner() {
        ArrayList<DicePlayer> winnersTemp = new ArrayList<DicePlayer>();
        int minNbRoll = this.playerList[0].nbDiceRolls;
        winnersTemp.add(this.playerList[0]);
        for (int i = 1; i < this.playerList.length; i++) {
            if (this.playerList[i].nbDiceRolls < minNbRoll) {
                winnersTemp.clear();
                winnersTemp.add(this.playerList[i]);
            } else {
                winnersTemp.add(this.playerList[i]);
            }
        }
        DicePlayer[] winners = new DicePlayer[winnersTemp.size()];
        for (int i = 0; i < winners.length; i++) {
            winners[i] = winnersTemp.get(i);
        }
        return winners;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players: ");
        NDicePlayerGame game = new NDicePlayerGame(scanner.nextInt());

        System.out.print("Enter the number of sides for the dices: ");
        Dice dice = new Dice(scanner.nextInt());
        System.out.println('\n');

        System.out.println("Objective: 20 points.\n");

        String userInput;

        while (game.playerOne.totalValue < 20 && game.playerTwo.totalValue < 20) {
            System.out.println(game.playerOne.name + ", do you want to roll the dice? (yes/no)");

            do {
                userInput = scanner.nextLine().toLowerCase();
            } while (!userInput.equals("yes") && !userInput.equals("no"));

            if (userInput.equals("yes")) {
                game.playerOne.play(dice);
                System.out.println("Here is your current stats: " + game.playerOne);
                System.out.println('\n');
            } else if (userInput.equals("no")) {
                System.out.println("Merci d'avoir jouer.");
                break;
            }

            System.out.println(game.playerTwo.name + ", do you want to roll the dice? (yes/no)");

            do {
                userInput = scanner.nextLine().toLowerCase();
            } while (!userInput.equals("yes") && !userInput.equals("no"));

            if (userInput.equals("yes")) {
                game.playerTwo.play(dice);
                System.out.println("Here is your current stats: " + game.playerTwo);
            } else if (userInput.equals("no")) {
                System.out.println("Merci d'avoir jouer.");
                break;
            }
        }

        if (game.playerOne.totalValue >= 20 || game.playerTwo.totalValue >= 20) {
            System.out.println("Le gagnant est " + game.winner());
        }

        scanner.close();
    }
}
