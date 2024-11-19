package entity;

import java.time.LocalDate;

/**
 * Entity expense.
 */
public class Expense extends Transaction {
    public Expense(String name, Double amount, String category, LocalDate date) {
        super(name, amount, category, date);
    }
}
