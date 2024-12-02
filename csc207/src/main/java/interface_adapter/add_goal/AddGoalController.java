package interface_adapter.add_goal;

import use_case.add_goal.AddGoalInputData;
import use_case.add_goal.AddGoalInteractor;
import use_case.add_income.AddIncomeInputData;
import use_case.add_income.AddIncomeInteractor;

import java.time.LocalDate;
public class AddGoalController {
    private final AddGoalInteractor addGoalInteractor;

    public AddGoalController(AddGoalInteractor addGoalInteractor) {
        this.addGoalInteractor = addGoalInteractor;
    }
    /**
     * Executes the Add Goal use case by passing UserData into Interactor
     * @param target
     * @param amount
     * @param targetYear
     * @param targetMonth
     * @param targetDay
     *
     */
    public void execute(String target, String amount, String targetYear, String targetMonth, String targetDay) {
        Double doubleAmount = Double.valueOf(amount);
        LocalDate localDate = LocalDate.of(Integer.parseInt(targetYear), Integer.parseInt(targetMonth),
                Integer.parseInt(targetDay));
        final AddGoalInputData addGoalInputData = new AddGoalInputData(target, doubleAmount, localDate);
        addGoalInteractor.execute(addGoalInputData);
    }

}
