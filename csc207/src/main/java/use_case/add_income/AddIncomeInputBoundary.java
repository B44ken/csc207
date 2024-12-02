package use_case.add_income;

import data_access.UserData;

/**
 * Add Income Use Case.
 */

public interface AddIncomeInputBoundary {
    /**
     * Execute the Change Password Use Case.
     * @param userData the input data for this use case
     */
    void execute(UserData userData);

    void switchToHomeView();

}
