package entity;

import java.time.LocalDate;

/**
 * Factory for creating transactions.
 */

public interface TransactionFactory {
    /**
     * Creates a new transaction.
     * @param name of transaction.
     * @param amount of transaction.
     * @param category of transaction.
     * @param date of transaction.
     * @return the transaction.
     */
    Transaction create(String name, double amount, String category, LocalDate date);
}
