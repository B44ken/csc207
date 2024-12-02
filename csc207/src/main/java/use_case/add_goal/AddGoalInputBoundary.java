package use_case.add_goal;

import data_access.UserData;

/**
 * Add Goal Use Case.
 */

public interface AddGoalInputBoundary {
    /**
     * Execute the Goal Use Case.
     * @param userData the input data for this use case
     */
    void execute(UserData userData);

    void switchToHomeView();

}
