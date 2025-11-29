/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */


// Computer player class
class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int takeTurn(int heapSize) {
        int move = Math.min(3, heapSize); // Simple strategy: take the maximum allowed
        System.out.println(name + " removes " + move + " objects.");
        return move;
    }
}
