package com.iv.kata.pk.domain;

import com.iv.kata.pk.infrastructure.RetrieveInputData;

import java.util.List;

/**
 * This class is used to select winner among black and white
 *
 * @author Ivan
 */
public class Winner {

    private RetrieveInputData retrieveInputData = new RetrieveInputData();


    public List<String> getWinner() {
        return findWinnerBetweenTwoPlayer(retrieveInputData.getGamesWithTwoPlayersFromTxtFile());
    }

    private List<String> findWinnerBetweenTwoPlayer(List<String> twoPlayers) {
        return null;
    }
}