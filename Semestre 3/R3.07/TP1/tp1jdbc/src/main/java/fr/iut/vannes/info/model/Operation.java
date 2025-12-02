package fr.iut.vannes.info.model;


/**
 * Classe Operation représentant une opération bancaire dans le système.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class Operation {

    private int numOperation;
    private String dateOperation;
    private String typeOperation;
    private float montant;
    private int numCompte;

    public Operation(int numOperation, String dateOperation, String typeOperation, float montant, int numCompte) {
        this.numOperation = numOperation;
        this.dateOperation = dateOperation;
        this.typeOperation = typeOperation;
        this.montant = montant;
        this.numCompte = numCompte;
    }

    public int getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(int numOperation) {
        this.numOperation = numOperation;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }
}
