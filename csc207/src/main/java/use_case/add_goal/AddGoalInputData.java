package use_case.add_goal;

import java.util.Date;

/**
 * The input data for Add Goal use case.
 */

public class AddGoalInputData {

    private final String target;
    private final double amount;
    private final Date targetDate;

    public AddGoalInputData(String target, double amount, String targetDate) {
        this.target = target;
        this.amount = amount;
        this.targetDate = new Date(targetDate);
    }

    String getTarget() {
        return target;
    }

    double getAmount() {
        return amount;
    }

    Date getDate() {
        return targetDate;
    }

}
