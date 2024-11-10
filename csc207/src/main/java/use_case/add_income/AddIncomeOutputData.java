package use_case.add_income;

/**
 * The output Data for Add Income Use Case.
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
