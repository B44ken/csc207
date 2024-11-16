package entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Entity Income.
 */
public class Income extends Transaction {
    public Income(String name, Double amount, String category, LocalDate date) {
        super(name, amount, category, date);
    }
}
