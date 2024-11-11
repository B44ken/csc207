package entity;

import java.util.Date;

/**
 * Factory for creating Expense.
 */
public class ExpenseFactory implements TransactionFactory {

    /**
     * Creates a new transaction.
     *
     * @param name   of transaction.
     * @param amount of transaction.
     * @param category   of transaction.
     * @param date of trasnaction
     * @return the transaction.
     */
    @Override
    public Expense create(String name, double amount, String category, Date date) {
        return new Expense(name, amount, category, date);
    }

}
