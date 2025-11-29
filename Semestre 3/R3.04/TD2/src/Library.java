// Library.java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe représentant une bibliothèque avec des livres, des emprunts et des réservations.
 * Les méthodes permettent de gérer l'inventaire des livres, les emprunts, les retours, les pénalités et les réservations.
 * Les attributs incluent un inventaire des livres, une liste des emprunts actifs et une liste des réservations.
 * @author Marin WEIS
 * BUT2 R2.04
 * TP2
 * Groupe C1
*/
public class Library {
    private HashMap<Book, Integer> inventory = new HashMap<>();
    private Map<Book, List<Reservation>> reservations = new HashMap<>();
    private List<Loan> activeLoans = new ArrayList<>();

    /**
     * Méthode pour ajouter des livres à l'inventaire
     * @param book
     * @param quantity
     */
    public void addBook(Book book, int quantity) {
        inventory.put(book, inventory.getOrDefault(book, 0) + quantity);
    }

    /**
     * Méthode pour vérifier si un livre est disponible
     * @param book
     * @return
     */
    public boolean isBookAvailable(Book book) {
        return inventory.getOrDefault(book, 0) > 0;
    }

    /**
     * Méthode pour prêter un livre à un utilisateur
     * @param user
     * @param book
     * @param date
     */
    public void lendBook(User user, Book book, LocalDate date) {
        // Vérifier la disponibilité du livre
        if (isBookAvailable(book)) {
            int bookBorrowed = 0;
            // Compter le nombre de livres actuellement empruntés par l'utilisateur
            for(int i=0; i<user.getSaveLoanHistory().size(); i++) {
                if(!user.getSaveLoanHistory().get(i).isReturned()) {
                    bookBorrowed++;
                }
            }
            // Vérifier si l'utilisateur peut emprunter plus de livres
            if (canBorrowMoreBooks(user, bookBorrowed)) {
                inventory.put(book, inventory.get(book) - 1);
                // Créer un nouvel emprunt
                Loan loan = new Loan(user, book, date, user.isPremium() ? date.plusDays(42) : date.plusDays(14), false);
                activeLoans.add(loan);
                user.addLoanToHistory(loan);
                System.out.println(user.getName() + ", vous avez emprunté le livre: " + book.getTitle() + " pour une durée de " + (user.isPremium() ? "42" : "14") + " jours. Bonne lecture!");
            } else {
                System.out.println("Vous avez atteint votre limite d'emprunts.");
            }
        } else {
            // Le livre n'est pas disponible, créer une réservation
            Reservation reservation = new Reservation(user, book, date);
            addReservation(reservation);
            System.out.println("Désolée , " + user.getName() + ". Le livre n'est pas disponible. Vous êtes sur la liste d'attente.");
        }
    }

    /**
     * Méthode pour le retour d’un livre
     * @param book
     */
    public void returnBook(Book book) {
        if(!isBookAvailable(book) && reservations.containsKey(book) && !reservations.get(book).isEmpty()) {
            Reservation reservation = reservations.get(book).get(0);
            // Notifier l'utilisateur qui a réservé le livre
            System.out.println("Notification: " + reservation.getUser().getName() + ", le livre " + book.getTitle() + " que vous avez réservé est maintenant disponible pour emprunt.");
            reservations.get(book).remove(0);
        } else {
            inventory.put(book, inventory.getOrDefault(book, 0) + 1);
        }
    }

    /**
     * Méthode pour imposer une pénalité à un utilisateur
     * @param user
     * @param reason
     */
    public void imposePenalty(User user, String reason) {
        System.out.println("Pénalité imposé : " + user.getName() + " for: " + reason);
    }

    /**
     * Méthode pour vérifier si un utilisateur peut emprunter plus de livres
     * @param user
     * @param currentBorrowedBooks
     * @return
     */
    public boolean canBorrowMoreBooks(User user, int currentBorrowedBooks) {
        // Définir la limite d'emprunt en fonction du type d'utilisateur (premium ou non)
        int limit = user.isPremium() ? 15 : 5;
        return currentBorrowedBooks < limit;
    }

    /**
     * Méthode pour ajouter une réservation
     * @param reservation
     */
    public void addReservation(Reservation reservation) {
        Book book = reservation.getBook();
        // Ajouter la réservation à la liste des réservations pour ce livre
        if (!reservations.containsKey(book)) {
            reservations.put(book, new ArrayList<>());
        }
        reservations.get(book).add(reservation);
    }
}
