package structdonnees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests unitaires pour la classe ListeChainee.
 * 
 * Cette classe effectue des tests sur toutes les méthodes de la ListeChainee,
 * en couvrant les cas normaux, les cas limites et les cas d'erreur.
 * Chaque test affiche "Test Réussi" ou "Test Echoué" selon le résultat.
 * 
 * Pour chaque méthode, les tests incluent :
 * - Cas normaux : fonctionnement attendu avec des valeurs usuelles
 * - Cas limites : listes avec un seul élément ou liste vide
 * - Cas d'erreur : paramètres invalides ou opérations interdites
 * 
 * Auteur : M.Weis
 * Version : 1.0
*/
public class TestListeChainee {
	
	private ListeChainee liste;
	
	
	/**
     * Initialise un objet ListeChainee avant chaque test.
    */
	@Before
    public void instancier() {
        this.liste = new ListeChainee();
    }
	
	
	/**
     * Teste le constructeur ListeChainee().
    */
	@Test
	public void testListeChainee() {
		System.out.println("\n\n=== Test du constructeur ===");
		ListeChainee liste = new ListeChainee();
		System.out.println("Test Réussi");
	}
	
	/**
	 * Teste la méthode inserer() de ListeChainee.
	 * 
	 * Cas normaux : insertion de plusieurs éléments dans la liste.
	 * Cas limite : insertion dans une liste vide.
	 * Cas d'erreur : tentative d'insertion d'une valeur null.
	*/
	@Test
	public void testInserer() {
		System.out.println("\n\n=== Test de la méthode inserer() ===");
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		ListeChainee liste1 = new ListeChainee();
		testCasInserer(liste1, 10, "10", false);
		
		testCasInserer(liste1, 5, "5, 10", false);
		
		testCasInserer(liste1, 0, "0, 5, 10", false);
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		ListeChainee liste2 = new ListeChainee();
		testCasInserer(liste2, 0, "0", false);
		
		//Cas erreur 
		System.out.println("\nCas erreur : ");
		ListeChainee liste3 = new ListeChainee();
		testCasInserer(liste3, null, "", true);
	}
	
	
	/**
	 * Méthode helper pour tester la méthode inserer() d'une ListeChainee.
	 * 
	 * Cette méthode insère une valeur dans la liste et vérifie que le contenu
	 * de la liste correspond à la chaîne attendue. Elle gère également les
	 * exceptions pour les cas d'erreur (ex. insertion d'une valeur null).
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param data la valeur à insérer dans la liste
	 * @param res la représentation attendue de la liste après insertion (sous forme de chaîne)
	 * @param erreur true si une exception est attendue, false sinon
	*/
	private void testCasInserer(ListeChainee liste, Object data, String res, boolean erreur) {
		try {
			liste.inserer(data);
			assertEquals("Echec du test : Liste invalide", liste.toString(), res);
			
			if(!erreur) System.out.println("TestRéussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if(erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
		}
	}
	
	

	/**
	 * Teste la méthode supprimer() de ListeChainee.
	 * 
	 * Cas normaux : suppression d'éléments dans une liste non vide.
	 * Cas limite : suppression du dernier élément de la liste.
	 * Cas d'erreur : suppression dans une liste vide.
	*/
	@Test
	public void testSupprimer() {
		System.out.println("\n\n=== Test de la méthode supprimer() ===");
		
		//Cas normal
		System.out.println("\nCas normaux : ");
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(1);
		liste1.inserer("maison");
		liste1.inserer(1.0);
		testCasSupprimer(liste1, "maison, 1", false);
		
		testCasSupprimer(liste1, "1", false);
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		testCasSupprimer(liste2, "", false);
		
		//Cas d'erreur 
		System.out.println("\nCas erreur : ");
		ListeChainee liste3 = new ListeChainee();
		testCasSupprimer(liste3, null, true);
	}
	
	
	/**
	 * Méthode helper pour tester la méthode supprimer() d'une ListeChainee.
	 * 
	 * Cette méthode supprime l'élément courant de la liste et vérifie que le 
	 * contenu de la liste correspond à la chaîne attendue après suppression. 
	 * Elle gère également les cas où la suppression est interdite (ex. liste vide).
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param res la représentation attendue de la liste après suppression (sous forme de chaîne)
	 * @param erreur true si une exception (NullPointerException) est attendue, false sinon
	*/
	private void testCasSupprimer(ListeChainee liste, String res, boolean erreur) {
		try {
			liste.supprimer();
			assertEquals("Echec du test : Liste invalide", liste.toString(), res);
			
			if(!erreur) System.out.println("TestRéussi");
			else System.out.println("Test Echoué");
			
		} catch (NullPointerException e) {
			
			if(erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
		}
	}
	

	/**
	 * Teste la méthode contient() de ListeChainee.
	 * 
	 * Cas normaux : vérification de la présence d'éléments existants.
	 * Cas limite : vérification dans une liste vide.
	 * Cas d'erreur : passage d'une valeur null.
	*/
	@Test
	public void testContient() {
		System.out.println("\n\n=== Test de la méthode contient() ===");
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(1);
		liste1.inserer("voiture");
		
		testCasContient(liste1, 1, true, false);
		
		testCasContient(liste1, "voiture", true, false);
		
		testCasContient(liste1, "Marin", false, false);
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		ListeChainee liste2 = new ListeChainee();
		testCasContient(liste2, "", false, false);
		
		//Cas d'erreur 
		System.out.println("\nCas erreur : ");
		ListeChainee liste3 = new ListeChainee();
		liste.inserer(1);
		liste.inserer(0);
		testCasContient(liste3, null, false, true);
		
	}
	
	
	/**
	 * Méthode helper pour tester la méthode contient() d'une ListeChainee.
	 * 
	 * Cette méthode vérifie si une valeur donnée est présente dans la liste et 
	 * compare le résultat avec la valeur attendue. Elle gère également les cas 
	 * où la recherche est invalide (par exemple, passage d'une valeur null).
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param data la valeur à rechercher dans la liste
	 * @param res true si la valeur est attendue dans la liste, false sinon
	 * @param erreur true si on attend qu'une exception (IllegalArgumentException) soit levée, false sinon
	*/
	private void testCasContient(ListeChainee liste, Object data, boolean res, boolean erreur) {
		try {
			boolean ret = liste.contient(data);
			assertEquals("Echec du test : Liste Invalide", ret, res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	

	/**
	 * Teste la méthode ajouter() de ListeChainee.
	 * 
	 * Cas normaux : ajout à un index valide dans la liste.
	 * Cas limite : ajout dans une liste avec un seul élément.
	 * Cas d'erreur : index invalide ou valeur null.
	*/
	@Test
	public void testAjouter() {
		System.out.println("\n\n=== Test de la méthode ajouter() ===");
		
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasAjouter(liste1, 0, "20", "20, 0, 1, 2", false);
		
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		testCasAjouter(liste2, 0, "cheval", "cheval, 1", false);
		
		//Cas d'erreur
		System.out.println("\nCas erreur : ");
		testCasAjouter(liste1, 0, null, "1, 2", true);
		testCasAjouter(liste1, 6, 3, "0, 1, 2, 3", true);
		
	}
	
	
	/**
	 * Méthode helper pour tester la méthode ajouter() d'une ListeChainee.
	 * 
	 * Cette méthode tente d'ajouter une valeur à un index spécifique dans la liste 
	 * et compare le résultat avec la chaîne attendue représentant la liste. Elle 
	 * gère également les cas où l'opération est invalide, comme un index hors limites 
	 * ou une valeur null.
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param index l'indice où insérer la valeur
	 * @param data la valeur à insérer dans la liste
	 * @param res le résultat attendu sous forme de chaîne après l'insertion
	 * @param erreur true si on attend qu'une exception (IllegalArgumentException) soit levée, false sinon
	*/
	private void testCasAjouter(ListeChainee liste, int index, Object data, String res, boolean erreur) {
		try {
			liste.ajouter(index, data);
			assertEquals("Echec du test : Liste Invalide", liste.toString(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	

	/**
	 * Teste la méthode obtenirValeur() de ListeChainee.
	 * 
	 * Cas normaux : obtention de la valeur de l'élément courant.
	 * Cas limite : liste avec un seul élément.
	 * Cas d'erreur : liste vide.
	*/
	@Test
	public void testObtenirValeur() {
		System.out.println("\n\n=== Test de la méthode obtenirValeur() ===");
		
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(49.3);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux 
		System.out.println("\nCas normaux : ");
		testCasObtenirValeur(liste1, 0, false);
		
		liste1.suivant();
		testCasObtenirValeur(liste1, 1, false);
		
		liste1.suivant();
		testCasObtenirValeur(liste1, 2, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasObtenirValeur(liste2, 49.3, false);
		
		//Cas d'erreur
		System.out.println("\nCas erreur : ");
		testCasObtenirValeur(liste3, 0, true);
	}
	
	
	/**
	 * Méthode helper pour tester la méthode obtenirValeur() d'une ListeChainee.
	 * 
	 * Cette méthode vérifie que l'élément courant de la liste correspond à la valeur attendue.
	 * Elle gère également les cas où la liste est vide ou invalide et où une exception peut être levée.
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param res la valeur attendue de l'élément courant
	 * @param erreur true si on attend qu'une exception (RuntimeException) soit levée, false sinon
	*/
	private void testCasObtenirValeur(ListeChainee liste, Object res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste Invalide", liste.obtenirValeur(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (RuntimeException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	
	/**
	 * Teste la méthode changerValeur() de ListeChainee.
	 * 
	 * Cas normaux : changement de la valeur de l'élément courant.
	 * Cas limite : liste avec un seul élément.
	 * Cas d'erreur : valeur null ou liste vide.
	*/
	@Test
	public void testChangerValeur() {
		System.out.println("\n\n=== Test de la méthode changerValeur() ===");
		
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(3);
		liste1.inserer(2);
		liste1.inserer(1);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(3);
		
		ListeChainee liste3 = new ListeChainee();
		
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasChangerValeur(liste1, 9, "9, 2, 3", false);
		
		testCasChangerValeur(liste1, 8, "8, 2, 3", false);
		
		liste1.suivant();
		testCasChangerValeur(liste1, 8, "8, 8, 3", false);
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		testCasChangerValeur(liste2, 9, "9", false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasChangerValeur(liste1, null, "1, 2, 3", true);
		testCasChangerValeur(liste3, null, "1, 2, 3", true);
	}
	
	
	/**
	 * Méthode helper pour tester la méthode changerValeur() d'une ListeChainee.
	 * 
	 * Cette méthode modifie la valeur de l'élément courant de la liste et vérifie
	 * que le résultat correspond à la chaîne attendue. Elle gère également les cas
	 * d'erreur, comme le passage d'une valeur null ou une liste vide.
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param data la nouvelle valeur à affecter à l'élément courant
	 * @param res la représentation attendue de la liste après modification (sous forme de chaîne)
	 * @param erreur true si une exception est attendue, false sinon
	*/
	private void testCasChangerValeur(ListeChainee liste, Object data, String res, boolean erreur) {
		try {
			liste.changerValeur(data);
			assertEquals("Echec du test : Liste invalide", liste.toString(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
		    if (erreur) System.out.println("Test Réussi");
		    else System.out.println("Test Echoué");
		} catch (RuntimeException e) {
		    if (erreur) System.out.println("Test Réussi");
		    else System.out.println("Test Echoué");
		}
	}
	
	
	/**
	 * Teste la méthode estVide() de ListeChainee.
	 * 
	 * Cas normaux : liste vide ou non vide.
	 * Cas limite : liste avec un seul élément.
	*/
	@Test
	public void testEstVide() {
		System.out.println("\n\n=== Test de la méthode estVide() ===");
		
		ListeChainee liste1 = new ListeChainee();
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		liste2.inserer("");
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasEstVide(liste1, true, false);
		testCasEstVide(liste2, false, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasEstVide(liste3, true, false);
		
		
	}
	
	/**
	 * Méthode helper pour tester la méthode estVide() d'une ListeChainee.
	 * 
	 * Cette méthode vérifie si la liste est vide et compare le résultat avec
	 * la valeur attendue. Elle gère également les cas où une exception pourrait
	 * être levée.
	 * 
	 * @param liste la liste chaînée à tester
	 * @param res true si la liste est censée être vide, false sinon
	 * @param erreur true si on attend une exception lors de l'appel à estVide()
	*/
	private void testCasEstVide(ListeChainee liste, boolean res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.estVide(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	

	/**
	 * Teste la méthode obtenirTaille() de ListeChainee.
	 * 
	 * Cas normaux : liste avec plusieurs éléments.
	 * Cas limite : liste vide ou après suppression.
	*/
	@Test
	public void testObtenirTaille() {
		System.out.println("\n\n=== Test de la méthode obtenirTaille() ===");
		
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasObtenirTaille(liste1, 3, false);
		
		liste1.supprimer();
		testCasObtenirTaille(liste1, 2, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasObtenirTaille(liste2, 0, false);
	}
	
	
	/**
	 * Helper pour tester obtenirTaille() sur une liste donnée.
	 * 
	 * Cette méthode vérifie que la taille renvoyée par la liste correspond à la taille attendue.
	 * Elle affiche "Test Réussi" si le résultat correspond à l'attendu, "Test Echoué" sinon.
	 * 
	 * @param liste la liste chaînée à tester
	 * @param res la taille attendue
	 * @param erreur true si une exception est attendue, false sinon
	*/
	private void testCasObtenirTaille(ListeChainee liste, int res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.obtenirTaille(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	

	/**
	 * Teste la méthode teteListe() de ListeChainee.
	 * 
	 * Cas normaux : positionne le courant sur le premier élément.
	 * Cas limite : liste avec un seul élément.
	 * Cas d'erreur : liste vide.
	*/
	@Test
	public void testTeteListe() {
		System.out.println("\n\n=== Test de la méthode teteListe() ===");
	
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasTeteListe(liste1, 0, false);
		
		liste1.inserer("java");
		testCasTeteListe(liste1, "java", false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasTeteListe(liste2, 1, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasTeteListe(liste3, 0, true);
	}
	
	
	/**
	 * Helper pour tester la méthode teteListe() sur une liste donnée.
	 * 
	 * Cette méthode appelle teteListe() pour positionner le courant sur le premier élément,
	 * puis vérifie que la valeur obtenue correspond au résultat attendu.
	 * Elle affiche "Test Réussi" si le résultat correspond à l'attendu, "Test Echoué" sinon.
	 * 
	 * @param liste la liste à tester
	 * @param res la valeur attendue après avoir positionné le courant sur la tête
	 * @param erreur true si une exception est attendue (liste vide)
	*/
	private void testCasTeteListe(ListeChainee liste, Object res, boolean erreur) {
		try {
			liste.teteListe();
			assertEquals("Echec du test : Liste invalide", liste.obtenirValeur(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (RuntimeException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	

	/**
	 * Teste la méthode finListe() de ListeChainee.
	 * 
	 * Cas normaux : positionne le courant sur le dernier élément.
	 * Cas limite : liste avec un seul élément.
	 * Cas d'erreur : liste vide.
	*/
	@Test
	public void testFinListe() {
		System.out.println("\n\n=== Test de la méthode finListe() ===");
		
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasFinListe(liste1, 2, false);
		
		liste1.changerValeur("newData");
		testCasFinListe(liste1, "newData", false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasFinListe(liste2, 1, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasFinListe(liste3, 0, true);
	}
	
	
	/**
	 * Helper pour tester la méthode finListe() sur une liste donnée.
	 * 
	 * Cette méthode positionne le curseur sur le dernier élément de la liste
	 * et vérifie que la valeur obtenue correspond au résultat attendu.
	 * Elle affiche "Test Réussi" si le résultat correspond à l'attendu,
	 * et "Test Echoué" sinon. Elle gère également les exceptions attendues.
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param res la valeur attendue après avoir positionné le curseur sur le dernier élément
	 * @param erreur true si une exception est attendue (par exemple pour une liste vide)
	*/
	private void testCasFinListe(ListeChainee liste, Object res, boolean erreur) {
		try {
			liste.finListe();
			assertEquals("Echec du test : Liste invalide", liste.obtenirValeur(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (RuntimeException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	

	/**
	 * Teste la méthode suivant() de ListeChainee.
	 * 
	 * Cas normaux : déplacement vers l'élément suivant.
	 * Cas limite : courant déjà sur le dernier élément.
	 * Cas d'erreur : liste vide.
	*/
	@Test
	public void testSuivant() {
		System.out.println("\n\n=== Test de la méthode suivant() ===");
		
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(3);
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasSuivant(liste1, true, false);
		
		testCasSuivant(liste1, true, false);
		
		testCasSuivant(liste1, true, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasSuivant(liste2, false, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasSuivant(liste3, false, true);
		
	}
	
	
	/**
	 * Méthode helper pour tester la méthode suivant() sur une liste donnée.
	 * 
	 * Cette méthode déplace le curseur de la liste vers l'élément suivant
	 * et vérifie que le résultat (true si le déplacement a réussi, false sinon)
	 * correspond au résultat attendu. Elle affiche "Test Réussi" ou "Test Echoué"
	 * selon le résultat et gère les exceptions attendues.
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param res résultat attendu du déplacement (true si le curseur peut avancer, false sinon)
	 * @param erreur true si une exception est attendue (par exemple pour une liste vide)
	*/
	private void testCasSuivant(ListeChainee liste, boolean res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.suivant(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (RuntimeException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	

	
	/**
	 * Teste la méthode precedent() de ListeChainee.
	 * 
	 * Cas normaux : déplacement vers l'élément précédent.
	 * Cas limite : courant déjà sur le premier élément.
	 * Cas d'erreur : liste vide.
	*/
	public void testPrecedent() {
		System.out.println("\n\n=== Test de la méthode precedent() ===");
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(3);
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		liste1.finListe();
		testCasSuivant(liste1, true, false);
		
		liste1.precedent();
		testCasSuivant(liste1, true, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasSuivant(liste2, false, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasSuivant(liste3, false, true);
	}
	
	
	/**
	 * Méthode helper pour tester la méthode precedent() sur une liste donnée.
	 * 
	 * Cette méthode déplace le curseur de la liste vers l'élément précédent
	 * et vérifie que le résultat correspond au résultat attendu. Elle affiche 
	 * "Test Réussi" ou "Test Echoué" selon le résultat et gère les exceptions 
	 * attendues.
	 * 
	 * @param liste la liste chaînée sur laquelle effectuer le test
	 * @param res résultat attendu du déplacement (true si le curseur peut reculer, false sinon)
	 * @param erreur true si une exception est attendue (par exemple pour une liste vide)
	*/
	private void testCasPrecedent(ListeChainee liste, Object res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.precedent(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	
	/**
	 * Teste la méthode toString() de ListeChainee.
	 * 
	 * Cas normaux : liste avec plusieurs éléments.
	 * Cas limite : liste avec un seul élément.
	 * Cas d'erreur : liste vide.
	*/
	@Test
	public void testToString() {
		System.out.println("\n\n=== Test de la méthode toString() ===");
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasToString(liste1, "0, 1, 2", false);
		
		liste1.changerValeur("newData");
		testCasToString(liste1, "newData, 1, 2", false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasToString(liste2, "1", false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasToString(liste3, "", true);
	}
	
	
	/**
	 * Méthode helper pour tester la méthode toString() sur une liste donnée.
	 * 
	 * Cette méthode vérifie que la représentation en chaîne de caractères de 
	 * la liste correspond à la valeur attendue. Elle affiche "Test Réussi" 
	 * ou "Test Echoué" selon le résultat et gère les exceptions attendues.
	 * 
	 * @param liste la liste chaînée à tester
	 * @param res la chaîne attendue représentant la liste
	 * @param erreur true si une exception est attendue (par exemple pour une liste vide)
	*/
	private void testCasToString(ListeChainee liste, String res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.toString(), res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (RuntimeException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
	
	

	/**
	 * Teste la méthode obtenirValeurA() de ListeChainee.
	 * 
	 * Cas normaux : obtention de la valeur à un index valide.
	 * Cas limite : index 0 ou dernier index.
	 * Cas d'erreur : index invalide ou liste vide.
	*/
	@Test
	public void testObtenirValeurA() {
		System.out.println("\n\n=== Test de la méthode obtenirValeurA() ===");
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasObtenirValeurA(liste1, 2, 2, false);
		testCasObtenirValeurA(liste1, 1, 1, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		testCasObtenirValeurA(liste2, 0, 1, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasObtenirValeurA(liste1, 4, null, true);
		testCasObtenirValeurA(liste3, 0, null, true);
		
	}
	
	
	/**
	 * Méthode helper pour tester obtenirValeurA() sur une liste donnée.
	 * 
	 * Cette méthode vérifie que la valeur renvoyée par la liste à un index 
	 * donné correspond à la valeur attendue. Elle affiche "Test Réussi" ou 
	 * "Test Echoué" selon le résultat et gère les exceptions attendues.
	 * 
	 * @param liste la liste chaînée à tester
	 * @param index l'index de l'élément dont on souhaite obtenir la valeur
	 * @param res la valeur attendue à l'index donné
	 * @param erreur true si une exception est attendue (par exemple pour un index invalide)
	*/
	private void testCasObtenirValeurA(ListeChainee liste, int index, Object res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.obtenirValeurA(index),  res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
		    if (erreur) System.out.println("Test Réussi");
		    else System.out.println("Test Echoué");
		} catch (RuntimeException e) {
		    if (erreur) System.out.println("Test Réussi");
		    else System.out.println("Test Echoué");
		}
	}
	
	
	/**
	 * Teste la méthode VerifTaille() de ListeChainee.
	 * 
	 * Cas normaux : vérification de la taille correcte pour des listes non vides.
	 * Cas limite : liste vide.
	*/
	@Test
	public void testVerifTaille() {
		ListeChainee liste1 = new ListeChainee();
		liste1.inserer(2);
		liste1.inserer(1);
		liste1.inserer(0);
		
		ListeChainee liste2 = new ListeChainee();
		liste2.inserer(1);
		
		ListeChainee liste3 = new ListeChainee();
		
		//Cas normaux 
		System.out.println("\nCas normaux : ");
		testCasVerifTaille(liste1, true, false);
		testCasVerifTaille(liste2, true, false);
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		testCasVerifTaille(liste3, true, false);
	}
	
	
	/**
	 * Méthode helper pour tester VerifTaille() sur une liste donnée.
	 * 
	 * Cette méthode vérifie que la méthode VerifTaille() renvoie la valeur
	 * attendue (true si la taille est correcte, false sinon). Elle affiche 
	 * "Test Réussi" ou "Test Echoué" selon le résultat et gère les exceptions attendues.
	 * 
	 * @param liste la liste chaînée à tester
	 * @param res la valeur attendue renvoyée par VerifTaille()
	 * @param erreur true si une exception est attendue
	*/
	private void testCasVerifTaille(ListeChainee liste, boolean res, boolean erreur) {
		try {
			assertEquals("Echec du test : Liste invalide", liste.VerifTaille(),  res);
			
			if (!erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoué");
			
		} catch (IllegalArgumentException e) {
			
			if (erreur) System.out.println("Test Réussi");
			else System.out.println("Test Echoue");
		}
	}
}
