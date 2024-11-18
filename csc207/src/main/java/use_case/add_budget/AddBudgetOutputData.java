package use_case.add_budget;

/**
 * The output Data for Add Income Use Case.
 */

public class AddBudgetOutputData {

    private final String categoryName;
    private final boolean useCaseFailed;

    public AddBudgetOutputData(String categoryName, boolean useCaseFailed) {
        this.categoryName = categoryName;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
