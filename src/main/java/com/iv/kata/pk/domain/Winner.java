package com.iv.kata.pk.domain;

import com.iv.kata.pk.domain.dto.Player;
import com.iv.kata.pk.infrastructure.RetrieveInputData;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to select winner among black and white
 *
 * @author Ivan
 */
public class Winner {

    private final RetrieveInputData retrieveInputData = new RetrieveInputData();
    private final Ranking ranking = new Ranking();
    private final Compare compare = new Compare();

    private static final String WINS = " wins.";
    private static final String TIE = "Tie.";
    private static final String WITH = " - with ";


    public List<String> getWinner() {
        return findWinnerBetweenTwoPlayer(retrieveInputData.getGamesWithTwoPlayersFromTxtFile());
    }

    private List<String> findWinnerBetweenTwoPlayer(List<String> twoPlayers) {
        List<String> result = new ArrayList<>();

        for (String twoPlayer : twoPlayers) {
            String blackPlayerString = twoPlayer.substring(0, twoPlayer.length() / 2);
            String whitePlayerString = twoPlayer.substring(twoPlayer.length() / 2 + 1);
            Player blackPlayer = new Player(blackPlayerString, "Black");
            Player whitePlayer = new Player(whitePlayerString, "White");

            int blackPlayerRank = ranking.getPlayerRanking(blackPlayer).getRank();
            int whitePlayerRank = ranking.getPlayerRanking(whitePlayer).getRank();

            String blackPlayerMessageDetail = ranking.getPlayerRanking(blackPlayer).getMessageDetail();
            String whitePlayerMessageDetail = ranking.getPlayerRanking(whitePlayer).getMessageDetail();

            if (blackPlayerRank > whitePlayerRank) {
                result.add(blackPlayer.getName() + WINS + WITH + blackPlayerMessageDetail);
            } else if (blackPlayerRank == whitePlayerRank) {
                switch (blackPlayerRank) {
                    case 0:
                        addResult(result, compare.comparePlayerWithHigh(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 1:
                        addResult(result, compare.comparePlayerWithPair(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 3:
                        addResult(result, compare.comparePlayerWithThreeOfAKind(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 4:
                        addResult(result, compare.comparePlayerWithStraight(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 5:
                        addResult(result, compare.comparePlayerWithFlush(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 6:
                        addResult(result, compare.comparePlayerWithFullHouse(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 7:
                        addResult(result, compare.comparePlayerWithFourOfAKind(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    case 8:
                        addResult(result, compare.comparePlayerWithStraightFlush(blackPlayer, whitePlayer), blackPlayerMessageDetail);
                        break;
                    default:
                        result.add(TIE);
                        break;
                }
            } else {
                result.add(whitePlayer.getName() + WINS + WITH + whitePlayerMessageDetail);
            }
        }
        return result;
    }

    private void addResult(List<String> result, Player player, String messageDetail) {
        if (player != null) {
            result.add(player.getName() + WINS + WITH + messageDetail);
        } else {
            result.add(TIE);
        }
    }
}