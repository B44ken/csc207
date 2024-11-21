package use_case.add_goal;

import java.time.LocalDate;
import java.util.Date;

/**
 * The input data for Add Goal use case.
 */

public class AddGoalInputData {

    private final String target;
    private final double amount;
    private final LocalDate targetDate;

    public AddGoalInputData(String target, double amount, LocalDate targetDate) {
        this.target = target;
        this.amount = amount;
        this.targetDate = targetDate;
    }

    String getTarget() {
        return target;
    }

    double getAmount() {
        return amount;
    }

    LocalDate getDate() {
        return targetDate;
    }

}
