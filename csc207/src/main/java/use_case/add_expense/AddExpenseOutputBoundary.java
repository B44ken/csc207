package use_case.add_expense;

/**
 * The output boundary for the Add Expense Use Case.
 */
public interface AddExpenseOutputBoundary {

    /**
     * Prepares the success view for the Add Expense Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(AddExpenseOutputData outputData);

    /**
     * Prepares the failure view for the Add Expense Use Case.
     * @param errorMessage the explanation for the failure.
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();
}
