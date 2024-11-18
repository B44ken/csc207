package entity;

import java.util.Date;

/**
 * Factory for creating goals.
 */

public interface GoalFactory {
    /**
     * Creates a new goal.
     * @param target of goal.
     * @param amount of goal.
     * @param date of goal.
     * @return the goal.
     */
    Transaction create(String target, double amount, Date date);
}
