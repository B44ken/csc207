package interface_adapter.goals;

import use_case.add_goal.AddGoalInputBoundary;
import use_case.add_goal.AddGoalInputData;

import java.time.LocalDate;

/**
 * Controller for managing Goals.
 */
public class GoalsController {
    private final AddGoalInputBoundary addGoalUseCase;

    /**
     * Constructor for the GoalsController.
     *
     * @param addGoalUseCase The use case interactor for adding goals.
     */
    public GoalsController(AddGoalInputBoundary addGoalUseCase) {
        this.addGoalUseCase = addGoalUseCase;
    }

    /**
     * Adds a new goal using the use case.
     *
     * @param target The name of the goal.
     * @param amount The amount required to achieve the goal.
     * @param targetDate The target date for achieving the goal.
     */
    public void addGoal(String target, double amount, LocalDate targetDate) {
        AddGoalInputData inputData = new AddGoalInputData(target, amount, targetDate);
        addGoalUseCase.execute(inputData);
    }
}
