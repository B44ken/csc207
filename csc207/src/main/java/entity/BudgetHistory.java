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


    public BudgetHistory getAllBudgets() {
        BudgetHistory result = new BudgetHistory();
        for (var t : history) {
            if (t instanceof Budget) {
                result.add(t);
            }
        }
        return result;
    }

    // public ArrayList<Budget> getHistory() {}

    public ArrayList<Budget> getList() {
        return history;
    }
}
