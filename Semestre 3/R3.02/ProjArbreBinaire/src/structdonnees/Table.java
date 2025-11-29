package structdonnees;

/**
 * Interface représentant une table de données avec des opérations de base telles que l'obtention, l'insertion et la suppression.
 * @param <E> type de la clé (doit implémenter Comparable)
 * @param <T> type de la donnée
 * 
 * @version 1.0
 * @author M. Weis
 */
public interface Table<E extends Comparable<E>, T> {
	
	
	/**
	 * Cette méthode renvoie la donnée contenue dans le nœud correspondant à la clé de recherche cle passée
	 * en paramètre. Renvoie null si la clé n’existe pas
	 * @param cle clé de la valeur à obtenir 
	 * @return la valeur de la clé passé en paramètre 
	 */
	public T obtenir ( E cle ) ;
	
	
	/**
	 * Si la clé n’existe pas déjà dans la table, cette méthode insert au bon endroit dans l’arbre un nouveau
	 * nœud dont la clé (cle) et la donnée (donnee) sont passées en paramètres. Renvoie faux si l’insertion
	 * n’est pas possible.
	 * @param cle clé à insérer 
	 * @param donnee donnée à insérer
	 * @return renvoie true si la clé a bien été insérée, false sinon 
	 */
	public boolean inserer ( E cle, T donnee ) ;
	
	
	/**
	 * Détruit de l’arbre binaire le nœud correspondant à la clé passée en paramètre. Renvoie faux si la
	 * destruction n’est pas possible (i.e. la clé n’existe pas).
	 * @param cle clé à supprimer de l'arbre 
	 * @return renvoie true si la clé a bien été supprimée, sinon false
	 */
	public boolean supprimer ( E cle ) ;
	
}
