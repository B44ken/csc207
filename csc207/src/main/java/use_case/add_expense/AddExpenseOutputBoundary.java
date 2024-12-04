package use_case.add_expense;

/**
 * The output boundary for the Add Expense Use Case.
 */
public interface AddExpenseOutputBoundary {

    /**
     * Prepares the success view for the Add Expense Use Case.
     * @param outputData - expense data clustered together.
     */
    void prepareSuccessView(AddExpenseOutputData outputData);

    /**
     * Prepares the failure view for the Add Expense Use Case.
     * @param errorMessage the explanation for the failure.
     */
    void prepareFailView(String errorMessage);

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
