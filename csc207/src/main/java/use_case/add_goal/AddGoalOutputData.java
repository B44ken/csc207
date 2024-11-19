package use_case.add_goal;

/**
 * The output Data for Add Goal Use Case.
 * This creates an Output Data Object for Interactor to update Database/Presenter to update the View.
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

    // why is this never used i'm gonna cry.
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
