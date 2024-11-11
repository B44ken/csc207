package entity;

import java.util.Date;

/**
 * Entity expense.
 */
public class Expense extends Transaction {
    public Expense(String name, double amount, String category, Date date) {
        super("", -amount, category, date);
    }
}
