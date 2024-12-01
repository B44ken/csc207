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

    public String getTarget() {
        return target;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
