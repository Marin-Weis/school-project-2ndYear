/**
 * Auteur : Weis
 * Prénom : Marin
 * Groupe : C1
 */



/**
 * classe qui implémente une stratégie gagnante 
 * (basée sur un move calculé à partir de la taille de tas modulo 4, par exemple)
 */
public class SmartComputerPlayer extends Player {
    private String name;

    public SmartComputerPlayer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public int takeTurn(int heapSize) {
        //Stratégie gagnante : laisser un multiple de 4 à l'adversaire
        int move = heapSize % 4;
        if (move == 0) {
            move = 1; // Si on est dans une position perdante, on prend 1
        }
        System.out.println(name + " removes " + move + " objects.");
        return move;
    }
}