package interface_adapter.add_goal;

// takes output data and turns it into raw strings
// this tells UI what to do when the use case finishes running

import com.labrats.app.ViewNames;
import use_case.add_goal.AddGoalOutputBoundary;
import view.AddGoalView;
import view.ViewSwitcher;

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
