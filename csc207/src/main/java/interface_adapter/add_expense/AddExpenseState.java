package interface_adapter.add_expense;

import interface_adapter.add_income.AddIncomeState;

/**
 * The state for the Add Expense View Model.
 */
public class AddExpenseState {

    private String name = "";

    private String addFail;

    public AddExpenseState(AddExpenseState copy) {
        this.name = copy.name;
        this.addFail = copy.addFail;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    // I DON'T GET THIS
    public AddExpenseState() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddFail(String addFail) {
        this.addFail = addFail;
    }
}
