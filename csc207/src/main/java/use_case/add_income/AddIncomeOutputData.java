package use_case.add_income;

/**
 * The output Data for Add Income Use Case.
 * This creates an Output Data Object for Interactor to update Database/Presenter to update the View.
 */

public class AddIncomeOutputData {

    private final String name;
    private final boolean useCaseFailed;

    public AddIncomeOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    // why is this never used i'm gonna cry.
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
