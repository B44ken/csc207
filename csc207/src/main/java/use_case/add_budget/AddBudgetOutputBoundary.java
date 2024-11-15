package use_case.add_budget;

/**
 * The output boundary for the Add Budget Use Case.
 */
public interface AddBudgetOutputBoundary {
    /**
     * Prepares the success view for the Add Budget Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(AddBudgetOutputData outputData);

    /**
     * Prepares the failure view for the Add Budget Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Budget View.
     */
    void switchToBudgetView();
}