/**
 * Classe principale pour tester le scénario d'emprunt et de réservation de livres.
 * @author Marin WEIS
 * BUT2 R2.04
 * TP2
 * Groupe C1
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Un utilisateur premium essaie d’emprunter un livre non disponible, le réserve,
puis est notifié quand le livre est retourné par un autre utilisateur.
         */

        Library library = new Library();
        Book book1 = new Book("1984 by George Orwell");
        User premiumUser = new User("Vincent", true);
        User regularUser = new User("Dylan ", false);

        library.addBook(book1, 1);

        // Dylan emprunte le livre
        regularUser.borrowBook(book1, library);

        // Vincent essaie d'emprunter le même livre, mais il n'est pas disponible
        premiumUser.borrowBook(book1, library);

        // Dylan retourne le livre
        library.returnBook(book1);
    }
}
