package interface_adapter.add_income;

import interface_adapter.ViewModel;

/**
 * The View Model for Logged In View
 */
public class AddIncomeViewModel extends ViewModel<AddIncomeState> {
    public AddIncomeViewModel() {
        super("add income");
        setState(new AddIncomeState());
    }
}
