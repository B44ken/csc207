package use_case.add_income;

import data_access.UserData;

/**
 * Add Income Use Case.
 */

public interface AddIncomeInputBoundary {
    /**
     * Execute the Change Password Use Case.
     * @param addIncomeInputData the input data for this use case
     */
    void execute(AddIncomeInputData addIncomeInputData);
}
