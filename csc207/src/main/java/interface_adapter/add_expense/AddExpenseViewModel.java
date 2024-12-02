package interface_adapter.add_expense;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Add Expense View.
 */
public class AddExpenseViewModel extends ViewModel<AddExpenseState> {
    public AddExpenseViewModel() {
        super("add expense view");
        setState(new AddExpenseState());
    }
}
