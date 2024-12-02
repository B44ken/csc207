package use_case.add_goal;

import data_access.UserData;
import entity.Goal;
import entity.GoalFactory;
import entity.GoalList;

/**
 * The Add Goal Interactor.
 */
public class AddGoalInteractor {
    private final UserData userData;
    private final GoalFactory goalFactory;

    public AddGoalInteractor(UserData userData, GoalFactory goalFactory) {
        this.userData = userData;
        this.goalFactory = goalFactory;
    }

    /**
     * Execute the Add Goal Use Case.
     *
     * @param addGoalInputData the input data for this use case
     */
    public void execute(AddGoalInputData addGoalInputData) {
        final Goal goal = goalFactory.create(addGoalInputData.getTarget(), addGoalInputData.getAmount(),
                addGoalInputData.getTargetDate());
        userData.getGoals().add(goal);
        userData.save();
    }
}
