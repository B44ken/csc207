package entity;


/**
 * Budget class.
 */
public class Budget {
    private String categoryName;
    private Double amount;

    public Budget(String budgetcategory, Double budgetamount) {
        this.categoryName = budgetcategory;
        this.amount = budgetamount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String newName) {
        this.categoryName = newName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Budget Type: " + this.categoryName + ", Amount: $" + this.amount;
    }

}