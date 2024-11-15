package interface_adapter.add_budget;

import interface_adapter.ViewManagerModel;
import use_case.add_budget.AddBudgetOutputBoundary;
import use_case.add_budget.AddBudgetOutputData;

public class AddBudgetPresenter implements AddBudgetOutputBoundary {

    private final AddBudgetViewModel addBudgetViewModel;
    // need to add budgetviewmodel
    private final ViewManagerModel viewManagerModel;

    public AddBudgetPresenter(ViewManagerModel viewManagerModel, AddBudgetViewModel addBudgetViewModel) {
        this.addBudgetViewModel = addBudgetViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for the Add Budget Use Case.
     *
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(AddBudgetOutputData outputData) {
        // need to implement budgetview for this to work, based on signup presenter code:
        // final BudgetState budgetState = budgetViewModel.getState();
        // budgetState.addBudget(response.getBudget());
        // this.budgetViewModel.setState(budgetState);
        // budgetViewModel.firePropertyChanged();

        // viewManagerModel.setState(budgetViewModel.getViewName());
        // viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the Add Budget Use Case.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // fail not possible currently
    }

    @Override
    public void switchToBudgetView(){
        // need to implement budget view for this to work
        // viewManagerModel.setState(budgetViewModel.getViewName());
        // viewManagerModel.firePropertyChanged();
    }
}