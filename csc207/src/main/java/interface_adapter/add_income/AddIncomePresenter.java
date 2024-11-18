package interface_adapter.add_income;

// takes output data and turns it into raw strings
// this tells UI what to do when the use case finishes running

import interface_adapter.ViewManagerModel;
import use_case.add_income.AddIncomeOutputBoundary;
import use_case.add_income.AddIncomeOutputData;
import view.AddIncomeView;

public class AddIncomePresenter implements AddIncomeOutputBoundary {
    private final AddIncomeViewModel addIncomeviewModel;
    private final AddIncomeViewModel addIncomeViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddIncomePresenter(AddIncomeViewModel addIncomeviewModel, AddIncomeViewModel addIncomeViewModel, ViewManagerModel viewManagerModel) {
        this.addIncomeviewModel = addIncomeviewModel;
        this.addIncomeViewModel = addIncomeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for the Add Income Use Case.
     *
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(AddIncomeOutputData outputData) {
        // On success, switch to the logged in view.

        final AddIncomeState addIncomeState = addIncomeViewModel.getState();
        addIncomeState.setUsername(response.getUsername());
        this.addIncomeViewModel.setState(addIncomeState);
        this.addIncomeViewModel.firePropertyChanged();

        this.viewManagerModel.setState(addIncomeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the Add Income Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // this use case currently cannot fail.
    }

    /**
     * Switches to the Home View.
     */
    @Override
    public void switchToHomeVIew() {
        viewManagerModel.setState(addIncomeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
