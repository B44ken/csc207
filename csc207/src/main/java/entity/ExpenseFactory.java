package entity;

import java.time.LocalDate;

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
    public Expense create(String name, double amount, String category, LocalDate date) {
        double Amount = amount;
        return new Expense(name, Amount, category, date);
    }

}
