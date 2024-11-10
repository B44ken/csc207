package use_case.add_income;

import entity.Income;

// Data access objects will implement this interface.

/**
 * The interface for DAO for Add Income use case.
 */
public interface AddIncomeUserDataAccessInterface {
    /**
     * Adds Income transaction into Transaction History.
     * @param income the income to be added.
     */
    void addIncome(Income income);
}
