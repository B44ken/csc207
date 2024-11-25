package use_case.add_expense;

import entity.Transaction;

/**
 * DAO for the Add Expense Use Case.
 */
public interface AddExpenseDataAccessInterface {

    /**
     * Checks if the given expense name exists.
     * @param name the name of the expense to look for
     * @return true if an expense with the same name existsl; false otherwise
     */
    boolean existsByName(String name);

    /**
     * Saves the expense transaction.
     * @param expense the transaction to save
     */
    void save(Transaction expense);

}
