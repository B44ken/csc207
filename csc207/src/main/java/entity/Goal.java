package entity;

import java.util.Date;

/**
 * Transaction parent class.
 */

public class Goal {
    private String target;
    private double amount;
    private Date targetDate;

    public Goal(String target, double amount, Date targetDate) {
        this.target = target;
        this.amount = amount;
        this.targetDate = targetDate;
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {this.targetDate = targetDate;}
}
