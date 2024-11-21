package use_case.add_budget;


public class AddBudgetInputData {
    private final String categoryName;
    private final Double amount;

    public AddBudgetInputData(String categoryName, Double amount) {
        this.categoryName = categoryName;
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getAmount() {
        return amount;
    }

}
