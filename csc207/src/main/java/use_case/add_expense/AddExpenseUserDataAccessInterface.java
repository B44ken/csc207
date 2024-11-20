package use_case.add_expense;

import entity.Expense;

public interface AddExpenseUserDataAccessInterface {

    /**
     * Checks if the given expense name exists.
     * @param name the name of the expense to look for
     * @return true if an expense with the same name;
     */
    boolean existsByName(String name);

    /**
     * Saves the expense transaction.
     * @param expense teh transaction to save
     */
    void save(Expense expense);
}
