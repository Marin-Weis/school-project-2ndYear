package fr.iut.vannes.info.model;


/**
 * Classe Client représentant un client dans le système bancaire.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class Client {

    private int numClient;
    private String nomClient;
    private String prenomClient;
    private String adClient;
    private String dateNaissClient;
    private int ageClient;
    private int numAgent;

    public Client(int numClient, String nomClient, String prenomClient, String adClient, String dateNaissClient, int ageClient, int numAgent) {
        this.numClient = numClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adClient = adClient;
        this.dateNaissClient = dateNaissClient;
        this.ageClient = ageClient;
        this.numAgent = numAgent;
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdClient() {
        return adClient;
    }

    public void setAdClient(String adClient) {
        this.adClient = adClient;
    }

    public String getDateNaissClient() {
        return dateNaissClient;
    }

    public void setDateNaissClient(String dateNaissClient) {
        this.dateNaissClient = dateNaissClient;
    }

    public int getAgeClient() {
        return ageClient;
    }

    public void setAgeClient(int ageClient) {
        this.ageClient = ageClient;
    }

    public int getNumAgent() {
        return numAgent;
    }

    public void setNumAgent(int numAgent) {
        this.numAgent = numAgent;
    }


}
