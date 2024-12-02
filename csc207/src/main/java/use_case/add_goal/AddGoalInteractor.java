package use_case.add_goal;

import entity.Goal;
import entity.GoalList;

/**
 * The Add Goal Interactor.
 */
public class AddGoalInteractor implements AddGoalInputBoundary {
    private final AddGoalUserDataAccessInterface userDataAccessObject;
    private final AddGoalOutputBoundary userPresenter;
    private final GoalList goals;

    public AddGoalInteractor(AddGoalUserDataAccessInterface userDataAccessObject,
                               AddGoalOutputBoundary userPresenter,
                               GoalList goals) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.goals = goals;
    }

    /**
     * Execute the Add Goal Use Case.
     *
     * @param addGoalInputData the input data for this use case
     */
    @Override
    public void execute(AddGoalInputData addGoalInputData) {
        final Goal goal = new Goal(null, null, null);
        goal.setTarget(addGoalInputData.getTarget());
        goal.setAmount(addGoalInputData.getAmount());
        goal.setTargetDate(addGoalInputData.getTargetDate());
        goals.add(goal);
        userDataAccessObject.addGoal(goal);
        final AddGoalOutputData addGoalOutputData = new AddGoalOutputData(goal.getTarget(), false);
        userPresenter.prepareSuccessView(addGoalOutputData);
    }

    @Override
    public void switchToHomeView() {

    }
}
