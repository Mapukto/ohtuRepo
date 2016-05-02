package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1won();
        else
            player2won();
    }

    private void player2won() {
        m_score2 += 1;
    }

    private void player1won() {
        m_score1 += 1;
    }

    public String getScore() {
        String score = "";
        if (pisteetTasan()) {
            score = tasaTilanneScore();
        }
        else if (etuTilanne()) {
            score = etuTaiVoitto();
        }
        else {
            score = eiTasaEikaEtu(score);
        }
        return score;
    }

    private String eiTasaEikaEtu(String score) {
        int tempScore;
        for (int i = 1; i<3; i++) {
            if (i==1) tempScore = m_score1;
            else {
                score+="-"; tempScore = m_score2;
            }
            score = getScoreName(score, tempScore);
        }
        return score;
    }

    private String getScoreName(String score, int tempScore) {
        switch(tempScore) {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return score;
    }

    private boolean etuTilanne() {
        return m_score1>=4 || m_score2>=4;
    }

    private boolean pisteetTasan() {
        return m_score1==m_score2;
    }

    private String etuTaiVoitto() {
        String score;
        int pisteErotus = m_score1-m_score2;es
        if (pisteErotus==1) score ="Advantage player1";
        else if (pisteErotus == -1) score ="Advantage player2";
        else if (pisteErotus>=2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String tasaTilanneScore() {
        String score;
        switch (m_score1) {
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
        return score;
    }
}