package use_case.add_goal;

import entity.Goal;

/**
 * the interface for DAO for Add Goal use case.
 */

public interface AddGoalUserDataAccessInterface {
    /**
     * Add Goal into Goal History.
     * @param goal the goal to be added.
     */
    void addGoal(Goal goal);
}
