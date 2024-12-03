package interface_adapter.add_goal;

import java.time.LocalDate;

import use_case.add_goal.AddGoalInputData;
import use_case.add_goal.AddGoalInteractor;

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
