package interface_adapter.add_expense;

import interface_adapter.ViewManagerModel;
import use_case.add_expense.AddExpenseOutputBoundary;
import use_case.add_expense.AddExpenseOutputData;

/**
 * The Presenter for teh Add Expense Use Case.
 */
public class AddExpensePresenter implements AddExpenseOutputBoundary {

    private final AddExpenseViewModel addExpenseViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddExpensePresenter (ViewManagerModel viewManagerModel,
                                AddExpenseViewModel addExpenseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addExpenseViewModel = addExpenseViewModel;
    }

    @Override
    public void prepareSuccessView(AddExpenseOutputData outputData) {
//        viewManagerModel.setState(homeViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
//        final AddExpenseState addExpenseState = addExpenseViewModel.getState();
//        addExpenseState.setNameError(error);
//        addExpenseViewModel.firePropertyChanged();
    }

    @Override
    public void switchToHomeView() {
//        viewManagerModel.setState(homeViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
    }
}
