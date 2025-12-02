package fr.iut.vannes.info.dao;

import java.sql.*;

import fr.iut.vannes.info.model.Agence;
import fr.iut.vannes.info.model.Agent;
import fr.iut.vannes.info.model.Client;
import fr.iut.vannes.info.model.Operation;
import fr.iut.vannes.info.model.Compte;

/**
 * Classe BanqueDAO pour gérer les opérations de la base de données bancaires.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class BanqueDAO {
    private Connection connection;

    public BanqueDAO(Connection connection) {
        this.connection = connection;
    }

    // Methode pour se connecter au serveur de donnees
    public static Connection getConnection() throws SQLException {
        // Charger le driver PostgreSQL
        return DriverManager.getConnection(
                "jdbc:postgresql://db:5432/banque_db",
                "user",
                "password"
        );
    }

    // Methode pour ajouter une agence
    public void ajouterAgence(Agence agence) throws SQLException {
        String sql = "INSERT INTO Agence (numAgence, telAgence, adAgence) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, agence.getNumAgence());
            pstmt.setString(2, agence.getTelAgence());
            pstmt.setString(3, agence.getAdAgence());
            pstmt.executeUpdate();
        }
    }

    // Methode pour ajouter un agent
    public void ajouterAgent(Agent agent) throws SQLException {
        String query = "INSERT INTO Agent (numAgent, nomAgent, prenomAgent, estDirecteur, numAgence) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, agent.getNumAgent());
            pstmt.setString(2, agent.getNomAgent());
            pstmt.setString(3, agent.getPrenomAgent());
            pstmt.setBoolean(4, agent.isEstDirecteur());
            pstmt.setInt(5, agent.getNumAgence());
            pstmt.executeUpdate();
        }
    }

    // Methode pour ajouter un client
    public void ajouterClient(Client client) throws SQLException {
        String query = "INSERT INTO Client (numClient, nomClient, prenomClient, adClient, dateNaissClient, ageClient, numAgent) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, client.getNumClient());
            pstmt.setString(2, client.getNomClient());
            pstmt.setString(3, client.getPrenomClient());
            pstmt.setString(4, client.getAdClient());
            pstmt.setDate(5, java.sql.Date.valueOf(client.getDateNaissClient())); // <-- CORRECTION
            pstmt.setInt(6, client.getAgeClient());
            pstmt.setInt(7, client.getNumAgent());
            pstmt.executeUpdate();
        }
    }

    // Methode pour ajouter un compte
    public void ajouterCompte(Compte compte) throws SQLException {
        String query = "INSERT INTO Compte (numCompte, solde, typeCompte) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, compte.getNumCompte());
            pstmt.setFloat(2, compte.getSolde());
            pstmt.setString(3, compte.getTypeCompte());
            pstmt.executeUpdate();
        }
    }

    // Methode pour ajouter une operation
    public void ajouterOperation(Operation operation) throws SQLException {
        String query = "INSERT INTO Operation (numOperation, dateOperation, typeOperation, montant, numCompte) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, operation.getNumOperation());
            pstmt.setDate(2, java.sql.Date.valueOf(operation.getDateOperation())); // <-- CORRECTION
            pstmt.setString(3, operation.getTypeOperation());
            pstmt.setFloat(4, operation.getMontant());
            pstmt.setInt(5, operation.getNumCompte());
            pstmt.executeUpdate();
        }
    }

    // Methode pour obtenir un client par son numero
    public Client obtenirClientParNum(int numClient) throws SQLException {
        String query = "SELECT * FROM Client WHERE numClient = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, numClient);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Client(
                        rs.getInt("numClient"),
                        rs.getString("nomClient"),
                        rs.getString("prenomClient"),
                        rs.getString("adClient"),
                        rs.getString("dateNaissClient"),
                        rs.getInt("ageClient"),
                        rs.getInt("numAgent")
                );
            } else {
                return null;
            }
        }
    }

    // Methode pour obtenir un agent par son numero
    public Agent obtenirAgentParNum(int numAgent) throws SQLException {
        String query = "SELECT * FROM Agent WHERE numAgent = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, numAgent);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new Agent(
                        rs.getInt("numAgent"),
                        rs.getString("nomAgent"),
                        rs.getString("prenomAgent"),
                        rs.getBoolean("estDirecteur"),
                        rs.getInt("numAgence")
                );
            } else {
                return null;
            }
        }
    }

    //Méthode pour obtenir une agence par son numero
    public Agence obtenirAgenceParNum(int numAgence) throws SQLException {
        String query = "SELECT * FROM Agence WHERE numAgence = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, numAgence);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new Agence(
                        rs.getInt("numAgence"),
                        rs.getString("telAgence"),
                        rs.getString("adAgence")
                );
            } else {
                return null;
            }
        }
    }



    //Méthode pour obtenir une operation par son numero
    public Operation obtenirOperationParNum(int numOperation) throws SQLException{
        String query = "SELECT * FROM Operation WHERE numOperation = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, numOperation);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new Operation(
                        rs.getInt("numOperation"),
                        rs.getString("dateOperation"),
                        rs.getString("typeOperation"),
                        rs.getFloat("montant"),
                        rs.getInt("numCompte")
                );
            } else {
                return null;
            }
        }
    }

    public Compte obtenirCompteParNum(int numCompte) {
        String query = "SELECT * FROM Compte WHERE numCompte = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, numCompte);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Compte(
                        rs.getInt("numCompte"),
                        rs.getFloat("solde"),
                        rs.getString("typeCompte")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


