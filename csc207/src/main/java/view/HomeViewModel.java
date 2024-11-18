package view;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Home View.
 */
public class HomeViewModel extends ViewModel<HomeState> {
    public static final String TITLE_LABEL = "my cool finance app";
    public static final String NET_BALANCE_LABEL = "Net Balance";
    public static final String INCOME_TEXT_LABEL = "Income";
    public static final String EXPENSE_TEXT_LABEL = "Expenses";

    public static final float NET_BALANCE_VALUE = 0;
    public static final float INCOME_VALUE = 0;
    public static final float EXPENSES_VALUE = 0;

    public static final String ADD_INCOME_BUTTON_LABEL = "Add Income";
    public static final String ADD_EXPENSE_BUTTON_LABEL = "Add expense";

    public static final String INCOME_BUTTON_LABEL = "Income";
    public static final String EXPENSE_BUTTON_LABEL = "Expense";
    public static final String GOAL_BUTTON_LABEL = "Goal";

    public HomeViewModel() {
        super("home view");
        setState(new HomeState());
    }

}
