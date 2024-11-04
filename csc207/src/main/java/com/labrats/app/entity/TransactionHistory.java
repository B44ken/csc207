package com.labrats.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistory {
    public ArrayList<Transaction> history;

    public TransactionHistory() {
        history = new ArrayList<Transaction>();
    }

    public int getAmountTotal() {
        int sum = 0;
        for(var t : history)
            sum += t.amount;
        return sum;
    }

    public int getAmountBetween(Date start, Date stop) {
        int sum = 0;
        for(var t : history)
            if(t.date.after(start) && t.date.before(stop))
                sum += t.amount;
        return sum;
    }

    public void add(Transaction t) {
        history.add(t);
    }
}
