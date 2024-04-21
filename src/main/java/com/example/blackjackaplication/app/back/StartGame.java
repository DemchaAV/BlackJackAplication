package com.example.blackjackaplication.app.back;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartGame {

    public static NewGame registration(int players) {
        NewGame newGame = new NewGame(players);
        for (int i = 1; i < newGame.getAmountPlayers(); i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type Name of player № " + i);
            String name = scanner.nextLine();
            newGame.getPlayer(i).setName(name);
            System.out.println("Type your wallet balance ");
            int wallet = numScanner();
            newGame.getPlayer(i).setBalance(wallet);
        }
        return newGame;
    }

    public static int numScanner() {
        int number = 0;
        boolean validInput = false;
        Scanner in = new Scanner(System.in);

        while (!validInput) {
            try {
                number = in.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please try again, numbers only! ");
                in.nextLine();
            }
        }

        return number;
    }


    public static void inProgress(NewGame newGame, boolean gameInProcess) {
        while (gameInProcess) {
            System.out.println();
            System.out.println();
            System.out.println("Game has started!");
            newGame.printInfoPlayers();
            newGame.printInfoCardPool();
            newGame.printInfoDealer(1);
            gameInProcess = false;
        }

    }

    static void gameOver() {
        System.out.println("Game over!");
    }


}
