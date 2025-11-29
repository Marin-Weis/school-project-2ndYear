/**
 * Marin WEIS
 * BUT2 R2.04
 * TP2
 * Groupe C1
 */
import java.time.LocalDate;

/**
 * Classe représentant un emprunt de livre par un utilisateur.
 */
public class Loan {
    private User user;
    private Book book;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private boolean isReturned;

    public Loan (User user, Book book, LocalDate dateEmprunt, LocalDate dateRetour, boolean isReturned) {
        this.user = user;
        this.book = book;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.isReturned = isReturned;
    }

    // Getters et Setters
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean isReturned() {
        return isReturned;
    }


    //Méthode pour le retour d’un livre
    public void backBook() {
        isReturned = true;
    }
    
    //Méthode pour savoir si un emprunt est en retard
    public boolean isLoanLate() {
        return LocalDate.now().isAfter(dateRetour);
    }
}
