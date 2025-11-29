package structdonnees;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de test de la classe ArbreBinaire
 * @author M. Weis
 * @version 1.0
 *
 */
public class TestArbreBinaire {
	
	private ArbreBinaire<Integer, String> arbre;
	
	/**
	 * Initialisation de l'arbre avant chaque test
	 */
	@Before
    public void instancier() {
        this.arbre = new ArbreBinaire<>();
        
        arbre.inserer(15, "L. Yamal");
        arbre.inserer(10, "F. Torres");
        arbre.inserer(9, "R. Lewandoski");
    }

	/**
	 * Test du constructeur
	 */
	@Test
	public void testArbreBinaire() {
		System.out.println("\n\n=== Test du constructeur ===");
		ArbreBinaire<Integer,String> arbre = new ArbreBinaire<>();
		System.out.println("Test Réussi !");
	}


	/**
	 * Test de la méthode obtenirLaRacine()
	 */
	@Test
	public void testObtenirLaRacine() {
		System.out.println("\n\n=== Test de la méthode obtenirLaRacine() ===");
		// Cas normal : arbre initial
		System.out.println("\nCas normal :");
        testCasObtenirLaRacine(arbre, arbre.obtenirLaRacine(), false);

        // Cas limite : arbre avec un seul nœud
		System.out.println("\nCas limites :");
        ArbreBinaire<Integer, String> arbre2 = new ArbreBinaire<>();
        arbre2.inserer(6, "P. Gavira");
        testCasObtenirLaRacine(arbre2, arbre2.obtenirLaRacine(), false);

        // Cas limite : arbre vide
        ArbreBinaire<Integer, String> arbreVide = new ArbreBinaire<>();
        testCasObtenirLaRacine(arbreVide, null, false);

        // Cas erreur : arbre null
		System.out.println("\nCas erreur :");
        testCasObtenirLaRacine(null, null, true);
	}
	
	/**
	 * Test d'un cas de la méthode obtenirLaRacine()
	 * @param arbre l'arbre à tester
	 * @param res le résultat attendu
	 * @param err true si une exception doit être levée, false sinon
	 */
	private void testCasObtenirLaRacine(ArbreBinaire<Integer,String> arbre, ArbreBinaire<Integer,String>.Noeud res, boolean err) {
		try {
			assertEquals("Echec du test !", res, arbre.obtenirLaRacine());
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		}
	}

	/**
	 * Test de la méthode obtenir()
	 */
	@Test
	public void testObtenir() {
		System.out.println("\n\n=== Test de la méthode obtenir() ===");
		// Cas normaux
		System.out.println("\nCas normaux :");
        testCasObtenir(arbre, 10, "F. Torres", false);
        testCasObtenir(arbre, 15, "L. Yamal", false);
        testCasObtenir(arbre, 9, "R. Lewandoski", false);

        // Cas limite : clé non existante
		System.out.println("\nCas limite :");
        testCasObtenir(arbre, 100, null, false);

        // Cas erreur : clé null
		System.out.println("\nCas erreur :");
        testCasObtenir(arbre, null, null, true);
	}
	

	/**
	 * Test d'un cas de la méthode obtenir()
	 * @param arbre l'arbre à tester
	 * @param cle la clé à rechercher
	 * @param res le résultat attendu
	 * @param err true si une exception doit être levée, false sinon
	 */
	public void testCasObtenir(ArbreBinaire<Integer,String> arbre, Integer cle, String res, boolean err) {
		try {
			assertEquals("Echec du test !", res, arbre.obtenir(cle));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		}
	}

	/**
	 * Test de la méthode inserer()
	 */
	@Test
	public void testInserer() {
		System.out.println("\n\n=== Test de la méthode inserer() ===");
		// Cas normal : insertion clé unique
		System.out.println("\nCas normaux :");
		testCasInserer(arbre, 5, "A. Christensen", true, false);
		testCasInserer(arbre, 12, "K. De Bruyne", true, false);
        testCasInserer(arbre, 24, "E. Garcia", true, false);

        // Cas limite : insertion clé existante
		System.out.println("\nCas limite :");
        testCasInserer(arbre, 15, "P. Cubarsi", false, true);
	}
	
