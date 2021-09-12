package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test Ranking
 *
 * @author Ivan
 */
public class RankingTest {

    Ranking ranking = new Ranking();

    @Test
    void testThatHand_isPair() {
        Card[] hand = new Card[5];
        hand[0] = new Card('2', 'H');
        hand[1] = new Card('2', 'D');
        hand[2] = new Card('5', 'S');
        hand[3] = new Card('9', 'C');
        hand[4] = new Card('K', 'D');
        Assertions.assertTrue(ranking.isPair(hand));
    }

    @Test
    void testThatHand_isThreeOfAKind() {
        Card[] hand = new Card[5];
        hand[0] = new Card('2', 'H');
        hand[1] = new Card('2', 'D');
        hand[2] = new Card('2', 'S');
        hand[3] = new Card('5', 'C');
        hand[4] = new Card('K', 'D');
        Assertions.assertTrue(ranking.isThreeOfAKind(hand));
    }

    @Test
    void testThatHand_isStraight() {
        Card[] hand = new Card[5];
        hand[0] = new Card('5', 'H');
        hand[1] = new Card('6', 'D');
        hand[2] = new Card('7', 'S');
        hand[3] = new Card('8', 'C');
        hand[4] = new Card('9', 'D');
        Assertions.assertTrue(ranking.isStraight(hand));
    }

    @Test
    void testThatHand_isFlush() {
        Card[] hand = new Card[5];
        hand[0] = new Card('9', 'D');
        hand[1] = new Card('8', 'D');
        hand[2] = new Card('2', 'D');
        hand[3] = new Card('6', 'D');
        hand[4] = new Card('3', 'D');
        Assertions.assertTrue(ranking.isFlush(hand));
    }
}