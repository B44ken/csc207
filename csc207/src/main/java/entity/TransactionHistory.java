package entity;

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
    public int getAmountBetween(Date start, Date stop) {
        int sum = 0;
        for (var t : history) {
            if (t.getDate().after(start) && t.getDate().before(stop)) {
                sum += t.getAmount();
            }
        }
        return sum;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public TransactionHistory getBetween(Date start, Date stop) {
        var result = new TransactionHistory();
        for (var t : history) {
            if (t.getDate().after(start) && t.getDate().before(stop)) {
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
}
