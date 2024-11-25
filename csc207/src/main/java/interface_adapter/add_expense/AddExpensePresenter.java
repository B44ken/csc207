package interface_adapter.add_expense;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import use_case.add_expense.AddExpenseOutputBoundary;
import use_case.add_expense.AddExpenseOutputData;

/**
 * The Presenter for teh Add Expense Use Case.
 */
public class AddExpensePresenter implements AddExpenseOutputBoundary {

    private final AddExpenseViewModel addExpenseViewModel;
    private final HomeViewModel homeViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddExpensePresenter (ViewManagerModel viewManagerModel,
                                AddExpenseViewModel addExpenseViewModel,
                                HomeViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addExpenseViewModel = addExpenseViewModel;
        this.homeViewModel = homeViewModel;
    }

    @Override
    public void prepareSuccessView(AddExpenseOutputData outputData) {
        // to be implemented
    }

    @Override
    public void prepareFailView(String error) {
        final AddExpenseState addExpenseState = addExpenseViewModel.getState();
        addExpenseState.setExpenseError(error);
        addExpenseViewModel.firePropertyChanged();
    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
