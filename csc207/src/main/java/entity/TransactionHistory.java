package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Stores the Transaction history for app.
 */
public class TransactionHistory {
    private ArrayList<Transaction> history;

    public TransactionHistory() {
        history = new ArrayList<>();
    }

    /**
     * Returns total amount spent??? net balance.
     * @return total amount
     */
    public int getAmountTotal() {
        int sum = 0;
        for (var t : history) {
            sum += t.getAmount();
        }
        return sum;
    }

    /**
     * Returns net amount between start and stop dates.
     * @param start the start date (inclusive)
     * @param stop the end date (inclusive)
     * @return net amount.
     */
    public int getAmountBetween(LocalDate start, LocalDate stop) {
        int sum = 0;
        for (var t : history) {
            if(!t.getDate().isBefore(start) && !t.getDate().isAfter(stop)) {
                sum += t.getAmount();
            }
        }
        return sum;
    }

    public int getExpensesBetween(LocalDate start, LocalDate stop) {
        int sum = 0;
        for (var t : history) {
            if(!t.getDate().isBefore(start) && !t.getDate().isAfter(stop)) {
                if(t instanceof Expense) {
                    sum += t.getAmount();
                }
            }
        }
        return sum;
    }

    public int getIncomeBetween(LocalDate start, LocalDate stop) {
        int sum = 0;
        for (var t : history) {
            if(!t.getDate().isBefore(start) && !t.getDate().isAfter(stop)) {
                if(t instanceof Income) {
                    sum += t.getAmount();
                }
            }
        }
        return sum;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public TransactionHistory getBetween(LocalDate start, LocalDate stop) {
        var result = new TransactionHistory();
        for (var t : history) {
            if(!t.getDate().isBefore(start) && !t.getDate().isAfter(stop)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Adds a transaction into history.
     * @param transaction the transaction to be added.
     */
    public void add(Transaction transaction) {
        history.add(transaction);
    }

    /**
     * Returns all time net balance. Method implemented for HomeView repaint method.
     * @return net amount.
     */
    public int getNetBalance() {
        int sum = 0;
        for (var t : history) {
            sum += t.getAmount();
        }
        return sum;

    }

    /**
     * Returns all time Income Total. Method implemented for HomeView repaint method.
     * @return net amount.
     */
    public int getIncomeTotal() {
        int sum = 0;
        for (var t : history) {
            if(t instanceof Income) {
                sum += t.getAmount();
            }
        }
        return sum;
    }

    /**
     * Returns all time Expense Total. Method implemented for HomeView repaint method.
     * @return net amount.
     */
    public int getExpensesTotal() {
        int sum = 0;
        for (var t : history) {
            if(t instanceof Expense) {
                sum += t.getAmount();
            }
        }
        return sum;
    }





}
