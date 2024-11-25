package interface_adapter.add_goal;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import use_case.add_goal.AddGoalInputData;
import use_case.add_goal.AddGoalInputBoundary;

import java.time.LocalDate;
import java.util.Date;

/**
 * Controller for Add Income use case.
 */
public class AddGoalController {
    private final AddGoalInputBoundary addGoalUseCaseInteractor;
    public AddGoalController(AddGoalInputBoundary addGoalUseCaseInteractor) {
        this.addGoalUseCaseInteractor = addGoalUseCaseInteractor;
    }

    /**
     * Adds a new goal using the use case.
     *
     * @param target The name of the goal.
     * @param amount The amount required to achieve the goal.
     * @param targetDate The target date for achieving the goal.
     */
    public void execute(String target, double amount, LocalDate targetDate) {
        final AddGoalInputData addGoalInputData = new AddGoalInputData(target, amount, targetDate);

        addGoalUseCaseInteractor.execute(addGoalInputData);
    }
}
