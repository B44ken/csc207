package entity;

import java.util.ArrayList;

/**
 * Stores the Transaction history for app.
 */
public class GoalList {
    private ArrayList<Goal> goals;

    public GoalList() {
        goals = new ArrayList<>();
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    /**
     * Adds a goal into history.
     * @param goal the goal to be added.
     */
    public void add(Goal goal) {
        goals.add(goal);
    }
}
