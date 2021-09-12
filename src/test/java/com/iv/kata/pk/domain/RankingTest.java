package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Card;
import com.iv.kata.pk.domain.dto.Player;
import com.iv.kata.pk.domain.util.HandRankEnum;
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

    @Test
    void testThatHand_isFullHouse() {
        Card[] hand = new Card[5];
        hand[0] = new Card('9', 'H');
        hand[1] = new Card('9', 'D');
        hand[2] = new Card('9', 'S');
        hand[3] = new Card('3', 'C');
        hand[4] = new Card('3', 'D');
        Assertions.assertTrue(ranking.isFullHouse(hand));
    }

    @Test
    void testThatHand_isFourOfAKind() {
        Card[] hand = new Card[5];
        hand[0] = new Card('2', 'H');
        hand[1] = new Card('2', 'D');
        hand[2] = new Card('2', 'S');
        hand[3] = new Card('2', 'C');
        hand[4] = new Card('K', 'D');
        Assertions.assertTrue(ranking.isFourOfAKind(hand));
    }

    @Test
    void testThatGetPlayerRanking_returnCorrectWinner() {

        Player playerIsPair = new Player("2H 2D 5S 9C KD", "White");
        Assertions.assertEquals(HandRankEnum.PAIR, ranking.getPlayerRanking(playerIsPair));

        Player playerIsThreeOfAKind = new Player("2H 2D 2S 5C KD", "White");
        Assertions.assertEquals(HandRankEnum.THREE_OF_A_KIND, ranking.getPlayerRanking(playerIsThreeOfAKind));

        Player playerIsStraight = new Player("5H 6D 7S 8C 9D", "White");
        Assertions.assertEquals(HandRankEnum.STRAIGHT, ranking.getPlayerRanking(playerIsStraight));

        Player playerIsFlush = new Player("2D 4D 5D 8D KD", "White");
        Assertions.assertEquals(HandRankEnum.FLUSH, ranking.getPlayerRanking(playerIsFlush));

        Player playerIsFullHouse = new Player("2H 2D 2S KC KD", "White");
        Assertions.assertEquals(HandRankEnum.FULL_HOUSE, ranking.getPlayerRanking(playerIsFullHouse));

        Player playerIsFourOfAKind = new Player("2H 2D 2S 2C KD", "White");
        Assertions.assertEquals(HandRankEnum.FOUR_OF_A_KIND, ranking.getPlayerRanking(playerIsFourOfAKind));
    }
}