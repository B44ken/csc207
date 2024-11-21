package use_case.add_budget;


public interface AddBudgetInputBoundary {
    /**
     * Execute the Add Budget Use Case.
     * @param addBudgetInputData the input data for this use case
     */
    void execute(AddBudgetInputData addBudgetInputData);

    /**
     * Executes the switch to budget view use case.
     */
    void switchToHomeView();
}
