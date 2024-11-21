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
     * Executes the Add goal use case.
     * @param target to be added
     * @param amount
     * @param targetDate
     *
     */
    public void execute(String target, double amount, LocalDate targetDate) {
        final AddGoalInputData addGoalInputData = new AddGoalInputData(target, amount, targetDate);

        addGoalUseCaseInteractor.execute(addGoalInputData);
    }
}
