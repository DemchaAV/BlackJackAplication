package com.example.blackjackaplication.app.back;

import java.util.Scanner;

public class Run {
    public void run() {
        boolean game = true;
        String key;
        boolean gameInProcess = false;
        NewGame newGame = new NewGame();
        System.out.println("WELCOME TO THE GAME");
        while (game) {
            System.out.println("Type \"s\" to start the  game,  \"q\" to quit");
            Scanner in = new Scanner(System.in);
            key = in.nextLine().toLowerCase();
            switch (key) {
                case "s" -> {
                    System.out.println("Type the number of Players:");
                    int players = 0;
                    players = StartGame.numScanner();
                    newGame = StartGame.registration(players);
                    gameInProcess = true;
                    game = false;
                }
                case "q" -> game = false;
            }

        }
        if (gameInProcess) {
            System.out.println("Game has started!");
            for (int i = 1; i < newGame.getAmountPlayers(); i++) {
                System.out.println("--------------------");
                System.out.println(newGame.getPlayer(i).toString() + " ");
                System.out.println("--------------------");
            }
        }
        System.out.print("Type \"d\" to deal the cards \"q\"  to quit: ");
        while (gameInProcess) {
            Scanner scanner = new Scanner(System.in);
            key = scanner.nextLine().toLowerCase();
            switch (key) {
                case "d" -> {
                    newGame.firstDropCard();
                    StartGame.inProgress(newGame, gameInProcess);
                }
                case "q" -> {
                    gameInProcess = false;
                    StartGame.gameOver();
                }
            }
            newGame.doBets();
            newGame.print(1);
            if (newGame.rules.whoBlackJack() != 500) {
                gameInProcess = newGame.blackJack();
            } else {
                gameInProcess = newGame.next(2);
                System.out.println(newGame.getAmoundScore());
                newGame.wonGame();
            }
            gameInProcess = false;
            System.out.println("Type \"c\" to continue the game or \"q\" to quit: ");
            key = scanner.nextLine().toLowerCase();
            switch (key) {
                case "c" -> {
                    gameInProcess = true;
                    newGame.deck.newShuffle();
                    newGame.newRound();
                    System.out.print("Type \"d\" to deal the cards \"q\"  to quit: ");
                }
                case "q" -> gameInProcess = false;

            }


        }
    }
}
