/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */


// Base class for a player
abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method for taking a turn
    public abstract int takeTurn(int heapSize);
}