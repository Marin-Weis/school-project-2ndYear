package structdonnees;
import structdonnees.Liste;


/**
 * Classe représentant une liste chaînée doublement liée avec un élément sentinelle.
 * Permet d'insérer, supprimer, accéder et modifier des éléments.
 * Maintient un élément courant pour faciliter la navigation dans la liste.
 * Fournit des méthodes pour vérifier la taille, savoir si la liste est vide et convertir la liste en chaîne de caractères.
 * 
 * Auteur : M.Weis
 * Version : 1.0
 */
public class ListeChainee implements Liste {
	
	// Attributs
	
	/** Élément sentinelle pour gérer les extrémités de la liste */
	private Element sentinel ; // pointe sur l’élément sentinelle
	
	/** Élément courant sur lequel les opérations sont effectuées */
	private Element courant ; // pointe sur l’élément courant
	
	/** Nombre d'éléments dans la liste */
	private int taille ; // nombre d’éléments dans la liste
	
	
	/**
     * Crée une nouvelle liste chaînée vide.
    */
	public ListeChainee() {	
		this.taille = 0;
		this.sentinel = new Element(null, null, null);
	    this.sentinel.prec = this.sentinel;
	    this.sentinel.suiv = this.sentinel;
		this.courant = this.sentinel;
		
		//post-condition
		assert (this.courant == this.sentinel) : "Le courant n'est pas référencé sur le sentinelle alors que le tableau est égale à 0";
	}
	
	/**
     * Insère un élément à la position courante de la liste.
     *
     * @param data la valeur à insérer (ne peut pas être null)
     * @throws IllegalArgumentException si data est null
    */
	@Override
	public void inserer(Object data) {
		
		//pré-condition
		if (data == null) {
			throw new IllegalArgumentException("La donnée ne peut pas être null");
		}
				
		Element newElement;
		
		if (taille==0) {
			newElement = new Element(this.sentinel, this.sentinel, data);
			this.sentinel.prec = newElement;
			this.sentinel.suiv = newElement;
			this.courant = newElement;
		}
		
		else {
			newElement = new Element(this.courant.prec, this.courant, data);
			this.courant.prec.suiv = newElement;
			this.courant.prec = newElement;
			this.courant = newElement;
		}
		
		taille+=1;
		
		//post-condition
		assert (VerifTaille() == true) : "La taille n'est pas égale au nombres de variables dans la liste !";
		
		
		assert (this.invariant()) : "Invariant violé !";
	}
	
	
	/**
     * Supprime l'élément courant de la liste.
     *
     * @return true si la suppression a réussi, false sinon
     * @throws NullPointerException si la liste est vide
    */
	@Override
	public boolean supprimer() {
		boolean ret = false;
		
		//pré-condition
		if (taille == 0) {
			throw new NullPointerException("Le tableau est vide");
		}
		
		else if (taille == 1) {
			this.courant = this.sentinel;
			this.sentinel.prec = this.sentinel;
			this.sentinel.suiv = this.sentinel;
			ret = true;
		}
		
		else if (taille > 1) {
			this.courant.suiv.prec = this.courant.prec;
			this.courant.prec.suiv = this.courant.suiv;
			if (this.courant.prec == this.sentinel) {
				this.courant = courant.suiv;
			}
			else {
				this.courant = this.courant.prec;
			}
			ret = true;
		}
		
		taille-=1;
		
		//post-condition
		assert (VerifTaille() == true) : "La taille n'est pas égale au nombres de variables dans la liste !";
		
		assert (this.invariant()) : "Invariant violé !";
		
		return ret;
	}
	
	
	
	/**
     * Vérifie si la liste contient un élément donné.
     *
     * @param data la valeur à rechercher (ne peut pas être null)
     * @return true si l'élément est présent, false sinon
     * @throws IllegalArgumentException si data est null
    */
	@Override
	public boolean contient(Object data) {
		boolean ret = false;
		
		//pré-condition
		if (data == null) {
			throw new IllegalArgumentException("La donnée ne peut pas être null");
		}
		
		int i = 1;
		Element tmp = this.sentinel.suiv;
		while (i <= this.taille) {
			if (tmp.data.equals(data)) {
				ret = true;
			}
			i++;
			tmp = tmp.suiv;
		}
		
		assert (this.invariant()) : "Invariant violé !";
		
		return ret;
	}
	
	
	
	/**
     * Ajoute un élément à une position spécifique dans la liste.
     *
     * @param index l'indice où insérer l'élément (0 &lt;= index &lt; taille)
     * @param data la valeur à insérer (ne peut pas être null)
     * @throws IllegalArgumentException si index est invalide ou data est null
    */
	@Override
	public void ajouter(int index, Object data) {
		
		//pré-condition
		if (index < 0 || index >= this.taille) {
		    throw new IllegalArgumentException("Indice inexistant !");	
		} else if (data == null) {
			throw new IllegalArgumentException("Data null !");
		}
		
		Element tmp = this.sentinel.suiv;
		for (int i=0; i<index; i++) {
			tmp = tmp.suiv;
		}
		
		Element newElem = new Element(tmp.prec, tmp, data);
		tmp.prec.suiv = newElem;
		tmp.prec = newElem;
		this.courant = newElem;
		
		taille+=1;
		
		//post-condition
		assert (VerifTaille()) : "La taille n'est pas égale au nombres de variables dans la liste !";
		
		assert (this.invariant()) : "Invariant violé !";
	}
	
	
	/**
     * Retourne la valeur de l'élément courant.
    *
    * @return la valeur courante
    * @throws RuntimeException si la liste est vide
    */
	@Override
	public Object obtenirValeur() {
		
		if (this.taille == 0) {
			throw new RuntimeException("Le tableau est vide !");
		}
		
		return this.courant.data;
	}
	
	
	/**
     * Change la valeur de l'élément courant.
     *
     * @param newData la nouvelle valeur (ne peut pas être null)
     * @throws IllegalArgumentException si newData est null
     * @throws RuntimeException si la liste est vide
    */
	@Override
	public void changerValeur(Object newData) {
		
		if (this.taille == 0) {
			throw new RuntimeException("Le tableau est vide !");
		} else if (newData == null) {
			throw new IllegalArgumentException("La donnée ne peut pas être null");
		}
		
		this.courant.data = newData;
		
		assert (this.invariant()) : "Invariant violé !";
	}
	
	
	/**
     * Vérifie si la liste est vide.
     *
     * @return true si la liste ne contient aucun élément
    */
	@Override
	public boolean estVide() {
		assert (this.invariant()) : "invariant violé !";
		return this.taille == 0;
	}
	
