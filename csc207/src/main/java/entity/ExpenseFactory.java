package entity;

/**
 * Factory for creating Expense.
 */
public class ExpenseFactory implements TransactionFactory {

    /**
     * Creates a new transaction.
     *
     * @param name   of transaction.
     * @param amount of transaction.
     * @param type   of transaction.
     * @return the transaction.
     */
    @Override
    public Expense create(String name, double amount, String type) {
        return new Expense();
    }
}
