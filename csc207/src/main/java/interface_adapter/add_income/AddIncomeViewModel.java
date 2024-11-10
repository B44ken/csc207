package interface_adapter.add_income;

import interface_adapter.ViewModel;

/**
 * The View Model for Add Income View.
 */
public class AddIncomeViewModel extends ViewModel<AddIncomeState> {
    public AddIncomeViewModel() {
        super("add income");
        setState(new AddIncomeState());
    }
}
