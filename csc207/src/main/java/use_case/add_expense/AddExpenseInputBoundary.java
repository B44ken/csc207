package use_case.add_expense;

import data_access.UserData;

/**
 * Input Boundary for actions which are related to adding an expense.
 */
public interface AddExpenseInputBoundary {

    /**
     * Executes the add expense use case.
     * @param userData the input data
     */
    void execute(UserData userData);

    /**
     * Execytes the switch to home view use case/
     */
    void switchToHomeView();
}
