package entity;


import java.time.LocalDate;

/**
 * Factory for creating goals.
 */

public class GoalFactory {
    /**
     * Creates a new goal.
     * @param target of goal.
     * @param amount of goal.
     * @param date of goal.
     * @return the goal.
     */
    public Goal create(String target, double amount, LocalDate date) {
        return new Goal(target, amount, date);
    }
}
