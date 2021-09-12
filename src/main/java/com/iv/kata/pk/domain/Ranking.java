package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Card;
import com.iv.kata.pk.domain.dto.Player;
import com.iv.kata.pk.domain.util.HandRankEnum;

/**
 * This class is used to determine ranking of a hand of 5 cards
 *
 * @author Ivan
 */
public class Ranking {
    protected boolean isPair(Card[] hand) {
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();

        return ((card1 == card2 && card2 != card3) ||
                (card2 == card3 && card3 != card4 && card2 != card1) ||
                (card3 == card4 && card4 != card5 && card3 != card2) ||
                (card4 == card5 && card4 != card3));
    }

    protected boolean isThreeOfAKind(Card[] hand) {
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();

        return (card1 == card3 || card2 == card4 || card3 == card5);
    }

    protected boolean isStraight(Card[] hand) {
        return hand[4].getValue() - hand[0].getValue() == 4;
    }

    protected boolean isFlush(Card[] hand) {
        char suit1 = hand[0].getSuit();
        char suit2 = hand[1].getSuit();
        char suit3 = hand[2].getSuit();
        char suit4 = hand[3].getSuit();
        char suit5 = hand[4].getSuit();

        return (suit1 == suit2 && suit2 == suit3 && suit3 == suit4 && suit4 == suit5);
    }

    protected boolean isFullHouse(Card[] hand) {
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();

        return ((card1 == card2 && card2 != card3 && card3 == card5) || (card1 == card3 && card3 != card4 && card4 == card5));
    }

    protected boolean isFourOfAKind(Card[] hand) {
        return (hand[0].getValue() == hand[3].getValue() || hand[1].getValue() == hand[4].getValue());
    }

    protected boolean isStraightFlush(Card[] hand) {
        return false;
    }

    protected HandRankEnum getPlayerRanking(Player player) {
        Card[] hand = player.getHand();
        if (isFourOfAKind(hand)) return HandRankEnum.FOUR_OF_A_KIND;
        else if (isFullHouse(hand)) return HandRankEnum.FULL_HOUSE;
        else if (isFlush(hand)) return HandRankEnum.FLUSH;
        else if (isStraight(hand)) return HandRankEnum.STRAIGHT;
        else if (isThreeOfAKind(hand)) return HandRankEnum.THREE_OF_A_KIND;
        else if (isPair(hand)) return HandRankEnum.PAIR;
        else return HandRankEnum.HIGH_CARD;
    }
}