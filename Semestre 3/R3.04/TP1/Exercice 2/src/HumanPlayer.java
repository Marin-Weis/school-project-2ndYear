/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */


import java.util.Scanner;

// Human player class
class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public int takeTurn(int heapSize) {
        System.out.print(name + ", enter the number of objects to remove (1, 2, or 3): ");
        int move = scanner.nextInt();

        // Validate move
        while (move < 1 || move > 3 || move > heapSize) {
            System.out.print("Invalid move. Enter a number between 1 and 3, and not more than the heap size: ");
            move = scanner.nextInt();
        }
        return move;
    }
}