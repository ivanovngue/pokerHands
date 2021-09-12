package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test Compare
 *
 * @author Ivan
 */
class CompareTest {

    Compare compare = new Compare();

    @Test
    void testThatPlayer_comparePlayerWithHigh_returns_rightPlayer() {
        Player blackPlayer = new Player("2C 3H 4S 8C AH", "Black");
        Player whitePlayer = new Player("2H 3D 5S 9C KD", "White");
        Assertions.assertEquals(blackPlayer, compare.comparePlayerWithHigh(whitePlayer, blackPlayer));
    }

    @Test
    void testThatPlayer_comparePlayerWithDifferentPairs_returns_rightPlayer() {
        Player blackPlayer = new Player("2C 2H 4S 8C AH", "Black");
        Player whitePlayer = new Player("3H 3D 5S 9C KD", "White");
        Assertions.assertEquals(whitePlayer, compare.comparePlayerWithPair(whitePlayer, blackPlayer));
    }

    @Test
    void testThatPlayer_comparePlayerWithSamePairs_returns_rightPlayer() {
        Player blackPlayer = new Player("2C 2H 4S 8C AH", "Black");
        Player whitePlayer = new Player("2H 2D 5S 9C KD", "White");
        Assertions.assertEquals(blackPlayer, compare.comparePlayerWithPair(whitePlayer, blackPlayer));
    }

    @Test
    void testThatPlayer_comparePlayerWithDifferentThreeOfAKind_returns_rightPlayer() {
        Player blackPlayer = new Player("2C 2H 2S 8C AH", "Black");
        Player whitePlayer = new Player("3H 3D 3S 9C KD", "White");
        Assertions.assertEquals(whitePlayer, compare.comparePlayerWithThreeOfAKind(whitePlayer, blackPlayer));
    }

    @Test
    void testThatPlayer_comparePlayerWithSameThreeOfAKind_returns_rightPlayer() {
        Player blackPlayer = new Player("2C 2H 2S 8C AH", "Black");
        Player whitePlayer = new Player("2H 2D 2S 9C KD", "White");
        Assertions.assertNull(compare.comparePlayerWithThreeOfAKind(whitePlayer, blackPlayer));
    }
}