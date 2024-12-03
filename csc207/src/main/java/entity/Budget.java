package entity;

/**
 * Budget class.
 *
 */
public class Budget {
    private String categoryName;
    private Double amount;

    /**
     * Creates a new Budget.
     * @param budgetcategory the categoryName of the Budget.
     * @param budgetamount the amount of the Budget.
     */
    public Budget(String budgetcategory, Double budgetamount) {
        this.categoryName = budgetcategory;
        this.amount = budgetamount;
    }

    /**
     * Returns the categoryName of the Budget.
     * @return the categoryName of the Budget.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the categoryName of the Budget to newName.
     * @param newName the new name for categoryName to be set to.
     */
    public void setCategoryName(String newName) {
        this.categoryName = newName;
    }

    /**
     * Returns the amount of the Budget.
     * @return the amount of the Budget,
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the Budget to new amount.
     * @param amount the new amount for amount to be set to.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns a string representation of Budget.
     * @return the string representation of Budget.
     */
    @Override
    public String toString() {
        return "Budget Type: " + this.categoryName + ", Amount: $" + this.amount;
    }

}
