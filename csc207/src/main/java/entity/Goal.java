package entity;

import java.util.Date;

/**
 * Transaction parent class.
 */

public class Goal {
    private String target;
    private double amount;
    private Date date;

    public Goal(String name, double amount, Date date) {
        this.target = target;
        this.amount = amount;
        this.date = date;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
