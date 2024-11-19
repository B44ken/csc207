package interface_adapter.add_goal;

import interface_adapter.ViewManagerModel;
import use_case.add_goal.AddGoalOutputBoundary;
import use_case.add_goal.AddGoalOutputData;

public class AddGoalPresenter implements AddGoalOutputBoundary {

    private final AddGoalViewModel addGoalViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddGoalPresenter(AddGoalViewModel addGoalViewModel, ViewManagerModel viewManagerModel) {
        this.addGoalViewModel = addGoalViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for the Add Goal Use Case.
     *
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(AddGoalOutputData outputData) {
        addGoalViewModel.firePropertyChanged("goal");
    }

    /**
     * Prepares the failure view for the Add Goal Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // this use case currently cannot fail.
    }
}
