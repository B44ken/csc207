package entity;

import java.time.LocalDate;

/**
 * Transaction parent class.
 */

public class Goal {
    private String target;
    private double amount;
    private LocalDate targetDate;

    public Goal(String target, double amount, LocalDate targetDate) {
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

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {this.targetDate = targetDate;}
}
