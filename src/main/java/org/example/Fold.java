package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Fold {

    public Fold (List<Card> cards, List<Player> players) {
        int maxCard = -1;
        Player winner;
        for (Card card : cards) {
            int index = card.value.ordinal();
            if (index > maxCard) {
                maxCard = index;
            }
        }

        List<Integer> indexes = findIndexesOfValue(cards, maxCard);

        if (indexes.size() > 1) {
            Random random = new Random();
            int randomWinner = random.nextInt(indexes.size());
            winner = players.get(indexes.get(randomWinner));
        } else {
            winner = players.get(indexes.get(0));
        }
        winner.addCards(cards);
    }

    public static List<Integer> findIndexesOfValue(List<Card> cards, int value) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).value.ordinal() == value) {
                indexes.add(i);
            }
        }

        return indexes;
    }
}