	/**
	 * Test d'un cas de la méthode inserer()
	 * @param arbre l'arbre à tester
	 * @param cle la clé à insérer
	 * @param donnee la donnée à insérer
	 * @param res le résultat attendu
	 * @param err true si une exception doit être levée, false sinon
	 */
	public void testCasInserer(ArbreBinaire<Integer,String> arbre, int cle, String donnee, boolean res, boolean err) {
		try {
			assertEquals("Echec du test !", res, arbre.inserer(cle, donnee));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		}
	}

	/**
	 * Test de la méthode isAvg()
	 */
	@Test
	public void testIsAvg() {
		System.out.println("\n\n=== Test de la méthode isAvg() ===");
		// Cas normal : arbre initial
		System.out.println("\nCas normal :");
        testCasIsAvg(arbre, false, false);

        // Cas limite : arbre vide
		System.out.println("\nCas limite :");
        ArbreBinaire<Integer, String> arbreVide = new ArbreBinaire<>();
        testCasIsAvg(arbreVide, true, false);
	}
	
	/**
	 * Test d'un cas de la méthode isAvg()
	 * @param arbre l'arbre à tester
	 * @param res le résultat attendu
	 * @param err true si une exception doit être levée, false sinon
	 */
	private void testCasIsAvg(ArbreBinaire<Integer,String> arbre, boolean res, boolean err) {
		try {
			assertEquals("Echec du test !", res, arbre.isAvg());
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		}
	}

	/**
	 * Test de la méthode supprimer()
	 */
	@Test
	public void testSupprimer() {
		System.out.println("\n\n=== Test de la méthode supprimer() ===");
		// Cas normal : suppression d’une feuille
		System.out.println("\nCas normaux :");
        testCasSupprimer(arbre, 9, true, false);

        // Cas normal : suppression avec 1 enfant
        arbre.inserer(12, "Test 12");
        testCasSupprimer(arbre, 10, true, false);

        // Cas limite : suppression de la racine
		System.out.println("\nCas limite :");
        testCasSupprimer(arbre, 15, true, false);

        // Cas limite : suppression clé non existante
		System.out.println("\nCas erreur :");
        testCasSupprimer(arbre, 100, false, true);
	}
	
	/**
	 * Test d'un cas de la méthode supprimer()
	 * @param arbre l'arbre à tester
	 * @param cle la clé à supprimer
	 * @param res le résultat attendu
	 * @param err true si une exception doit être levée, false sinon
	 */
	private void testCasSupprimer(ArbreBinaire<Integer,String> arbre, int cle, boolean res, boolean err) {
		try {
			assertEquals("Echec du test !", res, arbre.supprimer(cle));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		}
	}

	/**
	 * Test de la méthode cloner()
	 */
	@Test
	public void testCloner() {
		System.out.println("\n\n=== Test de la méthode cloner() ===");
		// Cas normal : arbre initial
		System.out.println("\nCas normal :");
        testCasCloner(arbre, arbre.obtenirLaRacine(), false);

        // Cas limite : arbre vide
		System.out.println("\nCas limite :");
        ArbreBinaire<Integer, String> arbreVide = new ArbreBinaire<>();
        testCasCloner(arbreVide, null, false);
	}
	
	/**
	 * Test d'un cas de la méthode cloner()
	 * @param arbre l'arbre à tester
	 * @param racine la racine de l'arbre à tester
	 * @param err true si une exception doit être levée, false sinon
	 */
	private void testCasCloner(ArbreBinaire<Integer, String> arbre, ArbreBinaire<Integer, String>.Noeud racine, boolean err) {
		try {
			ArbreBinaire<Integer, String> clone = arbre.cloner();
			assertEquals("Echec du test !", racine, clone.obtenirLaRacine());
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
		}
	}
	
	/**
	 * Test de la méthode afficherArbre()
	 */
	@Test
	public void testAfficherArbre() {
		System.out.println("\n\n=== Test de la méthode afficherArbre() ===");
		arbre.afficherArbre();

	    try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		System.out.println("Test Réussi !");
	}

}
