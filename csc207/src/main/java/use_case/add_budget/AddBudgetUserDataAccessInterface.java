package use_case.add_budget;

import entity.Budget;

// Data access objects will implement this interface.

/**
 * The interface for DAO for Add Budget use case.
 */
public interface AddBudgetUserDataAccessInterface {
    /**
     * Adds Budget into Budget History.
     * @param budget the income to be added.
     */
    void addBudget(Budget budget);
}