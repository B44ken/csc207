package use_case.add_budget;

/**
 * The output Data for Add Income Use Case.
 */

public class AddBudgetOutputData {

    private final String categoryName;
    private final boolean useCaseFailed;

    /**
     * Creates an AddBudgetOutputData object with categoryName and useCaseFailed.
     * @param categoryName the name to set AddBudgetOutputData's categoryName to.
     * @param useCaseFailed boolean representing passing or failure of Use Case.
     */
    public AddBudgetOutputData(String categoryName, boolean useCaseFailed) {
        this.categoryName = categoryName;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Getter for categoryName of AddBudgetOutputData.
     * @return the categoryName of AddBudgetOutputData.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Returns useCaseFailed for AddBudgetOutputData.
     * @return boolean of if use case passed or failed.
     */
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
