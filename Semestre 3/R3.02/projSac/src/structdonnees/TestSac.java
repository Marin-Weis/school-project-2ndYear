package structdonnees;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * Classe de test JUnit pour la classe Sac.
 * 
 * Les tests sont organisés par méthode de la classe Sac et couvrent :
 * - Cas normaux : fonctionnement attendu avec des entrées valides
 * - Cas limite : situations extrêmes, comme un sac vide
 * - Cas d'erreur : entrées nulles ou manipulation incorrecte provoquant une exception
 * 
 * Chaque méthode de test utilise des helpers pour afficher le résultat dans la console
 * avec System.out.println(), permettant de suivre l'avancement des tests.
 * 
 * Auteur : M.Weis
 * Version : 1.0
*/
public class TestSac {
	
	private Sac<String> sac;
	private Iterator<String> itr;
	
	@Before
    public void instancier() {
        this.sac = new Sac<>();
        
        sac.add("banane");
        sac.add("pomme");
        sac.add("myrtille");
        
        this.itr = sac.iterator();
    }
	
	/**
	 * Test du constructeur sac sans paramètres permettant d'initialiser un sac vide
	 */
	@Test
	public void testSac() {
		System.out.println("\n\n=== Test de la méthode Sac() ===");
		Sac<String> sac = new Sac<>();
		System.out.println("Test Réussi !");
	}
	
