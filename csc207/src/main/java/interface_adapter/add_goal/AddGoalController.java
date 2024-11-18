package interface_adapter.add_goal;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import use_case.add_goal.AddGoalInputData;
import use_case.add_income.AddIncomeInputData;

import java.util.Date;

/**
 * Controller for Add Income use case.
 */
public class AddGoalController {
    private final AddGoalInputData addGoalUseCaseInteractor;
    public AddGoalController(AddGoalInputData addGoalUseCaseInteractor) {
        this.addGoalUseCaseInteractor = addGoalUseCaseInteractor;
    }

    /**
     * Executes the Add goal use case.
     * @param name to be added
     * @param amount
     * @param date
     *
     */
    public void execute(String name, double amount, Date date) {
        final AddGoalInputData addGoalInputData;
    }
}
