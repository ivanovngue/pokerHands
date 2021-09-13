package com.iv.kata.pk.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * This class is used to test RetrieveInputData
 *
 * @author Ivan
 */
class RetrieveInputDataTest {

    private final RetrieveInputData retrieveInputData = new RetrieveInputData();

    @Test
    void testThatGetGamesWithTwoPlayersFromTxtFile_SelectCorrectRows() {
        List<String> rowsGameWithTwoPlayers = retrieveInputData.getGamesWithTwoPlayersFromTxtFile();
        Assertions.assertEquals(2, rowsGameWithTwoPlayers.size());
    }
}