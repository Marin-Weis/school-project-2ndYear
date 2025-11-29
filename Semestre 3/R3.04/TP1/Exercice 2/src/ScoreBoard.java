/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */


/**
 * classe ScoreBoard pour suivre les scores des joueurs sur plusieurs parties
 */
public class ScoreBoard {
    private int humanWins;
    private int computerWins;

    public ScoreBoard() {
        this.humanWins = 0;
        this.computerWins = 0;
    }

    public void recordWin(String playerName) {
        if (playerName.equals("Human")) {
            humanWins++;
        } else if (playerName.equals("Computer")) {
            computerWins++;
        }
    }

    public void displayScores() {
        System.out.println("Scoreboard:");
        System.out.println("Human Wins: " + humanWins);
        System.out.println("Computer Wins: " + computerWins);
    }
}