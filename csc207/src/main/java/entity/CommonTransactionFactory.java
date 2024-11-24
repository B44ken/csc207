package entity;

import java.time.LocalDate;


/**
 * Factory for creating common transaction objects.
 */
public class CommonTransactionFactory implements TransactionFactory {

    @Override
    public Transaction create(String name, double amount, String category, LocalDate date) {
        return new Transaction(name, amount, category, date);
    }
}
