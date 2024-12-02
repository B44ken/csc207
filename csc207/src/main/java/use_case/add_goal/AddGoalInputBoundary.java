package use_case.add_goal;

/**
 * Add Goal Use Case.
 */

public interface AddGoalInputBoundary {
    /**
     * Execute the Goal Use Case.
     * @param addGoalInputData the input data for this use case
     */
    void execute(AddGoalInputData addGoalInputData);

    void switchToHomeView();

}
