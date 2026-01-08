/**
 * Exercice 2
 * Marin Weis
 * R3.04 TD3
 * Groupe : C1
 */
public class VendingMachine {
    private enum State {
        IDLE, WAITING_FOR_MONEY, DISPENSING_ITEM, OUT_OF_ORDER
    }

    private State currentState;
    private int balance;
    private int itemPrice;

    public VendingMachine(int itemPrice) {
        this.currentState = State.IDLE;
        this.itemPrice = itemPrice;
        this.balance = 0;
    }

    public void insertMoney(int amount) {
        if (currentState == State.IDLE || currentState == State.WAITING_FOR_MONEY) {
            balance += amount;
            System.out.println("Money inserted: " + amount);
            currentState = (balance >= itemPrice) ? State.DISPENSING_ITEM : State.WAITING_FOR_MONEY;
        } else {
            System.out.println("Cannot insert money in state: " + currentState);
        }
    }

    public void dispenseItem() {
        if (currentState == State.DISPENSING_ITEM) {
            System.out.println("Dispensing item...");
            balance -= itemPrice;
            currentState = (balance > 0) ? State.WAITING_FOR_MONEY : State.IDLE;
        } else {
            System.out.println("Cannot dispense item in state: " + currentState);
        }
    }

    public void setOutOfOrder() {
        System.out.println("Machine is out of order.");
        currentState = State.OUT_OF_ORDER;
    }

    public void resetMachine() {
        if (currentState == State.OUT_OF_ORDER) {
            System.out.println("Machine is being reset.");
            currentState = State.IDLE;
            balance = 0;
        } else {
            System.out.println("Cannot reset machine in state: " + currentState);
        }
    }

    public void displayState() {
        System.out.println("Current state: " + currentState);
    }
}
