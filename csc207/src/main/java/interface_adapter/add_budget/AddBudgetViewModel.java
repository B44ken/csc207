package interface_adapter.add_budget;

import interface_adapter.ViewModel;

/**
 * The View Model for Add Budget View.
 */
public class AddBudgetViewModel extends ViewModel<AddBudgetState> {

    /**
     * Initializes AddBudgetViewModel.
     */
    public AddBudgetViewModel() {
        super("add budget");
        setState(new AddBudgetState());
    }
}
