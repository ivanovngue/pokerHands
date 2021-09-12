package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Card;
import com.iv.kata.pk.domain.dto.Player;
import org.apache.commons.lang3.ArrayUtils;

/**
 * This class is used to compare hands of 5 cards with same ranking
 *
 * @author Ivan
 */
public class Compare {
    Ranking ranking = new Ranking();

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

    private Card getHighCard(Card[] hand) {
        Card maxValueHand = new Card('2', ' ');
        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getRank() > maxValueHand.getRank()) {
                maxValueHand = hand[i];
            }
        }
        return maxValueHand;
    }
}