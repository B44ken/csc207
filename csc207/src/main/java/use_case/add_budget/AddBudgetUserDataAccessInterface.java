package use_case.add_budget;

import entity.Budget;

// Data access objects will implement this interface.

/**
 * The interface for DAO for Add Budget use case.
 */
public interface AddBudgetUserDataAccessInterface {
    /**
     * Checks if a Budget with the given categoryName exists.
     * @param categoryName the categoryName to look for
     * @return true if a budget with the given categoryName exists; false otherwise
     */
    boolean existsByName(String categoryName);

    /**
     * Adds Budget into Budget History.
     * @param budget the budget to be added.
     */
    void addBudget(Budget budget);
}