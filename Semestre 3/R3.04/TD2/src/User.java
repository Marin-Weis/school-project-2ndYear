// User.java

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe représentant un utilisateur de la bibliothèque.
 * @author Marin WEIS
 * BUT2 R2.04
 * TP2
 * Groupe C1
 */
public class User {
    private String name;
    private boolean prenium;
    private List<Loan> Loans = new ArrayList<Loan>();

    public User(String name, boolean prenium) {
        this.name = name;
        this.prenium = prenium;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book, Library library) {
        library.lendBook(this, book, LocalDate.now());
    }

    public boolean isPremium() {
        return prenium; 
    }

    public List<Loan> getSaveLoanHistory() {
        return Loans;
    }

    public void addLoanToHistory(Loan loan) {
        Loans.add(loan);
    }

    public void returnBook(Book book, Library library) {
        library.returnBook(book);
    }
}
