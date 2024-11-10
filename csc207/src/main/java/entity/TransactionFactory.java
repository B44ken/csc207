package entity;

/**
 * Factory for creating transactions.
 */

public interface TransactionFactory {
    /**
     * Creates a new transaction.
     * @param name of transaction.
     * @param amount of transaction.
     * @param type of transaction.
     * @return the transaction.
     */
    Transaction create(String name, double amount, String type);
}
