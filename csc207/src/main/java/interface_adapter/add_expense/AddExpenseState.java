package interface_adapter.add_expense;

import java.time.LocalDate;

/**
 * The state for the Add Expense View Model.
 */
public class AddExpenseState {

    private String name = "";
    private String nameError;
    private double amount = 0;
    private double amountError;
    private String category = "";
    private String categoryError;
    private LocalDate date = LocalDate.now();
    private LocalDate dateError;

    public String getName() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }

    public double getAmount() {
        return amount;
    }
    public double getAmountError() {
        return amountError;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryError() {
        return categoryError;
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalDate getDateError() {
        return dateError;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAmountError(double amountError) {
        this.amountError = amountError;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDateError(LocalDate dateError) {
        this.dateError = dateError;
    }

    @Override
    public String toString() {
        return "To be implemented/ in progress";
    }
}
