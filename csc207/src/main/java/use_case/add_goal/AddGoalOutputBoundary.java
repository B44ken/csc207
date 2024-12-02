package use_case.add_goal;

/**
 * The output boundary for the Add Goal Use Case.
 */
public interface AddGoalOutputBoundary {
    /**
     * Prepares the success view for the Add Goal Use Case.
     */
    void prepareSuccessView();

    /**
     * Prepares the failure view for the Add Goal Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}
