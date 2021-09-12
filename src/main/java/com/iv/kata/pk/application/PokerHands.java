package com.iv.kata.pk.application;

import com.iv.kata.pk.domain.Winner;

/**
 * This is the main class
 *
 * @author Ivan
 */
public class PokerHands {
    private static Winner winner = new Winner();

    public static void main(String[] args) {
        winner.getWinner().stream().forEach(System.out::println);
    }
}