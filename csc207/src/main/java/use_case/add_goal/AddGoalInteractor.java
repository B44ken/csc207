package use_case.add_goal;

import entity.Goal;
import entity.GoalHistory;

/**
 * The Add Goal Interactor.
 */
public class AddGoalInteractor implements AddGoalInputBoundary {
    private final AddGoalUserDataAccessInterface userDataAccessObject;
    private final AddGoalOutputBoundary userPresenter;
    private final Goal goals;

    public AddGoalInteractor(AddGoalUserDataAccessInterface userDataAccessObject,
                               AddGoalOutputBoundary userPresenter,
                               GoalHistory goalHistory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.goals = goals;
    }

    /**
     * Execute the Change Password Use Case.
     *
     * @param addGoalInputData the input data for this use case
     */
    @Override
    public void execute(AddGoalInputData addGoalInputData) {
        final Goal goal = null;
        goal.setTarget(addGoalInputData.getTarget());
        goal.setAmount(addGoalInputData.getAmount());
        goal.setTargetDate(addGoalInputData.getDate());
        goals.add(goal);

        userDataAccessObject.addGoal(goal);
        final AddGoalOutputData addGoalOutputData = new AddGoalOutputData(goal.getTarget(), false);
        userPresenter.prepareSuccessView(addGoalOutputData);
    }

    /**
     *
     */
    @Override
    public void switchToHomeView() {
        userPresenter.switchToHomeVIew();
    }
}
