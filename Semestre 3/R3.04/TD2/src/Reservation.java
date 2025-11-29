import java.time.LocalDate;


/**
 * Classe représentant une réservation de livre par un utilisateur.
 * @author Marin WEIS
 * BUT2 R2.04
 * TP2
 * Groupe C1
 */
public class Reservation {

    private User User;
    private Book Book;
    private LocalDate Date;

    public Reservation(User user, Book book, LocalDate date) {
        User = user;
        Book = book;
        Date = date;
    }

    // Getters et Setters

    public User getUser() {
        return User;
    }

    public Book getBook() {
        return Book;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setUser(User user) {
        User = user;
    }

    public void setBook(Book book) {
        Book = book;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
