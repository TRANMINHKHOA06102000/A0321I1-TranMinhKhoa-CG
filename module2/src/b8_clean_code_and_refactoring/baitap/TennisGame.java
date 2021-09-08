package b8_clean_code_and_refactoring.baitap;

public class TennisGame {
    public static String howToCall(int scoreFirst, int scoreSecond) {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scoreFirst;
            else {
                score += "-";
                tempScore = scoreSecond;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    public static String advantagePlayer(int scoreFirst, int scoreSecond) {
        String score = "";
        boolean scoreSum = scoreFirst >= 4 || scoreSecond >= 4;
        if (scoreSum) {
            int minusResult = scoreFirst - scoreSecond;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            howToCall(scoreFirst, scoreSecond);
        }
        return score;
    }

    public static String getScore(String playerFirstName, String playerSecondName, int scoreFirst, int scoreSecond) {
        String score = "";
        if (scoreFirst == scoreSecond) {
            switch (scoreFirst) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else {
            advantagePlayer(scoreFirst, scoreSecond);
        }
        return score;
    }
}
