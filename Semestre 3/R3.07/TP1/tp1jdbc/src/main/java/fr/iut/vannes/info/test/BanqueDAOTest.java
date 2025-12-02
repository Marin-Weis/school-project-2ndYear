package fr.iut.vannes.info.test;

import fr.iut.vannes.info.dao.BanqueDAO;
import java.sql.*;
import fr.iut.vannes.info.model.*;

/**
 * Classe de test pour la classe BanqueDAO.
 * Elle inclut des méthodes pour tester l'ajout et la récupération des entités.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class BanqueDAOTest {

    private BanqueDAO dao;

    public BanqueDAOTest(Connection connection) {
        this.dao = new BanqueDAO(connection);
    }

    // Réinitialiser la base de données en supprimant toutes les entrées des tables
    public void resetDatabase() throws SQLException {
        dao.getConnection().prepareStatement("DELETE FROM Operation").executeUpdate();
        dao.getConnection().prepareStatement("DELETE FROM Compte").executeUpdate();
        dao.getConnection().prepareStatement("DELETE FROM Client").executeUpdate();
        dao.getConnection().prepareStatement("DELETE FROM Agent").executeUpdate();
        dao.getConnection().prepareStatement("DELETE FROM Agence").executeUpdate();
    }


    // Tests pour ajouter des entités et vérifier leur existence
    public void testAjouterAgence(Agence agence) throws SQLException {
        dao.ajouterAgence(agence);
        if (dao.obtenirAgenceParNum(agence.getNumAgence()) != null)
            System.out.println("Test ajouter agence : OK");
        else
            System.out.println("Test ajouter agence : Echec");
    }

    // Tests pour ajouter des entités et vérifier leur existence
    public void testAjouterAgent(Agent agent) throws SQLException {
        dao.ajouterAgent(agent);
        if (dao.obtenirAgentParNum(agent.getNumAgent()) != null)
            System.out.println("Test ajouter agent : OK");
        else
            System.out.println("Test ajouter agent : Echec");
    }


    // Tests pour ajouter des entités et vérifier leur existence
    public void testAjouterClient(Client client) throws SQLException {
        dao.ajouterClient(client);
        if (dao.obtenirClientParNum(client.getNumClient()) != null)
            System.out.println("Test ajouter client : OK");
        else
            System.out.println("Test ajouter client : Echec");
    }


    // Tests pour ajouter des entités et vérifier leur existence
    public void testAjouterCompte(Compte compte) throws SQLException {
        dao.ajouterCompte(compte);
        if (dao.obtenirCompteParNum(compte.getNumCompte()) != null)
            System.out.println("Test ajouter compte : OK");
        else
            System.out.println("Test ajouter compte : Echec");
    }


    // Tests pour ajouter des entités et vérifier leur existence
    public void testAjouterOperation(Operation operation) throws SQLException {
        dao.ajouterOperation(operation);
        if (dao.obtenirOperationParNum(operation.getNumOperation()) != null)
            System.out.println("Test ajouter operation : OK");
        else
            System.out.println("Test ajouter operation : Echec");
    }
}
