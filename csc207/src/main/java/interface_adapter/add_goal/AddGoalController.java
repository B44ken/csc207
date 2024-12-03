package interface_adapter.add_goal;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Budget;
import entity.Goal;
import use_case.add_goal.AddGoalInputData;
import use_case.add_goal.AddGoalInputBoundary;
import use_case.add_goal.AddGoalInteractor;
import use_case.add_income.AddIncomeInputData;
import view.ViewSwitcher;

import javax.swing.text.View;
import java.time.LocalDate;
import java.util.Date;

/**
 * Controller for Add Goal use case.
 */
public class AddGoalController {
    private final AddGoalInteractor addGoalInteractor;

    public AddGoalController(AddGoalInteractor addGoalInteractor) {
        this.addGoalInteractor = addGoalInteractor;
    }

    /**
     * Executes the Add Goal use case by passing UserData into Interactor.
     * @param target Name of target.
     * @param amount Amount of target.
     * @param targetDay Day of target.
     * @param targetMonth Month of target.
     * @param targetYear Year of target
     *
     */
    public void execute(String target, String amount, String targetDay, String targetMonth, String targetYear) {
        Double doubleAmount = Double.valueOf(amount);
        LocalDate localDate = LocalDate.of(Integer.parseInt(targetYear), Integer.parseInt(targetMonth),
                Integer.parseInt(targetDay));
        final AddGoalInputData addGoalInputData = new AddGoalInputData(target, doubleAmount, localDate);
        addGoalInteractor.execute(addGoalInputData);
    }
}
