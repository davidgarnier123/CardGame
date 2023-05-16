package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();

        for (Card.Sign sign : Card.Sign.values()) {
            for (Card.Value value : Card.Value.values()) {
                Card carte = new Card(value, sign);
                cards.add(carte);
            }
        }

        return cards;
    }

    public static List<Player> generatePlayers(List<Card> cards, Integer playersNumber) {
        List<Player> players = new ArrayList<>();
        Integer numbersOfCardByPlayers = cards.size() / playersNumber;
        System.out.println("nombre de cartes par joueurs : " + String.valueOf(numbersOfCardByPlayers));

        for (int i = 1; i < playersNumber + 1; i++) {
            List<Card> cardsOfPlayer = new ArrayList<>();



            for (int j = 0; j < numbersOfCardByPlayers ; j++ ) {
                Random random = new Random();

                int randomIndex = random.nextInt(cards.size());
                // get random card
                Card cardToAdd = cards.get(randomIndex);
                // add to player's cards
                cardsOfPlayer.add(cardToAdd);
                // remove from global cards list
                cards.remove(cardToAdd);
            }
            Player player = new Player("Player " + String.valueOf(i), cardsOfPlayer);

            System.out.println(player.name);
            System.out.println(player.cards);

            // TEST
            assert player.cards.size() == numbersOfCardByPlayers : "Le jeu de " + player.name + " nest pas complet..";

            players.add(player);
        }

        return players;
    }

    public static List<Player> getActivePlayers(List<Player> players) {
        List<Player> activePlayers = new ArrayList<>();

        for (Player player : players) {
            if (!player.gameOver) {
                activePlayers.add(player);
            }
        }

        return activePlayers;
    }

    public static void startGame (List<Player> players) {
        System.out.println("");
        System.out.println("******** GAME START **********");
        System.out.println("");

        int foldCounter = 0;
        List<Player> activePlayers = getActivePlayers(players);

        while (activePlayers.size() > 1) {
            foldCounter++;
            System.out.println("         Pli n°" + foldCounter);
            System.out.println("******** DEBUT PLI ************");

            List<Card> currentFoldCards = new ArrayList<Card>();

            for (Player player : activePlayers) {
                String name = player.name;
                Card randomCard = player.getRandomCard();
                System.out.println(name + " (" + String.valueOf(player.cards.size() + 1) + " cartes restantes) -> " + randomCard);
                currentFoldCards.add(randomCard);
            }


            new Fold(currentFoldCards, activePlayers);

            for (Player player : activePlayers) {
                player.checkGameOver();
            }
            activePlayers = getActivePlayers(players);

            System.out.println("********* FIN PLI *************");
            System.out.println("                             ");
        }

        System.out.println("Jeu terminé !!");
        System.out.println("");
        System.out.println(activePlayers.get(0).name + " a gagné (" + activePlayers.get(0).cards.size() + " cartes) en " + foldCounter + " plis !");
    }
}
