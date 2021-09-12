package com.iv.kata.pk.infrastructure;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to get data
 *
 * @author Ivan
 */
@Slf4j
public class RetrieveInputData {
    public List<String> getGamesWithTwoPlayersFromTxtFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream table = classloader.getResourceAsStream("hands.txt");
        List<String> rowsGameWithTwoPlayers = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(table));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (isCorrectRowGame(line)) {
                    rowsGameWithTwoPlayers.add(line);
                }
            }
        } catch (IOException iOException) {
            log.error("Error occurred when reading input file : {}", iOException.getMessage());
        }
        return rowsGameWithTwoPlayers;
    }

    private boolean isCorrectRowGame(String rowGame) {
        boolean isCorrect = true;
        String[] cards = rowGame.split(" ");
        if (cards.length == 10) {
            for (String card : cards) {
                if (!isCorrectCard(card)) {
                    isCorrect = false;
                    break;
                }
            }
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }

    private boolean isCorrectCard(String cardValue) {
        String valuesOfCard = "23456789TJQKA";
        String suitsOfCard = "CDHS";
        boolean isCorrect = false;
        if (cardValue.length() == 2
                && valuesOfCard.contains(String.valueOf(cardValue.charAt(0)))
                && suitsOfCard.contains(String.valueOf(cardValue.charAt(1)))) {
            isCorrect = true;
        }
        return isCorrect;
    }
}