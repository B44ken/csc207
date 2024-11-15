package use_case.add_budget;


public class AddBudgetInputData {
    private final String categoryName;
    private final double amount;

    public AddBudgetInputData(String categoryName, double amount) {
        this.categoryName = categoryName;
        this.amount = amount;
    }

    String getCategoryName() {
        return categoryName;
    }

    double getAmount() {
        return amount;
    }

}
