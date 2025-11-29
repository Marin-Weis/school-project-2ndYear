package structdonnees;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * La classe Sac :
 * • la liste est simplement chaînée (déplacement dans 1 seul sens), elle contient un nombre d'éléments égale à
 * taille,
 * • le premier élément est fictif (c'est un marqueur de début de liste sur lequel on positionne le curseur pour
 * parcourir toute la liste, il ne fait pas réellement partie de la liste), il s'appelle sentinel,
 * • le dernier élément est le seul qui possède un suivant qui pointe sur sentinel,
 * • un nouvel élément ajouté à la liste s'insère toujours à la gauche d’un index compris entre 0 et taille, cet
 * index étant tiré aléatoirement entre les 2 bornes (0 &le; index &le; taille),
 * • chaque élément de la liste possède une valeur donnee d’un type générique défini par E. La recherche d'un
 * élément dans la liste se fait par comparaison avec cette valeur
 * 
 * Auteur : 
 * Version : 1.0
*/
public class Sac<E> extends AbstractCollection<E> {
	
	private Element sentinel;
	private int taille;
	private int comptModif;
	
	/**
	 * création de sentinel (qui pointe sur elle-même) et taille = 0
	 */
	public Sac() {
		this.sentinel = new Element(null, null);
		this.sentinel.suiv = this.sentinel;
		this.taille = 0;
		this.comptModif = 0;
	}
	
	
	/**
	 * créer une liste vide (en reprenant le code du constructeur d’une liste vide Sac()),
	 * ajouter dans cette liste, en appelant la méthode boolean add(E o) de la classe Sac,
	 * chaque élément de la Collection c passée en paramètre
	 * @param c Collection contenant des éléments à insérer dans le sac
	 */
	public Sac(Collection<E> c) {
		this.sentinel = new Element(null, null);
		this.sentinel.suiv = this.sentinel;
		this.taille = 0;
		this.comptModif = 0;
		
		for (E i : c) {
			this.add(i);
		}
	}
	
	
	/**
	 * @return renvoie la taille de la liste
	 */
	public int size() {
		return this.taille;
	}
	
	/**
	 * Ajoute un élément dans le sac à une position aléatoire.
	 * 
	 * @param o l'élément à ajouter (ne peut pas être null)
	 * @return true si l'élément a été ajouté avec succès
	 * @throws NullPointerException si o est null
	*/
	public boolean add(E o) {
		if(o==null) throw new NullPointerException("La donnée ne peut pas être null");
		
		boolean ret = false;
		
		if (this.taille < Integer.MAX_VALUE) {
			
			int index;
			
			if (this.taille==0) index=0;
			else index=(int)(Math.random() * (this.taille+1));
			
			Element tmp = this.sentinel;
			
			for (int i=0; i<index; i++) {
				tmp = tmp.suiv;
			}
			
			Element newElem = new Element(o, tmp.suiv);
			tmp.suiv = newElem;
			ret = true;
			this.taille++;
			
			comptModif++;
		}
		
		
		assert (this.invariant()) : "Invariant violé !";
		return ret;
	}
	
	private class Element {

		Element suiv ;
		E donnee ; 
		
		/**
		 * Constructeur d’un élément de la liste
		 * @param donnee donnée de l'élément
		 * @param suiv élément suivant de l'élement
		 */
		Element ( E donnee, Element suiv ) {
			this.suiv = suiv;
			this.donnee = donnee;
		}
	}
	
	/**
	 * renvoie un nouvel objet de type java.util.Iterator (interface Java).
	 * Cet objet Iterator, renvoyé à la classe utilisatrice de la liste chaînée, va lui permettre (à la classe
	 * utilisatrice) d’effectuer 3 opérations sur cette liste
	 * 
	 * @return nouvel itérateur
	 */
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	/**
	 * Classe objet itérator
	 */
	private class Itr implements Iterator<E> {
		private Element courant;
		private Element precCourant;
		private int ComptModifAttendu;
		
		
		/**
		 * constructeur de itérateur
		 */
		public Itr() {
			this.courant = sentinel;
			this.precCourant = sentinel;
			this.ComptModifAttendu = comptModif;
		}
		
		/**
		 * Renvoie l’élément suivant du sac et avance l’itérateur.
		 *
		 * @return l’élément suivant de type E
		 * @throws NoSuchElementException si aucun élément suivant n’est disponible
		 * @throws ConcurrentModificationException si le sac a été modifié depuis la création de l’itérateur
		*/
		public E next() {
			if (ComptModifAttendu != comptModif) throw new java.util.ConcurrentModificationException("Erreur de synchronisation !");
			
			if (!hasNext()) throw new NoSuchElementException("Plus d'éléments !");
			
			this.precCourant = this.courant;
			this.courant = this.courant.suiv;
			return this.courant.donnee;
		}
		
		/**
		 * Déplace l’itérateur sur son voisin de droite et renvoie la donnée E du nouvel élément
		 * 
		 * @throws ConcurrentModificationException si la liste a été modifiée par un autre itérateur
		 * @throws IllegalStateException si remove() est appelé sans appel préalable à next()
		 */
		public void remove() {
			if (ComptModifAttendu != comptModif) {
				throw new java.util.ConcurrentModificationException("Erreur de synchronisation !");
			}
			
			if (this.courant == this.precCourant) {
			    throw new IllegalStateException("remove() appelé avant next() !");
			} else {
				this.precCourant.suiv = this.courant.suiv;
				this.courant = this.precCourant;
				taille--;
				comptModif++;
				this.ComptModifAttendu = comptModif;
				assert (Sac.this.invariant()) : "Invariant violé !";
			}
		}
		
		/**
		 * renvoie vrai si l’itérateur n’est pas en fin de liste
		 * 
		 * @throws ConcurrentModificationException si il y a une erreur de synchronisation
		 * @return renvoie true si l'itérateur n'est pas en fin de liste, sinon false
		*/
		public boolean hasNext() {
			if (ComptModifAttendu != comptModif) {
				throw new java.util.ConcurrentModificationException("Erreur de synchronisation !");
			}
			
			boolean ret = false;
			if(this.courant.suiv != sentinel) {
				ret = true;
			}
			return ret;
		}
	}
	
	/**
	 * méthode private invariant 
	 * @return true s'il y a une erreur, sinon false
	 */
	private boolean invariant() {
		boolean ret = true;
		if (this.taille < 0) {
			ret = false;
			System.out.println("La taille est négatif");
		}
		else if(this.sentinel == null) {
			ret = false;
			System.out.println("Le sentinel est nul");
		}
		return ret;
	}
}
