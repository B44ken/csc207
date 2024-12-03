package entity;

import java.util.ArrayList;

/**
 * Stores the Budget history for app.
 */
public class BudgetHistory {
    private ArrayList<Budget> history;

    /**
     * Initializes a BudgetHistory object.
     */
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

    /**
     * Returns a BudgetHistory object containing all added Budgets.
     * @return the BudgetHistory object.
     */
    public BudgetHistory getAllBudgets() {
        final BudgetHistory result = new BudgetHistory();
        for (var t : history) {
            if (t instanceof Budget) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Returns an ArrayList containing Budget objects that are contained in BudgetHistory.
     * @return an ArrayList of Budgets.
     */
    public ArrayList<Budget> getList() {
        return history;
    }
}
