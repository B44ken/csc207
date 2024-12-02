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
    private final AddGoalOutputBoundary userPresenter;

    public AddGoalInteractor(UserData userData, AddGoalOutputBoundary userPresenter, GoalFactory goalFactory) {
        this.userData = userData;
        this.goalFactory = goalFactory;
        this.userPresenter = userPresenter;
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
