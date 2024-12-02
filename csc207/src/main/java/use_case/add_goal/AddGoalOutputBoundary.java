package use_case.add_goal;

/**
 * The output boundary for the Add Goal Use Case.
 */
public interface AddGoalOutputBoundary {
    /**
     * Prepares the success view for the Add Goal Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(AddGoalOutputData outputData);

    /**
     * Prepares the failure view for the Add Goal Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Home View.
     */
    void switchToHomeVIew();
}
