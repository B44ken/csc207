package use_case.add_expense;

import entity.Expense;

/**
 * DAO for the Add Expense Use Case.
 */
public interface AddExpenseDataAccessInterface {

    /**
     * Saves the expense transaction.
     * @param expense the transaction to save
     */
    void addExpense(Expense expense);

}
