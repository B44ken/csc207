package entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Stores the Transaction history for app.
 */
public class Goals {
    private ArrayList<Goal> history;

    public Goals() {
        history = new ArrayList<>();
    }

    public ArrayList<Goal> getHistory() {
        return history;
    }

    public Goals getBetween(Date start, Date stop) {
        var result = new Goals();
        for (var t : history) {
            if (t.getTargetDate().after(start) && t.getTargetDate().before(stop)) {
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
