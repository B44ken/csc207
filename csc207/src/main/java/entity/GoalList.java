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

    public ArrayList<Goal> getHistory() {
        return history;
    }


    /**
     * Adds a goal into history.
     * @param goal the goal to be added.
     */
    public static void add(Goal goal) {
        history.add(goal);
    }
}
