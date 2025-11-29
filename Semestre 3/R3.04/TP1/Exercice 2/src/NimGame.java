/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */


// NimGame class
class NimGame {
    private int heapSize;
    private Player[] players;
    private int currentPlayerIndex;

    public NimGame(int initialHeapSize, Player player1, Player player2) {
        this.heapSize = initialHeapSize;
        this.players = new Player[]{player1, player2};
        this.currentPlayerIndex = 0;
    }

    public void play() {
        System.out.println("Starting the Jeu de Nim!");
        System.out.println("Initial heap size: " + heapSize);
        System.out.println("The player forced to take the last object loses.");

        while (heapSize > 0) {
            System.out.println("\nCurrent heap size: " + heapSize);
            Player currentPlayer = players[currentPlayerIndex];

            int move = currentPlayer.takeTurn(heapSize);
            heapSize -= move;

            // Check for game end
            if (heapSize == 0) {
                System.out.println("\n" + currentPlayer.getName() + " took the last object. " +
                        (currentPlayer instanceof HumanPlayer ? "You lose!" : "You win!"));
                return;
            }

            // Switch to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
    }
}
