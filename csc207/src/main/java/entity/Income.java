package entity;

import java.util.Date;

/**
 * Entity Income.
 */
public class Income extends Transaction {
    public Income(String name, int amount, String category, Date date) {
        super(name, amount, category, date);
    }
}
