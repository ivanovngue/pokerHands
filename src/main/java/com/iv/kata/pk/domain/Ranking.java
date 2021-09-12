package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Player;
import com.iv.kata.pk.domain.util.HandRankEnum;

/**
 * This class is used to determine ranking of a hand of 5 cards
 *
 * @author Ivan
 */
public class Ranking {

    protected HandRankEnum getPlayerRanking(Player player) {
        return HandRankEnum.HIGH_CARD;
    }
}