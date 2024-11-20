package entity;

import java.time.LocalDate;

/**
 *
 */
public class IncomeFactory implements TransactionFactory{

    /**
     * Creates a new transaction.
     *
     * @param name     of transaction.
     * @param amount   of transaction.
     * @param category of transaction.
     * @param date     of transaction.
     * @return the transaction.
     */
    @Override
    public Transaction create(String name, double amount, String category, LocalDate date) {
        return new Income(name, amount, category, date);
    }
}
