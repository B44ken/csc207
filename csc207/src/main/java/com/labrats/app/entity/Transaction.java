package com.labrats.app.entity;

import java.util.Date;

public class Transaction {
    public int amount;
    public String category;
    public Date date;

    public Transaction(int amount, String category, Date date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
}