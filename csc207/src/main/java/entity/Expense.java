package entity;

import java.sql.Date;

/**
 * Entity expense.
 */
public class Expense extends Transaction {
    public Expense(int amount, String category, Date date) {
        super("", -amount, category, date);
    }
}
