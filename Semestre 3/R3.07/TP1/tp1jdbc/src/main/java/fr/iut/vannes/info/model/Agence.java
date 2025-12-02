package fr.iut.vannes.info.model;

/**
 * Classe Agence représentant une agence bancaire dans le système.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class Agence {

    private int numAgence;
    private String telAgence;
    private String adAgence;

    public Agence(int numAgence, String telAgence, String adAgence) {
        this.numAgence = numAgence;
        this.telAgence = telAgence;
        this.adAgence = adAgence;
    }

    // Getters et Setters

    public int getNumAgence() {
        return numAgence;
    }

    public void setNumAgence(int numAgence) {
        this.numAgence = numAgence;
    }

    public String getTelAgence() {
        return telAgence;
    }

    public void setTelAgence(String telAgence) {
        this.telAgence = telAgence;
    }

    public String getAdAgence() {
        return adAgence;
    }

    public void setAdAgence(String adAgence) {
        this.adAgence = adAgence;
    }
}
