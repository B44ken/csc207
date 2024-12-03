package use_case.add_goal;

import java.time.LocalDate;

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

    /**
     * Getter for AddGoalInputData's target.
     * @return AddGoalInputData's target.
     */
    String getTarget() {
        return target;
    }

    /**
     * Getter for AddGoalInputData's amount.
     * @return AddGoalInputData's amount.
     */
    double getAmount() {
        return amount;
    }

    /**
     * Getter for AddGoalInputData's date.
     * @return AddGoalInputData's date.
     */
    LocalDate getTargetDate() {
        return targetDate;
    }
}
