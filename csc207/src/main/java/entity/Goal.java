package entity;

import java.time.LocalDate;

/**
 * Goal class.
 */

public class Goal {
    private String target;
    private Double amount;
    private LocalDate targetDate;

    /**
    * Creates a new Goal.
    * @param target Name of target.
    * @param amount Amount of target.
    * @param targetDate Date of target.
    */
    public Goal(String target, Double amount, LocalDate targetDate) {
        this.target = target;
        this.amount = amount;
        this.targetDate = targetDate;
    }

    /**
    * Return target of Goal.
    * @return target of Goal.
    */
    public String getTarget() {
        return target;
    }

    /**
    * Sets target of Goal.
    * @param target of Goal.
    */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
    * Returns amount of Goal.
    * @return amount of Goal.
    */
    public double getAmount() {
        return amount;
    }

    /**
    * Sets amount of Goal.
    * @param amount of Goal.
    */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
    * Returns targetDate of Goal.
    * @return targetDate of Goal.
    */
    public LocalDate getTargetDate() {
        return targetDate;
    }

    /**
    * Sets targetDate of Goal.
    * @param targetDate of Goal.
    */
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
