package fr.iut.vannes.info.model;


/**
 * Classe Compte représentant un compte bancaire dans le système.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class Compte {

    private int numCompte;
    private float solde;
    private String typeCompte;

    public Compte(int numCompte, float solde, String typeCompte) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.typeCompte = typeCompte;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }
}
