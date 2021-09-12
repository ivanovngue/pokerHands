package com.iv.kata.pk.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * This class represents the card
 *
 * @author Ivan
 */
@Getter
@ToString
@EqualsAndHashCode
public class Card implements Comparable<Card> {
    private int rank;
    private char value;
    private char suit;

    public Card(char value, char suit) {
        rank = calculationOfCardRank(value);
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card anotherCard) {
        if (getValue() < anotherCard.getValue()) return -1;
        else if (getValue() > anotherCard.getValue()) return 1;
        else return 0;
    }

    private int calculationOfCardRank(char value) {
        if ("TJQKA".contains(String.valueOf(value))) {
            if (value == 'T') {
                return 10;
            } else if (value == 'J') {
                return 11;
            } else if (value == 'Q') {
                return 12;
            } else if (value == 'K') {
                return 13;
            } else if (value == 'A') {
                return 14;
            } else {
                return 0;
            }
        } else {
            return Integer.valueOf(String.valueOf(value));
        }
    }
}