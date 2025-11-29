package structdonnees;

import ihm.TreeDraw;


/**
 * Cette classe implémente un arbre binaire de recherche. Chaque nœud de l’arbre contient une clé et une
 * donnée. La clé est unique dans l’arbre et permet d’identifier la donnée qui lui est associée.
 * @author M. Weis
 * @version 1.0
 *
 * @param <E> type de la clé (doit implémenter Comparable)
 * @param <T> type de la donnée
 */
public class ArbreBinaire<E extends Comparable<E>, T> implements Table<E, T> {
	
	private Noeud racine;
	
	/**
	 * constructeur de la classe ArbreBinaire
	 */
	public ArbreBinaire() {
		this.racine = null;
	}
	
	/**
	 * Cette méthode renvoie la racine de l’arbre. Renvoie null si l’arbre est vide
	 * @return la racine de l'arbre
	*/
	public Noeud obtenirLaRacine() {
		if (this == null) {
	        throw new NullPointerException("L'arbre est null");
	    }
		
		return this.racine;
	}
	
	/**
	 * Méthode principale pour tester la classe ArbreBinaire
	 * @param args arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		ArbreBinaire<Integer, String> arbre = new ArbreBinaire();
		
		arbre.inserer(10, "Ferran Torres");
	    arbre.inserer(15, "Lamine Yamal");
	    arbre.inserer(8, "Pedri");
	    arbre.inserer(20, "Gündogan");
		
		arbre.afficherArbre();
	}
	
	/**
	 * Cette méthode renvoie la donnée contenue dans le nœud correspondant à la clé de recherche cle passée
	 * en paramètre. Renvoie null si la clé n’existe pas
	 * @param cle clé de la valeur à obtenir 
	 * @return la valeur de la clé passé en paramètre 
	 */
	public T obtenir ( E cle ) {
		if (cle == null) throw new IllegalArgumentException("La clé ne peut pas être null");
		
		T ret = null;
		
		Noeud tmp = trouverNoeud(this.racine, cle);
		if (tmp != null) {
			ret = tmp.donnee;
		} 
		return ret;
	}
	
