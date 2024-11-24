package entity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Stores the Transaction history for app.
 */
public class Goals {
    private static ArrayList<Goal> history;

    public Goals() {
        history = new ArrayList<>();
    }

    public ArrayList<Goal> getHistory() {
        return history;
    }


    /**
     * Adds a goal into history.
     * @param goal the goal to be added.
     */
    public static void addGoal(Goal goal) {
        history.add(goal);
    }
}
