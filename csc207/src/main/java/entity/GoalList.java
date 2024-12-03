package entity;

import java.util.ArrayList;

/**
 * Stores the list of Goals for app.
 */
public class GoalList {
    private static ArrayList<Goal> history;

    public GoalList() {
        history = new ArrayList<>();
    }

    /**
     * Adds a goal into history.
     * @param goal the goal to be added.
     */
    public void add(Goal goal) {
        history.add(goal);
    }

    /**
     * Returns list of goals.
     * @return list of goals.
     */
    public ArrayList<Goal> getList() {
        return history;
    }
}
