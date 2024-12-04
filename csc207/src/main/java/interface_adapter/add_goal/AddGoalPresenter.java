package interface_adapter.add_goal;

import use_case.add_goal.AddGoalOutputBoundary;

/**
 * Presenter for Add Goal Use Case.
 */
public class AddGoalPresenter implements AddGoalOutputBoundary {

    public AddGoalPresenter() {
    }

    /**
     * Prepares the success view for the Add Goal Use Case.
     *
     */
    @Override
    public void prepareSuccessView() {
        // On success, switch to goalList view.
    }

    /**
     * Prepares the failure view for the Add Goal Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
    }

}
