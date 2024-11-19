package entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Stores the Transaction history for app.
 */
public class GoalHistory {
    private ArrayList<Goal> history;

    public GoalHistory() {
        history = new ArrayList<>();
    }

    public ArrayList<Goal> getHistory() {
        return history;
    }

    public GoalHistory getBetween(Date start, Date stop) {
        var result = new GoalHistory();
        for (var t : history) {
            if (t.getDate().after(start) && t.getDate().before(stop)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Adds a goal into history.
     * @param goal the goal to be added.
     */
    public void add(Goal goal) {
        history.add(goal);
    }
}
