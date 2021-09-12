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

    protected Player comparePlayerWithFlush(Player player1, Player player2) {
        Player playerToReturn = null;
        Card[] Hand1 = player1.getHand();
        Card[] Hand2 = player2.getHand();
        if (ranking.isFlush(Hand1) && ranking.isFlush(Hand2)) {
            Card card1Flush = getHighCard(player1.getHand());
            Card card2Flush = getHighCard(player2.getHand());
            if (card1Flush != null && card2Flush != null) {
                if (card1Flush.getRank() > card2Flush.getRank()) {
                    playerToReturn = player1;
                }
                if (card1Flush.getRank() < card2Flush.getRank()) {
                    playerToReturn = player2;
                }
            }
        }
        return playerToReturn;
    }

    protected Player comparePlayerWithFullHouse(Player player1, Player player2) {
        Player playerToReturn = null;
        Card[] hand1 = player1.getHand();
        Card[] hand2 = player2.getHand();

        Card[] newHand1 = new Card[3];
        Card[] newHand2 = new Card[3];
        if (ranking.isThreeOfAKind(hand1) && ranking.isThreeOfAKind(hand2)) {
            if (hand1[3].getRank() == hand1[4].getRank() && hand2[3].getRank() == hand2[4].getRank()) {
                newHand1[0] = hand1[0];
                newHand1[1] = hand1[1];
                newHand1[2] = hand1[2];
                newHand2[0] = hand2[0];
                newHand2[1] = hand2[1];
                newHand2[2] = hand2[2];

                Card highCard1 = getHighCard(newHand1);
                Card highCard2 = getHighCard(newHand2);
                if (highCard1 != null && highCard2 != null) {
                    if (highCard1.getRank() > highCard2.getRank()) {
                        playerToReturn = player1;
                    }
                    if (highCard1.getRank() < highCard2.getRank()) {
                        playerToReturn = player2;
                    }
                }
            }
        }
        return playerToReturn;
    }

    protected Player comparePlayerWithFourOfAKind(Player player1, Player player2) {
        Player playerToReturn = null;
        Card card1FourOfAKind = getCardsOnFourOfAKind(player1);
        Card card2FourOfAKind = getCardsOnFourOfAKind(player2);
        if (card1FourOfAKind != null && card2FourOfAKind != null) {
            if (card1FourOfAKind.getRank() > card2FourOfAKind.getRank()) {
                playerToReturn = player1;
            }
            if (card1FourOfAKind.getRank() < card2FourOfAKind.getRank()) {
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

    private Card getCardsOnFourOfAKind(Player player) {
        Card[] hand = player.getHand();
        if (hand[0].getRank() == hand[3].getRank()) {
            return hand[0];
        } else if (hand[1].getRank() == hand[4].getRank()) {
            return hand[1];
        } else {
            return null;
        }
    }
}