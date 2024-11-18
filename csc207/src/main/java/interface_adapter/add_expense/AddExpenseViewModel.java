package interface_adapter.add_expense;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Add Expense View.
 */
public class AddExpenseViewModel extends ViewModel<AddExpenseState>{

    public static final String TITLE_LABEL = "Add Expense View";
    public static final String NAME_LABEL = "Name";
    public static final String AMOUNT_LABEL = "Amount";
    public static final String CATEGORY_LABEL = "Category";
    public static final String DATE_LABEL = "Date";

    public static final String ENTER_BUTTON_LABEL = "Enter";
    public static final String HOME_BUTTON_LEVEL = "Back to Home View";

    public AddExpenseViewModel() {
        super("Add Expense");
        setState(new AddExpenseState());
    }
}
