package entity;

import java.util.ArrayList;

/**
 * Stores the Transaction history for app.
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

    public ArrayList<Goal> getList() {
        return history;
    }
}