	/**
     * Retourne le nombre d'éléments dans la liste.
     *
     * @return la taille de la liste
    */
	@Override
	public int obtenirTaille() {
		assert (this.invariant()) : "invariant violé !";
		return this.taille;
	}
	
	/**
     * Place le courant sur le premier élément de la liste.
     *
     * @throws RuntimeException si la liste est vide
    */
	public void teteListe() {
		
		if (this.taille == 0) {
			throw new RuntimeException("Le tableau est vide !");
		}
		
		this.courant = this.sentinel.suiv;
	} 
	
	/**
     * Place le courant sur le dernier élément de la liste.
     *
     * @throws RuntimeException si la liste est vide
    */
	public void finListe() {
		
		if (this.taille == 0) {
			throw new RuntimeException("Le tableau est vide !");
		}
		
		this.courant = this.sentinel.prec;
	} 
	
	/**
     * Déplace le courant vers l'élément suivant.
     *
     * @return true si le déplacement est possible, false si le courant est déjà sur le dernier élément
     * @throws RuntimeException si la liste est vide
    */
	public boolean suivant() {
		
		//pré-condition
		if (this.taille == 0) {
			throw new RuntimeException("Le tableau est vide !");
		}
		
		boolean ret = false;
		
		if (this.courant.suiv != this.sentinel) {
			this.courant = this.courant.suiv;
			ret = true;
		}
		
		return ret;
	} 
	
	/**
     * Déplace le courant vers l'élément précédent.
     *
     * @return true si le déplacement est possible, false si le courant est déjà sur le premier élément
     * @throws RuntimeException si la liste est vide
    */
	public boolean precedent() {
		
		//pré-condition
		if (this.taille == 0) {
			throw new RuntimeException("Le tableau est vide !");
		}
		
		boolean ret = false;
		
		if (this.courant.prec != this.sentinel) {
			this.courant = this.courant.prec;
			ret = true;
		}
		
		return ret;
	} 
	
	
	/**
     * Retourne la représentation sous forme de chaîne de caractères de la liste.
     *
     * @return les éléments séparés par des virgules
    */
	public String toString() {
		String ret = "";
		
		Element tmp = this.sentinel.suiv;
		for(int i=1; i<this.taille; i++) {
			ret+=tmp.data.toString() + ", ";
			tmp = tmp.suiv;
		}
		ret+=tmp.data.toString();
		
		return ret;
	} 
	
	
	/**
     * Retourne la valeur à l'indice spécifié.
     *
     * @param index l'indice de l'élément
     * @return la valeur à l'indice
     * @throws IllegalArgumentException si l'indice est invalide
     * @throws RuntimeException si la liste est vide
    */
	public Object obtenirValeurA(int index) {
		
		//pré-condition
		if (index > this.taille) {
			throw new IllegalArgumentException("l'indice est inexistant");
		} else if (this.taille == 0) {
			throw new RuntimeException("l'indice est inexistant");
		}
		
		Element tmp = this.sentinel.suiv;
		int i = 0;
		while (i < index) {
			tmp = tmp.suiv;
			i++;
		}
		
		return tmp.data;
	}
	
	/**
     * Vérifie si la taille interne correspond au nombre réel d'éléments.
     *
     * @return true si la taille est correcte
    */
	public boolean VerifTaille() {
		boolean ret = false;
		
		Element tmp = this.sentinel.suiv;
		int cpt = 0;
		
		while(tmp != this.sentinel) {
			cpt++;
			tmp = tmp.suiv;
		}
		
		if (this.taille == cpt) {
			ret = true;
		}
		
		return ret;
	}
	
	private class Element {
		
		Element prec ;
		Element suiv ; 
		Object data ; 
		
		
		Element (Element prec, Element suiv, Object donnee) {
			this.prec = prec;
			this.suiv = suiv;
			this.data = donnee;
		}
		// Pas de modificateurs ni accesseurs car attributs visibles par
		// ListeChainee
	}
	
	private boolean invariant() {
		boolean ret = true;
		
		if (this.taille < 0) {
			ret = false;
			System.out.println("La taille est négatif");
		}
		else if(this.sentinel == null) {
			ret = false;
			System.out.println("Le sentinel est différent de nul");
		}
		else if (this.taille == 0 && this.courant != this.sentinel) {
			ret = false;
			System.out.println("Le courant est placé sur un élément inexistant");
		}
			
		return ret;
	}
}
