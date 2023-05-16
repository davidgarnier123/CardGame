package org.example;
import org.example.Game;
import org.example.Card;
import org.example.Player;
import org.example.ConsoleToFileLogger;
import org.example.Fold;

import java.util.List;

import static org.example.Game.*;


public class Main {
    public static void main(String[] args) {

        ConsoleToFileLogger.initialize();

        List<Card> cards = generateCards();

        // TEST
        assert cards.size() == 52 : "Le jeu de cartes ne contient pas 52 cartes";

        // INITIAL CARDS
        for (Card card : cards) {
            System.out.print(card + " / ");
        }
        System.out.println(cards.size());

        List<Player> players = generatePlayers(cards, 4);

        startGame(players);

        ConsoleToFileLogger.close();
    }
}