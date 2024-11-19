package interface_adapter.home;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_expense.AddExpenseViewModel;
import use_case.home.HomeOutputBoundary;

/**
 * The Presenter for the Home Use Case.
 */
public class HomePresenter implements HomeOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final HomeViewModel homeViewModel;
    private final AddExpenseViewModel addExpenseViewModel;

    public HomePresenter(ViewManagerModel viewManagerModel,
                         HomeViewModel homeViewModel,
                         AddExpenseViewModel addExpenseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.addExpenseViewModel = addExpenseViewModel;
    }
    @Override
    public void switchToAddExpense() {
        viewManagerModel.setState(addExpenseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
