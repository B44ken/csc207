package entity;

import java.util.ArrayList;

/**
 * Stores the Budget history for app.
 */
public class BudgetHistory {
    private ArrayList<Budget> history;

    public BudgetHistory() {
        history = new ArrayList<>();
    }

    /**
     * Adds a transaction into history.
     * @param budget the transaction to be added.
     */
    public void add(Budget budget) {
        history.add(budget);
    }
}
