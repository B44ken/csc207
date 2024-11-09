package entity;

import java.util.Date;

public class Income extends Transaction {
    public Income(int amount, String category, Date date) {
        super(amount, category, date);
    }
}
