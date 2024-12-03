package entity;

/**
 * Factory for creating budgets.
 */

public class BudgetFactory {
    /**
     * Creates a new budget.
     * @param categoryName of budget.
     * @param amount of budget.
     * @return the budget.
     */
    public Budget create(String categoryName, double amount) {
        return new Budget(categoryName, amount);
    }
}