	/**
	 * Test du deuxième constructeur permettant d'initialiser un sac rempli aléatoirement par la collection passée en paramètre
	 */
	@Test
	public void testSacCollectionOfE() {
		System.out.println("\n\n=== Test de la méthode sacCollectionOfE() ===");
		List<String> liste = new ArrayList<>();
		
		liste.add("gomme");
		liste.add("stylo");
		liste.add("règle");
		
		Sac sac = new Sac(liste);
		System.out.println("Test Réussi !");
	}
	
	
	/**
	 * Test de la méthode size() de Sac.
	 * Vérifie la taille du sac pour :
	 * - des cas normaux (sac contenant plusieurs éléments)
	 * - des cas limites (sac vide)
	 * - des cas d'erreur (sac null)
	*/
	@Test
	public void testSize() {
		System.out.println("\n\n=== Test de la méthode size() ===");
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		testCasSize(sac, 3, false);
		sac.add("framboise");
		testCasSize(sac, 4, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		Sac<String> sacVide = new Sac<>();
		testCasSize(sacVide, 0, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasSize(null, 0, false);
	}
	
	/**
	 * méthode helper de testSize
	 * 
	 * @param sac sac à tester
	 * @param res taille attendu
	 * @param err erreur attendu ou non
	 */
	public void testCasSize(Sac<String> sac, int res, boolean err) {
		try {
			assertEquals("Echec du Test", res, sac.size());
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
			
		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		}
	}
	
	/**
	 * Test de la méthode add() de Sac.
	 * Vérifie l'ajout d'éléments dans le sac pour :
	 * - cas normaux (ajout d'éléments valides)
	 * - cas d'erreur (ajout d'éléments null ou sac null)
	*/
	@Test
	public void testAdd() {
		System.out.println("\n\n=== Test de la méthode add() ===");
		
		//Cas normal
		System.out.println("\nCas normaux : ");
		testCasAdd(sac, "poire", true, false);
		testCasAdd(sac, "pêche", true, false);
		
		//Cas erreur
		System.out.println("\nCas erreurs : ");
		testCasAdd(sac, null, false, true);
		testCasAdd(null, "pastèque", false, true);
	}
	
	
	/**
	 * Helper pour tester les cas d'ajout d'un élément dans le sac.
	 * @param sac sac à tester
	 * @param val élément à ajouter
	 * @param res résultat attendu (true si l'ajout doit réussir)
	 * @param err indique si une exception est attendue
	*/
	public void testCasAdd(Sac<String> sac, String val, boolean res, boolean err) {
		try {
			assertEquals("Echec du Test", res, sac.add(val));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
			
		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} catch (IllegalStateException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		}
	}

	/**
	 * Test de la méthode iterator() de Sac.
	 * Vérifie la création d'un itérateur sur le sac.
	*/
	@Test
	public void testIterator() {
		System.out.println("\n\n=== Test de la méthode iterator() ===");
		Iterator<String> itr = sac.iterator();
		System.out.println("Test Réussi !");
	}
	
	/**
	 * Test de la méthode isEmpty() de AbstractCollection.
	 * Vérifie si le sac est vide ou non.
	*/
	@Test
	public void testIsEmpty() {
		System.out.println("\n\n=== Test de la méthode isEmpty() ===");
		
		//Cas normal
		System.out.println("\nCas normal : ");
		testCasIsEmpty(sac, false, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		Sac<String> sac1 = new Sac<>();
		testCasIsEmpty(sac1, true, false);
		
		//Cas erreur 
		System.out.println("\nCas erreur : ");
		testCasIsEmpty(null, false, true);
	}
	
	
	/**
	 * Helper pour tester les cas de isEmpty().
	 * @param sac sac à tester
	 * @param res résultat attendu (true si le sac est vide)
	 * @param err indique si une exception est attendue
	*/
	public void testCasIsEmpty(Sac<String> sac, boolean res, boolean err) {
		try {
			assertEquals("Echec du Test", res, sac.isEmpty());
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
			
		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} 
	}
	
	/**
	 * Test de la méthode contains() de AbstractCollection.
	 * Vérifie la présence d'un élément pour :
	 * - cas normaux (éléments existants ou non)
	 * - cas limite (sac vide)
	 * - cas d'erreur (sac null)
	*/
	@Test 
	public void testContains() {
		System.out.println("\n\n=== Test de la méthode contains() ===");
		
		//Cas normaux 
		System.out.println("\nCas normaux : ");
		testCasContains(sac, "pomme", true, false);
		testCasContains(sac, "banane", true, false);
		testCasContains(sac, "kiwi", false, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		Sac<String> sac = new Sac<>();
		testCasContains(sac, "kiwi", false, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasContains(null, "", false, true);
	}
	
	
	/**
	 * Helper pour tester les cas de contains().
	 * @param sac sac à tester
	 * @param val élément dont la présence doit être vérifiée
	 * @param res résultat attendu (true si l'élément est présent)
	 * @param err indique si une exception est attendue
	*/
	public void testCasContains(Sac<String> sac, String val, boolean res, boolean err) {
		try {
			assertEquals("Echec du Test", res, sac.contains(val));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} 
	}
	
	/**
	 * Test de la méthode clear() de AbstractCollection.
	 * Vérifie la suppression de tous les éléments pour :
	 * - cas normaux (sac contenant des éléments)
	 * - cas limite (sac déjà vide)
	 * - cas d'erreur (sac null)
	*/
	@Test
	public void testClear() {
		System.out.println("\n\n=== Test de la méthode clear() ===");
		
		//Cas normal
		System.out.println("\nCas normaux : ");
		testCasClear(sac, true, false);
		sac.add("banane");
		testCasClear(sac, true, false);
		
		//Cas limite
		System.out.println("\nCas limite : ");
		Sac<String> sac1 = new Sac<>();
		testCasClear(sac1, true, false);
		
		//Cas erreur 
		System.out.println("\nCas erreur : ");
		testCasClear(null, false, true);
	}
	
	
	/**
	 * Helper pour tester les cas de clear().
	 * @param sac sac à tester
	 * @param res résultat attendu (true si le sac doit être vide après clear)
	 * @param err indique si une exception est attendue
	*/
	public void testCasClear(Sac<String> sac, boolean res, boolean err) {
		try {
			sac.clear();
			assertEquals("Echec du Test", res, sac.isEmpty());
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} 
	}
	
	
	/**
	 * Test de la méthode addAll() de AbstractCollection.
	 * Vérifie l'ajout de tous les éléments d'une collection dans le sac.
	*/
	@Test
	public void testAddAll() {
		System.out.println("\n\n=== Test de la méthode addAll() ===");
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		List<String> liste1 = Arrays.asList("kiwi", "ananas");
		testCasAddAll(sac, liste1, true, false);
		
		List<String> liste2 = Arrays.asList("framboise", "pastèque");
		testCasAddAll(sac, liste2, true, false);
		
		//Cas limite 
		System.out.println("\nCas limite : ");
		Sac<String> sacVide = new Sac<>();
		List<String> liste3 = Arrays.asList("carotte", "radis");
		testCasAddAll(sacVide, liste3, true, false);
		
		//Cas erreur
		System.out.println("\nCas erreur : ");
		testCasAddAll(null, liste3, false, true);
	}
	
	/**
	 * Helper pour tester les cas d'addAll().
	 * @param sac sac à tester
	 * @param c collection à ajouter
	 * @param res résultat attendu (true si succès)
	 * @param err erreur attendue ou non
	*/
	public void testCasAddAll(Sac<String> sac, Collection<String> c, boolean res, boolean err) {
		try {
			assertEquals("Echec du Test", res, sac.addAll(c));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} 
	}
	
	
	/**
	 * Helper pour tester les cas de removeAll().
	 * @param sac sac à tester
	 * @param c collection à supprimer
	 * @param res résultat attendu (true si au moins un élément supprimé)
	 * @param err erreur attendue ou non
	*/
	@Test
	public void testRemoveAll() {
		System.out.println("\n\n=== Test de la méthode removeAll() ===");
		
		//Cas normaux
		System.out.println("\nCas normaux : ");
		List<String> liste1 = Arrays.asList("banane", "myrtille");
		testCasRemoveAll(sac, liste1, true, false);
		
		List<String> liste2 = Arrays.asList("pomme");
		testCasRemoveAll(sac, liste2, true, false);
	
		testCasRemoveAll(sac, liste2, false, false);
		
		
		//Cas limite
		System.out.println("\nCas limite : ");
		Sac<String> sac1 = new Sac<>();
		sac1.add("new1");
		List<String> liste4 = Arrays.asList("new1");
		testCasRemoveAll(sac1, liste4, true, false);
		
		//Cas erreur 
		System.out.println("\nCas erreur : ");
		testCasRemoveAll(null, liste4, false, true);
		
	}
	
	
	/**
	 * Helper pour tester les cas de removeAll().
	 * @param sac sac à tester
	 * @param c collection d'éléments à supprimer
	 * @param res résultat attendu (true si au moins un élément a été supprimé)
	 * @param err indique si une exception est attendue
	*/
	public void testCasRemoveAll(Sac<String> sac, Collection<String> c, boolean res, boolean err) {
		try {
			assertEquals("Echec du Test", res, sac.removeAll(c));
			if(!err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} catch (NullPointerException e) {
			if(err) System.out.println("Test Réussi !");
			else System.out.println("Test Echoué !");
 		} 
	}
	
	
	/**
	 * Test de la méthode toArray() et toArray(T[]) de AbstractCollection.
	 * Vérifie la conversion du sac en tableau pour :
	 * - cas normaux (sac avec éléments)
	 * - cas limite (sac vide)
	 * - cas d'erreur (tableau ou sac null)
	*/
	@Test
	public void testToArray() {
		System.out.println("\n\n=== Test de la méthode toArray() ===");
	    // Cas normal
		System.out.println("\nCas normal : ");
	    testCasToArray(sac, new Object[]{"banane", "pomme", "myrtille"}, false);
	    
	    // Cas limite : sac vide
	    System.out.println("\nCas limite : ");
	    Sac<String> sacVide = new Sac<>();
	    testCasToArray(sacVide, new Object[]{}, false);
	    
	    //Cas erreur
	    System.out.println("\nCas erreur : ");
	    testCasToArray(sacVide, null, true);
	    testCasToArray(null, new Object[]{}, true);
	}
	
	
	/**
	 * Helper pour tester les cas de toArray().
	 * @param sac sac à tester
	 * @param res tableau attendu
	 * @param err indique si une exception est attendue
	*/
	public void testCasToArray(Sac<String> sac, Object[] res, boolean err) {
	    try {
	        Object[] result = sac.toArray();
	        Arrays.sort(result);
	        Arrays.sort(res);
	        
	        assertArrayEquals("Echec du Test", res, result);
	        
	        if(!err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    } catch (NullPointerException e) {
	        if(err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    }
	}
	
	

	/**
	 * Helper pour tester les cas de remove().
	 * @param sac sac à tester
	 * @param o élément à supprimer
	 * @param res résultat attendu (true si l'élément a été supprimé)
	 * @param err indique si une exception est attendue
	*/
	@Test
	public void testToArrayTyped() {
		System.out.println("\n\n=== Test de la méthode toArrayTyped() ===");
	    // Cas normal
		System.out.println("\nCas normal : ");
	    testCasToArrayTyped(sac, new String[]{"banane", "pomme", "myrtille"}, false);

	    // Cas limite : sac vide
	    System.out.println("\nCas limite : ");
	    Sac<String> sacVide = new Sac<>();
	    testCasToArrayTyped(sacVide, new String[]{}, false);

	    // Cas erreur
	    System.out.println("\nCas erreur : ");
	    testCasToArrayTyped(sac, null, true);
	}
	
	
	/**
	 * Helper pour tester les cas de toArray(T[]).
	 * @param sac sac à tester
	 * @param res tableau attendu
	 * @param err erreur attendue ou non
	*/
	public void testCasToArrayTyped(Sac<String> sac, String[] res, boolean err) {
	    try {
	        String[] resultat = sac.toArray(new String[0]);

	        // Convertir en listes pour utiliser assertEquals
	        List<String> attendu = new ArrayList<>(Arrays.asList(res));
	        List<String> obtenu = new ArrayList<>(Arrays.asList(resultat));

	        // Trier pour ignorer l'ordre
	        Collections.sort(attendu);
	        Collections.sort(obtenu);

	        assertEquals("Echec du Test", attendu, obtenu);

	        if (!err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    } catch (RuntimeException e) {
	        if (err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    }
	}
	
	
	
	/**
	 * Test de la méthode remove() de AbstractCollection.
	 * Vérifie la suppression d'éléments individuels du sac.
	*/
	@Test
	public void testRemove() {
		System.out.println("\n\n=== Test de la méthode remove() ===");
	    // Cas normaux
		System.out.println("\nCas normaux : ");
	    testCasRemove(sac, "banane", true, false);
	    testCasRemove(sac, "pomme", true, false);

	    // Cas limite
	    System.out.println("\nCas limite : ");
	    Sac<String> sacVide = new Sac<>();
	    testCasRemove(sacVide, "banane", false, false);

	    // Cas erreur
	    System.out.println("\nCas erreur : ");
	    testCasRemove(sac, null, false, true);
	}
	

	/**
	 * Helper pour tester les cas de remove().
	 * @param sac sac à tester
	 * @param o élément à supprimer
	 * @param res résultat attendu (true si l'élément était présent et supprimé)
	 * @param err erreur attendue ou non
	*/
	public void testCasRemove(Sac<String> sac, Object o, boolean res, boolean err) {
	    try {
	        assertEquals("Echec du Test", res, sac.remove(o));
	        if(!err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    } catch (UnsupportedOperationException | NullPointerException | ClassCastException e) {
	        if(err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    }
	}
	
	
	/**
	 * Test de la méthode containsAll() de AbstractCollection.
	 * Vérifie si le sac contient tous les éléments d'une collection donnée.
	*/
	@Test
	public void testContainsAll() {
		System.out.println("\n\n=== Test de la méthode containsAll() ===");
	    // Cas normaux
		System.out.println("\nCas normaux : ");
	    List<String> liste1 = Arrays.asList("banane", "pomme");
	    testCasContainsAll(sac, liste1, true, false);

	    List<String> liste2 = Arrays.asList("banane", "fraise");
	    testCasContainsAll(sac, liste2, false, false);

	    // Cas limite
	    System.out.println("\nCas limite : ");
	    Sac<String> sacVide = new Sac<>();
	    List<String> liste3 = Arrays.asList();
	    testCasContainsAll(sacVide, liste3, true, false);

	    // Cas erreur
	    System.out.println("\nCas erreur : ");
	    testCasContainsAll(sac, null, false, true);
	}
	
	
	/**
	 * Helper pour tester les cas de containsAll().
	 * @param sac sac à tester
	 * @param c collection à vérifier
	 * @param res résultat attendu (true si tous les éléments présents)
	 * @param err erreur attendue ou non
	*/
	public void testCasContainsAll(Sac<String> sac, Collection<?> c, boolean res, boolean err) {
	    try {
	        assertEquals("Echec du Test", res, sac.containsAll(c));
	        if(!err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    } catch (NullPointerException | ClassCastException e) {
	        if(err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    }
	}
	
	
	/**
	 * Test de la méthode retainAll() de AbstractCollection.
	 * Cette méthode vérifie que le sac ne conserve que les éléments
	 * présents dans la collection passée en paramètre.
	*/
	@Test
	public void testRetainAll() {
		System.out.println("\n\n=== Test de la méthode retainAll() ===");
	    // Cas normaux
		System.out.println("\nCas normaux : ");
	    List<String> liste1 = Arrays.asList("banane");
	    testCasRetainAll(sac, liste1, true, false);

	    List<String> liste2 = Arrays.asList("banane", "pomme", "myrtille");
	    testCasRetainAll(sac, liste2, false, false);

	    // Cas limite
	    System.out.println("\nCas limite : ");
	    Sac<String> sacVide = new Sac<>();
	    List<String> liste3 = Arrays.asList("banane");
	    testCasRetainAll(sacVide, liste3, false, false);

	    // Cas erreur
	    System.out.println("\nCas erreur : ");
	    testCasRetainAll(sac, null, false, true);
	}
	

	/**
	 * Helper pour tester les cas de retainAll().
	 * @param sac sac à tester
	 * @param c collection à conserver
	 * @param res résultat attendu (true si le sac a été modifié)
	 * @param err erreur attendue ou non
	*/
	public void testCasRetainAll(Sac<String> sac, Collection<?> c, boolean res, boolean err) {
	    try {
	        assertEquals("Echec du Test", res, sac.retainAll(c));
	        if(!err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    } catch (UnsupportedOperationException | NullPointerException | ClassCastException e) {
	        if(err) System.out.println("Test Réussi !");
	        else System.out.println("Test Echoué !");
	    }
	}
}
