package tp02;

import java.util.Scanner;

class OneDicePlayerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name: ");
        DicePlayer player = new DicePlayer(scanner.nextLine());
        System.out.println('\n');

        System.out.print("Enter the number of sides for the dices: ");
        Dice dice = new Dice(scanner.nextInt());
        System.out.println('\n');

        System.out.println("Objective: 20 points.\n");

        String userInput;

        while (player.totalValue < 20) {
            System.out.println("Do you want to roll the dice? (yes/no)");

            do {
                userInput = scanner.nextLine().toLowerCase();
            } while (!userInput.equals("yes") && !userInput.equals("no"));

            if (userInput.equals("yes")) {
                player.play(dice);
                System.out.println("Here is your current stats: " + player);
                System.out.println('\n');
            } else if (userInput.equals("no")) {
                System.out.println("Merci d'avoir jouer.");
                break;
            }
        }

        if (player.totalValue >= 20) {
            System.out.println("Le gagnant est " + player);
        }

        scanner.close();
    }
} 
