package use_case.add_income;

/**
 * The output boundary for the Add Income Use Case.
 */
public interface AddIncomeOutputBoundary {
    /**
     * Prepares the success view for the Add Income Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(AddIncomeOutputData outputData);

    /**
     * Prepares the failure view for the Add Income Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();
}
