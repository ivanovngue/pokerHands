package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Card;
import com.iv.kata.pk.domain.dto.Player;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to compare hands of 5 cards with same ranking
 *
 * @author Ivan
 */
public class Compare {

    protected Player comparePlayerWithHigh(Player player1, Player player2) {
        Player playerToReturn = null;
        if (player1.getHand().length > 1 && player2.getHand().length > 1) {
            Card maxValueHand1 = getHighCard(player1.getHand());
            Card maxValueHand2 = getHighCard(player2.getHand());
            if (maxValueHand1.getRank() == maxValueHand2.getRank()) {
                Card[] hand1 = ArrayUtils.remove(player1.getHand(), ArrayUtils.indexOf(player1.getHand(), maxValueHand1));
                Card[] hand2 = ArrayUtils.remove(player2.getHand(), ArrayUtils.indexOf(player2.getHand(), maxValueHand2));
                return comparePlayerWithHigh(new Player(hand1, player1.getName()), new Player(hand2, player2.getName()));
            } else if (maxValueHand1.getRank() > maxValueHand2.getRank()) {
                playerToReturn = player1;
            } else {
                playerToReturn = player2;
            }
        }
        if (player1.getHand().length == 1 && player2.getHand().length == 1) {
            if (player1.getHand()[0].getRank() > player2.getHand()[0].getRank()) {
                playerToReturn = player1;
            } else if (player1.getHand()[0].getRank() < player2.getHand()[0].getRank()) {
                playerToReturn = player2;
            }
        }
        return playerToReturn;
    }

    protected Player comparePlayerWithPair(Player player1, Player player2) {
        Player playerToReturn = null;
        Card card1Pair = getCardsOnPair(player1);
        Card card2Pair = getCardsOnPair(player2);
        if (card1Pair != null && card2Pair != null) {
            if (card1Pair.getRank() == card2Pair.getRank()) {
                Card[] hand1WithoutPair = getHandWithoutPair(player1, card1Pair);
                Card[] hand2WithoutPair = getHandWithoutPair(player2, card2Pair);
                if (getLowCard(hand1WithoutPair).getRank() > getLowCard(hand2WithoutPair).getRank()) {
                    playerToReturn = player2;
                }
                if (getLowCard(hand1WithoutPair).getRank() < getLowCard(hand2WithoutPair).getRank()) {
                    playerToReturn = player1;
                }
            } else if (card1Pair.getRank() > card2Pair.getRank()) {
                playerToReturn = player1;
            } else {
                playerToReturn = player2;
            }
        }
        return playerToReturn;
    }

    protected Player comparePlayerWithThreeOfAKind(Player player1, Player player2) {
        Player playerToReturn = null;
        Card card1ThreeOfAKind = getCardsOnThreeOfAKind(player1);
        Card card2ThreeOfAKind = getCardsOnThreeOfAKind(player2);
        if (card1ThreeOfAKind != null && card2ThreeOfAKind != null) {
            if (card1ThreeOfAKind.getRank() > card2ThreeOfAKind.getRank()) {
                playerToReturn = player1;
            }
            if (card1ThreeOfAKind.getRank() < card2ThreeOfAKind.getRank()) {
                playerToReturn = player2;
            }
        }
        return playerToReturn;
    }

    protected Player comparePlayerWithStraight(Player player1, Player player2) {
        Player playerToReturn = null;
        Card card1Straight = getHighCard(player1.getHand());
        Card card2Straight = getHighCard(player2.getHand());
        if (card1Straight != null && card2Straight != null) {
            if (card1Straight.getRank() > card2Straight.getRank()) {
                playerToReturn = player1;
            }
            if (card1Straight.getRank() < card2Straight.getRank()) {
                playerToReturn = player2;
            }
        }
        return playerToReturn;
    }

    private Card getHighCard(Card[] hand) {
        Card maxValueHand = new Card('2', ' ');
        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getRank() > maxValueHand.getRank()) {
                maxValueHand = hand[i];
            }
        }
        return maxValueHand;
    }

    private Card getCardsOnPair(Player player) {
        Card[] hand = player.getHand();
        Card cardOnPair = null;
        int occurrence = 0;
        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.length; j++) {
                if (hand[i].getRank() == hand[j].getRank()) {
                    occurrence++;
                }
            }
            if (occurrence == 2) {
                cardOnPair = hand[i];
                break;
            }
            occurrence = 0;
        }
        return cardOnPair;
    }

    private Card[] getHandWithoutPair(Player player, Card cardPair) {
        List<Card> listCardsWithoutPair = new ArrayList<>();
        Card[] hand = player.getHand();
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getRank() != cardPair.getRank()) {
                listCardsWithoutPair.add(hand[i]);
            }
        }
        Card[] handWithoutPair = new Card[listCardsWithoutPair.size()];
        listCardsWithoutPair.toArray(handWithoutPair);
        return handWithoutPair;
    }

    private Card getLowCard(Card[] hand) {
        Card minValueHand = new Card('A', ' ');
        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getRank() < minValueHand.getRank()) {
                minValueHand = hand[i];
            }
        }
        return minValueHand;
    }

    private Card getCardsOnThreeOfAKind(Player player) {
        Card[] hand = player.getHand();
        if (hand[0].getRank() == hand[2].getRank()) {
            return hand[0];
        } else if (hand[1].getRank() == hand[3].getRank()) {
            return hand[1];
        } else if (hand[2].getRank() == hand[4].getRank()) {
            return hand[2];
        } else {
            return null;
        }
    }
}