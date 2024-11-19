package entity;


import java.util.Date;

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
    public Goal create(String target, double amount, Date date) {
        Date newdate = date;
        return new Goal(target, amount, newdate);
    }
}
