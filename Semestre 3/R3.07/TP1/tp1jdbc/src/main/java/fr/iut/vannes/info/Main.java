package fr.iut.vannes.info;

import fr.iut.vannes.info.model.Agence;
import fr.iut.vannes.info.model.Agent;
import fr.iut.vannes.info.model.Client;
import fr.iut.vannes.info.model.Compte;

import java.sql.Connection;
import java.sql.SQLException;
import fr.iut.vannes.info.test.BanqueDAOTest;
import fr.iut.vannes.info.model.Operation;
import fr.iut.vannes.info.dao.BanqueDAO;

/**
 * Classe principale pour exécuter les tests de la base de données bancaire.
 * @author M.Weis
 * TP1 : JDBC
 * Groupe : C1
 */
public class Main {

    // Méthode pour attendre que la base de données soit prête
    private static Connection waitForDB() {
        while (true) {
            try {
                System.out.println("Tentative de connexion à PostgreSQL...");
                // Tenter de se connecter à la base de données
                Connection cnx = BanqueDAO.getConnection();
                System.out.println("Connexion à PostgreSQL réussie !");
                return cnx;
            } catch (Exception e) {
                System.out.println("Connexion échouée, nouvelle tentative en cours...");
                try {
                    Thread.sleep(2000); // Attendre 2 secondes avant de réessayer
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
            }
        }
    }

    // Programme principal pour exécuter les tests
    public static void main(String[] args) throws SQLException {


        Connection connection = waitForDB();
        BanqueDAO dao = new BanqueDAO(connection);

        BanqueDAOTest test = new BanqueDAOTest(connection);

        try {

            test.resetDatabase();

            // Test ajouter une agence
            Agence agence = new Agence(1, "0123456789", "123 Rue de la Banque");
            test.testAjouterAgence(agence);

            // Test ajouter un agent
            Agent agent = new Agent(1, "Dupont", "Jean", true, 1);
            test.testAjouterAgent(agent);

            // Test ajouter un client
            Client client = new Client(1, "Martin", "Claire", "456 Avenue des Clients",
                    "1990-01-01", 34, 1);
            test.testAjouterClient(client);

            // Test ajouter un compte
            Compte compte = new Compte(1, 500.0f, "Courant");
            test.testAjouterCompte(compte);

            // Test ajouter une opération
            Operation operation = new Operation(1, "2024-06-01", "Virement", 150, 1);
            test.testAjouterOperation(operation);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
