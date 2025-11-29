package structdonnees;


/**
 * Interface pour une liste chaînée.
 * 
 * Auteur : M.Weis
 * Version : 1.0
*/
public interface Liste {
	
	/**
	 * Insère un élément à la position courante.
	 * @param data l'élément à insérer (ne peut pas être null)
	*/
	public void inserer(Object data);
	
	/**
	 * Supprime l'élément courant.
	 * @return true si la suppression a réussi
	*/
	public boolean supprimer();
	
	/**
	 * Vérifie si un élément est présent.
	 * @param data l'élément à rechercher
	 * @return true si présent, false sinon
	*/
	public boolean contient(Object data);
	
	/**
	 * Ajoute un élément à un indice donné.
	 * @param index l'indice où insérer l'élément (0 &lt;= index &lt; taille)
	 * @param data élément à ajouter (ne peut pas être null)
	*/
	public void ajouter(int index, Object data);
	
	/**
	 * Retourne l'élément courant.
	 * @return l'élément courant
	*/
	public Object obtenirValeur () ;
	

	/**
	 * Change la valeur de l'élément courant.
	 * @param newData nouvelle valeur (ne peut pas être null)
	*/
	public void changerValeur(Object newData);
	
	/**
	 * Indique si la liste est vide.
	 * @return true si la liste ne contient aucun élément
	*/
	public boolean estVide();
	
	/**
	 * Retourne le nombre d'éléments de la liste.
	 * @return taille de la liste
	*/
	public int obtenirTaille();

}


