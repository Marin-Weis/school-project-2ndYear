/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */


import java.util.Scanner;

// Main class to run the game
public class NimGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create players
        Player human = new HumanPlayer("Human", scanner);
        Player computer = new SmartComputerPlayer("Computer");

        // Create and start the game
        NimGame game = new NimGame(21, human, computer);
        game.play();

        scanner.close();
    }
}