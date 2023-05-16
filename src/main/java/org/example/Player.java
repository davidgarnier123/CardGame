package org.example;

import java.util.List;
import java.util.Random;


class Player {
    List<Card> cards;
    Boolean gameOver = false;
    String name;
    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public Card getRandomCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        Card randomCard = cards.get(randomIndex);
        cards.remove(randomCard);
        return randomCard;
    }

    public void checkGameOver() {
        if (this.cards.size() == 0) {
            this.gameOver = true;
            System.out.println("Event : " + this.name + " éliminé !");
        }
    }

    public void addCards(List<Card> cards) {
        System.out.println("Event : Ajout de carte à " + this.name);
        for (Card card : cards) {
            this.cards.add(card);
        }
    }
}
