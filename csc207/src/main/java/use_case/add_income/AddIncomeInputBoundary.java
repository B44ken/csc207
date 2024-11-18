package use_case.add_income;

/**
 * Add Income Use Case.
 */

public interface AddIncomeInputBoundary {
    /**
     * Execute the Change Password Use Case.
     * @param addIncomeInputData the input data for this use case
     */
    void execute(AddIncomeInputData addIncomeInputData);

    void switchToHomeView();

}
