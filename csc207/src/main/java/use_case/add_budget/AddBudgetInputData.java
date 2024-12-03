package use_case.add_budget;

/**
 * The AddBudgetInputData class for Add Budget Use Case.
 */
public class AddBudgetInputData {
    private final String categoryName;
    private final Double amount;

    /**
     * Creates AddBudgetInputData with categoryName and amount.
     * @param categoryName the name to set AddBudgetInputData's categoryName to.
     * @param amount the amount to set AddBudgetInputData's amount to.
     */
    public AddBudgetInputData(String categoryName, Double amount) {
        this.categoryName = categoryName;
        this.amount = amount;
    }

    /**
     * Getter for AddBudgetInputData's categoryName.
     * @return the AddBudgetInputData's categoryName.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Getter for AddBudgetInputData's amount.
     * @return the AddBudgetInputData's amount.
     */
    public Double getAmount() {
        return amount;
    }

}
