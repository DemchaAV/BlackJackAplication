package com.example.blackjackaplication.back;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    private  final int amountDeck = 52;
    private  ArrayList<Integer> shuffledDeck = new ArrayList<>(amountDeck);
    private HashMap<Integer, String> deckUrl= new HashMap<>(amountDeck+2);

    //LoadingCard
    {
        deckUrl.put(1, "deck/Hearts/2.png");
        deckUrl.put(2, "deck/Hearts/3.png");
        deckUrl.put(3, "deck/Hearts/4.png");
        deckUrl.put(4, "deck/Hearts/5.png");
        deckUrl.put(5, "deck/Hearts/6.png");
        deckUrl.put(6, "deck/Hearts/7.png");
        deckUrl.put(7, "deck/Hearts/8.png");
        deckUrl.put(8, "deck/Hearts/9.png");
        deckUrl.put(9, "deck/Hearts/10.png");
        deckUrl.put(10, "deck/Hearts/J.png");
        deckUrl.put(11, "deck/Hearts/Q.png");
        deckUrl.put(12, "deck/Hearts/K.png");
        deckUrl.put(13, "deck/Hearts/A.png");

        deckUrl.put(14, "deck/Diamonds/2.png");
        deckUrl.put(15, "deck/Diamonds/3.png");
        deckUrl.put(16, "deck/Diamonds/4.png");
        deckUrl.put(17, "deck/Diamonds/5.png");
        deckUrl.put(18, "deck/Diamonds/6.png");
        deckUrl.put(19, "deck/Diamonds/7.png");
        deckUrl.put(20, "deck/Diamonds/8.png");
        deckUrl.put(21, "deck/Diamonds/9.png");
        deckUrl.put(22, "deck/Diamonds/10.png");
        deckUrl.put(23, "deck/Diamonds/J.png");
        deckUrl.put(24, "deck/Diamonds/Q.png");
        deckUrl.put(25, "deck/Diamonds/K.png");
        deckUrl.put(26, "deck/Diamonds/A.png");

        deckUrl.put(27, "deck/Clubs/2.png");
        deckUrl.put(28, "deck/Clubs/3.png");
        deckUrl.put(29, "deck/Clubs/4.png");
        deckUrl.put(30, "deck/Clubs/5.png");
        deckUrl.put(31, "deck/Clubs/6.png");
        deckUrl.put(32, "deck/Clubs/7.png");
        deckUrl.put(33, "deck/Clubs/8.png");
        deckUrl.put(34, "deck/Clubs/9.png");
        deckUrl.put(35, "deck/Clubs/10.png");
        deckUrl.put(36, "deck/Clubs/J.png");
        deckUrl.put(37, "deck/Clubs/Q.png");
        deckUrl.put(38, "deck/Clubs/K.png");
        deckUrl.put(39, "deck/Clubs/A.png");

        deckUrl.put(40, "deck/Spades/2.png");
        deckUrl.put(41, "deck/Spades/3.png");
        deckUrl.put(42, "deck/Spades/4.png");
        deckUrl.put(43, "deck/Spades/5.png");
        deckUrl.put(44, "deck/Spades/6.png");
        deckUrl.put(45, "deck/Spades/7.png");
        deckUrl.put(46, "deck/Spades/8.png");
        deckUrl.put(47, "deck/Spades/9.png");
        deckUrl.put(48, "deck/Spades/10.png");
        deckUrl.put(49, "deck/Spades/J.png");
        deckUrl.put(50, "deck/Spades/Q.png");
        deckUrl.put(51, "deck/Spades/K.png");
        deckUrl.put(52, "deck/Spades/A.png");

        deckUrl.put(53, "deck/Jokers/Joker_1.png");
        deckUrl.put(54, "deck/Jokers/Joker_2.png");
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
    public  void newShuffle(){
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