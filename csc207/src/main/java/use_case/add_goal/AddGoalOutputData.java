package use_case.add_goal;

/**
 * The output Data for Add Goal Use Case.
 */

public class AddGoalOutputData {

    private final String target;
    private final boolean useCaseFailed;

    public AddGoalOutputData(String target, boolean useCaseFailed) {
        this.target = target;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Getter for AddGoalOutputData's target.
     * @return AddGoalOutputData's target.
     */
    public String getTarget() {
        return target;
    }

    /**
     * Returns useCaseFailed for AddGoalOutputData.
     * @return boolean if use case passed or failed.
     */
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