	/**
	 * Méthode récursive qui cherche le nœud correspondant à la clé passée en paramètre
	 * @param leNoeud nœud courant
	 * @param cle clé à chercher
	 * @return le nœud correspondant à la clé, ou null si la clé n'existe pas
	 */
	private Noeud trouverNoeud(Noeud leNoeud, E cle) {
		
		Noeud ret = null;
		
		if(leNoeud != null) {
			if (cle.compareTo(leNoeud.cle) == 0) {
				ret = leNoeud;
			} else if (cle.compareTo(leNoeud.cle) > 0) {
				ret = trouverNoeud(leNoeud.filsD, cle);
			} else if (cle.compareTo(leNoeud.cle) < 0) {
				ret = trouverNoeud(leNoeud.filsG, cle);
			}
		}
		
		return ret;
	}
	
	
	/**
	 * Si la clé n’existe pas déjà dans la table, cette méthode insert au bon endroit dans l’arbre un nouveau
	 * nœud dont la clé (cle) et la donnée (donnee) sont passées en paramètres. Renvoie faux si l’insertion
	 * n’est pas possible.
	 * @param cle clé à insérer 
	 * @param donnee donnée à insérer
	 * @return renvoie true si la clé a bien été insérée, false sinon 
	 */
	public boolean inserer(E cle, T donnee) {
		if (cle == null) throw new IllegalArgumentException("La clé ne peut pas être null");
	    if (donnee == null) throw new IllegalArgumentException("La donnée ne peut pas être null");
	    
		boolean ret = false;
		Noeud newNoeud = new Noeud(cle, donnee);
		if (this.racine == null) {
		    this.racine = new Noeud(cle, donnee);
		    ret = true;
		} else {
			Noeud pere = chercherPere(cle);
			if (pere != null) {
				if(newNoeud.cle.compareTo(pere.cle) < 0) {
					pere.filsG = newNoeud;
				} else if (newNoeud.cle.compareTo(pere.cle) > 0) {	
					pere.filsD = newNoeud;
				}
				newNoeud.pere = pere;
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * Calcule la hauteur de l'arbre
	 * @param leN nœud courant
	 * @return la hauteur de l'arbre
	 */
	private int calculerH(Noeud leN) {
		int ret = 0;
		if(leN != null) {
			ret = Math.max(calculerH(leN.filsG),calculerH(leN.filsD)) + 1;
		}
		return ret;
	}
	
	/**
	 * Vérifie si l'arbre est équilibré
	 * @return true si l'arbre est équilibré, false sinon
	 */
	public boolean isAvg() {
		return isAvg(this.racine);
	}
	
	/**
	 * Méthode récursive qui vérifie si l'arbre est équilibré
	 * @param noeud nœud courant
	 * @return true si l'arbre est équilibré, false sinon
	 */
	private boolean isAvg(Noeud noeud) {
		boolean ret = false;
		
		if (noeud == null) {
			ret = true;
		}
		
		else {
			int hG = calculerH(noeud.filsG);
			int hD = calculerH(noeud.filsD);
			
			if (Math.abs(hG + hD) > 1) {
				ret = false;
			} else {
				ret = isAvg(noeud.filsG) && isAvg(noeud.filsD);
			}
		}
		return ret;
	}
	
	
	
	/**
	 * Détruit de l’arbre binaire le nœud correspondant à la clé passée en paramètre. Renvoie faux si la
	 * destruction n’est pas possible (i.e. la clé n’existe pas).
	 * @param cle clé à supprimer de l'arbre 
	 * @return renvoie true si la clé a bien été supprimée, sinon false
	 */
	public boolean supprimer(E cle) {
		if (cle == null) throw new IllegalArgumentException("La clé ne peut pas être null");
		
		boolean ret = false;
		Noeud noeudASup = trouverNoeud(this.racine, cle);
		supprimer(noeudASup);
		if(noeudASup != null && obtenir(noeudASup.cle) == null) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 * Méthode récursive qui supprime le nœud passé en paramètre
	 * @param leNoeud nœud à supprimer
	 */
	private void supprimer(Noeud leNoeud) {
		if (leNoeud == null) {
	        throw new RuntimeException("Le nœud à supprimer n'existe pas");
	    }
		
		if(leNoeud.filsD == null && leNoeud.filsG == null) {
			if(leNoeud.pere == null) {
				this.racine = null;
			} else if (leNoeud.pere.filsD == leNoeud) {
				leNoeud.pere.filsD = null;
			} else {
				leNoeud.pere.filsG = null;
			}
		} else if (leNoeud.filsD != null && leNoeud.filsG != null) {
			Noeud noeudGrand = leNoeud.filsG;
			while(noeudGrand.filsD != null) {
				noeudGrand = noeudGrand.filsD;
			}
			leNoeud.cle = noeudGrand.cle;
			leNoeud.donnee = noeudGrand.donnee;
			supprimer(noeudGrand);
		} else {
			Noeud fils;
			if(leNoeud.filsG != null) fils = leNoeud.filsG;
			else fils = leNoeud.filsD;
			
			if (leNoeud.pere == null) { 
			    racine = fils;
			} else if(leNoeud.pere.filsG == leNoeud) {
				leNoeud.pere.filsG = fils;
				fils.pere = leNoeud.pere;
			} else {
				leNoeud.pere.filsD = fils;
				fils.pere = leNoeud.pere;
			}
		}
	}
	
	/**
	 * Méthode qui cherche le père du nœud où la nouvelle clé doit être insérée
	 * @param cle clé à insérer
	 * @return le père du nœud où la nouvelle clé doit être insérée, ou null si l'arbre est vide
	 */
	private Noeud chercherPere(E cle) {
		Noeud noeud = null;
		if (this.racine != null) {
			noeud = this.racine;
			boolean findPere = false;
			while(!findPere) {
				if(cle.compareTo(noeud.cle) == 0) {
					throw new RuntimeException("La clé existe déjà dans l'arbre !");
				} else if (cle.compareTo(noeud.cle) < 0) {
					if (noeud.filsG != null) {
						noeud = noeud.filsG;
					} else {
						findPere = true;
					}
				} else if (cle.compareTo(noeud.cle) > 0) {
					if (noeud.filsD != null) {
						noeud = noeud.filsD;
					} else {
						findPere = true;
					}
				}
			}
		}
		return noeud;
	}
	
	/**
	 * Renvoie une chaîne de caractères contenant les informations de tous les nœuds de l’arbre
	 * @param cle clé à insérer
	 * @return une chaîne de caractères 
	 */
	private String toString(Noeud leNoeud) {
		String infosNoeudG, infosNoeudD, infosNoeud ;
		String ret;
		
		if ( leNoeud != null ) {
			infosNoeudG = toString(leNoeud.filsG) ;
			infosNoeudD = toString(leNoeud.filsD) ;
			infosNoeud = new String("\nclé=" + leNoeud.cle.toString() + "\tdonnée=" +
			leNoeud.donnee.toString());
			ret = new String(infosNoeudG + infosNoeud + infosNoeudD) ;
		}
		else ret = new String ("") ;
		return ret ;
	}
	
	/**
	 * @return un arbre binaire qui est une copie de l’arbre courant
	 */
	public ArbreBinaire<E, T> cloner() {
		
		ArbreBinaire<E,T> arbre = new ArbreBinaire<>();
		if(this.racine != null) {
			arbre.racine = this.racine;
			fabriquerClone(this.racine, arbre.racine);
		}	
		return arbre;
	}
	
	/**
	 * Méthode récursive qui fabrique le clone de l'arbre courant
	 * @param noeudACopier nœud à copier
	 * @param nouveauPere nœud père du nœud à copier
	 */
	private void fabriquerClone(Noeud noeudACopier, Noeud nouveauPere) {
		if(noeudACopier != null) {
			if(noeudACopier.filsG != null) {
				nouveauPere.filsG = noeudACopier.filsG.cloner();
				nouveauPere.filsG.pere = nouveauPere;
				fabriquerClone(noeudACopier.filsG, nouveauPere.filsG.pere);
			} else if(noeudACopier.filsD != null) {
				nouveauPere.filsD = noeudACopier.filsD.cloner();
				nouveauPere.filsD.pere = nouveauPere;
				fabriquerClone(noeudACopier.filsD, nouveauPere.filsD.pere);
			}
		}
	}
	
	/**
	 * Affiche un arbre binaire à l'aide de la classe TreeDraw
	 */
	public void afficherArbre() {
		TreeDraw<E,T> tree = new TreeDraw<>(this.racine);
		
		tree.drawTree();
	}
	
	/**
	 * classe interne représentant un nœud de l'arbre binaire
	 */
	public class Noeud {
		// Attributs
		private Noeud filsG ; // fils gauche (null si pas de fils gauche)
		private Noeud filsD ; // fils droit (null si pas de fils droit)
		private Noeud pere ; // père (null si le nœud est racine)
		
		private T donnee ; // donnée stockée
		private E cle ; // clé unique
		
		/**
		 * Constructeur de la classe Noeud
		 * @param cle clé du nœud
		 * @param donnee donnée du nœud
		 */
		public Noeud (E cle, T donnee) {
			this.donnee = donnee;
			this.cle = cle;
			this.filsD = null;
			this.filsG = null;
			this.pere = null;
		}
		
		/**
		 * Renvoie la clé du nœud sous forme de chaîne de caractères
		 * @return la clé du nœud
		 */
		public String getLabel() { // accesseur de la clé
			return this.cle.toString();
		}

		/**
		 * Accesseur du fils gauche
		 * @return le fils gauche
		 */
		public Noeud getLeft() { // accesseur du fils gauche
			return this.filsG;
		}

		/**
		 * Accesseur du fils droit
		 * @return le fils droit
		 */
		public Noeud getRight() { // accesseur du fils droit
			return this.filsD;
		}
		
		/**
		 * Méthode qui clone le nœud courant
		 * @return une copie du nœud courant
		 */
		public Noeud cloner() { // duplication mémoire du nœud courant
			Noeud nouveauNoeud = new Noeud(this.cle, this.donnee);
			return nouveauNoeud;
		}
	}
}
