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
        int minNbRoll = -1;
        for (int i = 0; i < this.playerList.length; i++) {
            if (this.playerList[i].nbDiceRolls >= this.OBJECTIVE && this.playerList[i].nbDiceRolls < minNbRoll) {
                winnersTemp.clear();
                winnersTemp.add(this.playerList[i]);
            } else if (this.playerList[i].nbDiceRolls >= this.OBJECTIVE) {
                winnersTemp.add(this.playerList[i]);
            }
        }
        DicePlayer[] winners = new DicePlayer[winnersTemp.size()];
        for (int i = 0; i < winners.length; i++) {
            winners[i] = winnersTemp.get(i);
        }
        return winners;
    }

    boolean isFinished() {
        for (int i = 0; i < this.playerList.length; i++) {
            if (this.playerList[i].totalValue >= this.OBJECTIVE) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players: ");
        NDicePlayerGame game = new NDicePlayerGame(scanner.nextInt());

        System.out.print("Enter the number of sides for the dices: ");
        Dice dice = new Dice(scanner.nextInt());
        System.out.println('\n');

        System.out.println("Objective: " + game.OBJECTIVE + " points.\n");

        String userInput;

        while (!game.isFinished()) {
            for (int i = 0; i < game.playerList.length; i++) {
                System.out.println(game.playerList[i].name + ", do you want to roll the dice? (yes/no)");

                do {
                    userInput = scanner.nextLine().toLowerCase();
                } while (!userInput.equals("yes") && !userInput.equals("no"));

                if (userInput.equals("yes")) {
                    game.playerList[i].play(dice);
                    System.out.println("Here is your current stats: " + game.playerList[i]);
                    System.out.println('\n');
                } else if (userInput.equals("no")) {
                    System.out.println("Merci d'avoir jouer.");
                    break;
                }
            }
        }

        if (game.isFinished()) {
            System.out.println("The game is finished.");
            System.out.println("The winner(s) is/are: ");
            DicePlayer[] winners = game.winner();
            for (int i = 0; i < winners.length; i++) {
                System.out.println(winners[i].name);
            }
        }

        scanner.close();
    }
}
