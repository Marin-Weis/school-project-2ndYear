package fr.iut.vannes.info.model;


/**
 * Classe Agent représentant un agent dans le système bancaire.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class Agent {

    private int numAgent;
    private String nomAgent;
    private String prenomAgent;
    private boolean estDirecteur;
    private int numAgence;

    public Agent(int numAgent, String nomAgent, String prenomAgent, boolean estDirecteur, int numAgence) {
        this.numAgent = numAgent;
        this.nomAgent = nomAgent;
        this.prenomAgent = prenomAgent;
        this.estDirecteur = estDirecteur;
        this.numAgence = numAgence;
    }

    // Getters et Setters

    public int getNumAgent() {
        return numAgent;
    }

    public void setNumAgent(int numAgent) {
        this.numAgent = numAgent;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public String getPrenomAgent() {
        return prenomAgent;
    }

    public void setPrenomAgent(String prenomAgent) {
        this.prenomAgent = prenomAgent;
    }

    public boolean isEstDirecteur() {
        return estDirecteur;
    }

    public void setEstDirecteur(boolean estDirecteur) {
        this.estDirecteur = estDirecteur;
    }

    public int getNumAgence() {
        return numAgence;
    }

    public void setNumAgence(int numAgence) {
        this.numAgence = numAgence;
    }
}
