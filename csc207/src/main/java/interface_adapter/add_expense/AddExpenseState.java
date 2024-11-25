package interface_adapter.add_expense;

/**
 * The state for the Add Expense View Model.
 */
public class AddExpenseState {

    private String name = "";
    private String nameError;

    public String getExpenseError() {
        return nameError;
    }

    public void setExpenseError(String nameError) {
        this.nameError = nameError;
    }

    @Override
    public String toString() {
        return "To be implemented/ in progress";
    }
}
