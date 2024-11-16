package entity;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Entity expense.
 */
public class Expense extends Transaction {
    public Expense(int amount, String category, LocalDate date) {
        super("", amount, category, date);
    }
}
