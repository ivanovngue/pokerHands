package com.iv.kata.pk.domain.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class is the enumeration of ranks
 *
 * @author Ivan
 */
@Getter
@AllArgsConstructor
public enum HandRankEnum {

    HIGH_CARD(0, "high card"),
    PAIR(1, "pair"),
    TWO_PAIR(2, "two pair"),
    THREE_OF_A_KIND(3, "three of a kind"),
    STRAIGHT(4, "straight"),
    FLUSH(5, "flush"),
    FULL_HOUSE(6, "full house"),
    FOUR_OF_A_KIND(7, "four of a kind"),
    STRAIGHT_FLUSH(8, "straight flush");

    private int rank;
    private String messageDetail;
}