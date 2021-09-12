package com.iv.kata.pk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * This class represents the player
 *
 * @author Ivan
 */
@Getter
@AllArgsConstructor
public class Player {
    private Card[] hand;
    private String name;

    public Player(String handString, String name) {
        String[] cards = handString.split(" ");
        hand = new Card[cards.length];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = new Card(cards[i].charAt(0), cards[i].charAt(1));
        }
        Arrays.sort(hand);
        this.name = name;
    }
}