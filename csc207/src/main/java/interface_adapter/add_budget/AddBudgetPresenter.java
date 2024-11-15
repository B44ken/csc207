package interface_adapter.add_budget;

import interface_adapter.ViewManagerModel;
import use_case.add_budget.AddBudgetOutputBoundary;
import use_case.add_budget.AddBudgetOutputData;

public class AddBudgetPresenter implements AddBudgetOutputBoundary {

    private final AddBudgetViewModel addBudgetViewModel;
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
        // is below supposed to say "add budget" or just "budget"??????
        addBudgetViewModel.firePropertyChanged("add budget");
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
        viewManagerModel.setState(AddBudgetViewModel.getViewName());
        // need to make ViewModel.getViewName() static for above line to work apparently? idk man
        viewManagerModel.firePropertyChanged();
    }
}