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
    public Expense create(String name, double amount, String category, String date) {
        Date newdate = new Date(date);
        double negativeAmount = -amount;
        return new Expense(name, negativeAmount, category, newdate);
    }

}
