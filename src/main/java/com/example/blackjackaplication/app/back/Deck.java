package com.example.blackjackaplication.app.back;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    private final int amountDeck = 52;
    private ArrayList<Integer> shuffledDeck = new ArrayList<>(amountDeck);
    private final HashMap<Integer, String> deckUrl = new HashMap<>(amountDeck + 2);
    //LoadingCard


    {
        String cardPath = "img/deck/";
        String hearts = cardPath + "Hearts/";
        String diamonds = cardPath + "Diamonds/";
        String clubs = cardPath + "Clubs/";
        String spades = cardPath + "Spades/";
        String jokers = cardPath + "Jokers/";
        String format = ".png";

        String currentPath;
        for (int i = 0; i <= 3; i++) {
            currentPath = switch (i) {
                case 0 -> cardPath + hearts;
                case 1 -> cardPath + diamonds;
                case 2 -> cardPath + clubs;
                case 3 -> cardPath + spades;
                default -> throw new IllegalStateException("Unexpected value: " + i);
            };
            for (int j = 1; j <= 13; j++) {
                deckUrl.put(i * 10 + j, currentPath + (j + 1) + format);
            }
            deckUrl.put(53, "img/deck/Jokers/Joker_1.png");
            deckUrl.put(54, "img/deck/Jokers/Joker_2.png");

        }
        deckUrl.put(53, cardPath + jokers + "Joker_1.png");
        deckUrl.put(54, cardPath + jokers + "Joker_2.png");
    }

    public Deck() {
        shuffle();

    }

    void getDeckView() {
        var show = shuffledDeck;
        System.out.println(show);
        show.sort((x, y) -> x - y);
        System.out.println(show);
    }


    public int getCard() {
        if (!shuffledDeck.isEmpty()) {
            int returnCard = shuffledDeck.getFirst();
            shuffledDeck.removeFirst();
            return returnCard;
        }
        return 0;
    }

    public String cardView(int num) {
        if (num >= 1 && num <= 52) {
            return deckUrl.get(num);
        } else {
            return "img/deck/Back Covers/Peter River.png";
        }
    }


    private void shuffle() {
        for (int i = 0; i < amountDeck; i++) {
            int randomNum;
            boolean check = true;
            while (check) {
                randomNum = ((int) (Math.random() * amountDeck + 1));
                if (randomNum > 0 && !shuffledDeck.contains(randomNum)) {
                    shuffledDeck.add(randomNum);
                    check = false;
                }

            }
        }
    }

    public void newShuffle() {
        ArrayList<Integer> newShuffle = new ArrayList<>();
        for (int i = 0; i < amountDeck; i++) {
            int randomNum;
            boolean check = true;
            while (check) {
                randomNum = ((int) (Math.random() * amountDeck + 1));
                if (randomNum > 0 && !newShuffle.contains(randomNum)) {
                    newShuffle.add(randomNum);
                    check = false;
                }

            }
        }

        shuffledDeck = newShuffle;
    }


    public static void main(String[] args) {
        Deck deck = new Deck();

    }
}