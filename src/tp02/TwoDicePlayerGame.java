package tp02;

import java.util.Scanner;

class TwoDicePlayerGame {
    //Attributes
    DicePlayer playerOne;
    DicePlayer playerTwo;

    //Constructors
    TwoDicePlayerGame(DicePlayer p1, DicePlayer p2) {
        this.playerOne = p1;
        this.playerTwo = p2;
    }

    //Methods
    DicePlayer winner() {
        if (playerOne.compareNbDiceRolls(playerTwo) > 0) {
            return playerOne;
        } else if (playerOne.compareNbDiceRolls(playerTwo) < 0) {
            return playerTwo;
        } else {
            if (playerOne.compareTotalValue(playerTwo) > 0) {
                return playerOne;
            } else if (playerOne.compareTotalValue(playerTwo) < 0) {
                return playerTwo;
            } else {
                return new DicePlayer(null);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOne, nameTwo;

        System.out.print("Enter player One name: ");
        nameOne = scanner.nextLine();
        System.out.println('\n');

        System.out.print("Enter player One name: ");
        nameTwo = scanner.nextLine();
        System.out.println('\n');

        TwoDicePlayerGame game = new TwoDicePlayerGame(new DicePlayer(nameOne), new DicePlayer(nameTwo));

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
