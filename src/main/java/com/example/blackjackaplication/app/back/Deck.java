package com.example.blackjackaplication.app.back;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    private final int amountDeck = 52;
    private ArrayList<Integer> shuffledDeck = new ArrayList<>(amountDeck);
    private HashMap<Integer, String> deckUrl = new HashMap<>(amountDeck + 2);

    //LoadingCard
    {
        deckUrl.put(1, "img/deck/Hearts/2.png");
        deckUrl.put(2, "img/deck/Hearts/3.png");
        deckUrl.put(3, "img/deck/Hearts/4.png");
        deckUrl.put(4, "img/deck/Hearts/5.png");
        deckUrl.put(5, "img/deck/Hearts/6.png");
        deckUrl.put(6, "img/deck/Hearts/7.png");
        deckUrl.put(7, "img/deck/Hearts/8.png");
        deckUrl.put(8, "img/deck/Hearts/9.png");
        deckUrl.put(9, "img/deck/Hearts/10.png");
        deckUrl.put(10, "img/deck/Hearts/J.png");
        deckUrl.put(11, "img/deck/Hearts/Q.png");
        deckUrl.put(12, "img/deck/Hearts/K.png");
        deckUrl.put(13, "img/deck/Hearts/A.png");

        deckUrl.put(14, "img/deck/Diamonds/2.png");
        deckUrl.put(15, "img/deck/Diamonds/3.png");
        deckUrl.put(16, "img/deck/Diamonds/4.png");
        deckUrl.put(17, "img/deck/Diamonds/5.png");
        deckUrl.put(18, "img/deck/Diamonds/6.png");
        deckUrl.put(19, "img/deck/Diamonds/7.png");
        deckUrl.put(20, "img/deck/Diamonds/8.png");
        deckUrl.put(21, "img/deck/Diamonds/9.png");
        deckUrl.put(22, "img/deck/Diamonds/10.png");
        deckUrl.put(23, "img/deck/Diamonds/J.png");
        deckUrl.put(24, "img/deck/Diamonds/Q.png");
        deckUrl.put(25, "img/deck/Diamonds/K.png");
        deckUrl.put(26, "img/deck/Diamonds/A.png");

        deckUrl.put(27, "img/deck/Clubs/2.png");
        deckUrl.put(28, "img/deck/Clubs/3.png");
        deckUrl.put(29, "img/deck/Clubs/4.png");
        deckUrl.put(30, "img/deck/Clubs/5.png");
        deckUrl.put(31, "img/deck/Clubs/6.png");
        deckUrl.put(32, "img/deck/Clubs/7.png");
        deckUrl.put(33, "img/deck/Clubs/8.png");
        deckUrl.put(34, "img/deck/Clubs/9.png");
        deckUrl.put(35, "img/deck/Clubs/10.png");
        deckUrl.put(36, "img/deck/Clubs/J.png");
        deckUrl.put(37, "img/deck/Clubs/Q.png");
        deckUrl.put(38, "img/deck/Clubs/K.png");
        deckUrl.put(39, "img/deck/Clubs/A.png");

        deckUrl.put(40, "img/deck/Spades/2.png");
        deckUrl.put(41, "img/deck/Spades/3.png");
        deckUrl.put(42, "img/deck/Spades/4.png");
        deckUrl.put(43, "img/deck/Spades/5.png");
        deckUrl.put(44, "img/deck/Spades/6.png");
        deckUrl.put(45, "img/deck/Spades/7.png");
        deckUrl.put(46, "img/deck/Spades/8.png");
        deckUrl.put(47, "img/deck/Spades/9.png");
        deckUrl.put(48, "img/deck/Spades/10.png");
        deckUrl.put(49, "img/deck/Spades/J.png");
        deckUrl.put(50, "img/deck/Spades/Q.png");
        deckUrl.put(51, "img/deck/Spades/K.png");
        deckUrl.put(52, "img/deck/Spades/A.png");

        deckUrl.put(53, "img/deck/Jokers/Joker_1.png");
        deckUrl.put(54, "img/deck/Jokers/Joker_2.png");
    }

    public Deck() {
        shufffle();

    }

    void getDeckView() {
        var show = shuffledDeck;
        System.out.println(show);
        show.sort((x, y) -> x - y);
        System.out.println(show);
    }


    public int getCard() {
        if (shuffledDeck.size() > 0) {
            int returnCard = shuffledDeck.get(0);
            shuffledDeck.remove(0);
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


    private void shufffle() {
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