package use_case.add_expense;

/**
 * Input Boundary for actions which are related to adding an expense.
 */
public interface AddExpenseInputBoundary {

    /**
     * Executes the add expense use case.
     * @param addExpenseInputData the input data
     */
    void addExpense(AddExpenseInputData addExpenseInputData);

    /**
     * Executes the switch to home view use case/
     */
    void switchToHomeView();
}
