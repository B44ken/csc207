package interface_adapter.add_budget;

/**
 * The State information representing the new budget to be logged.
 */
public class AddBudgetState {
    private String name = "";

    private String addError;

    public AddBudgetState(AddBudgetState copy) {
        this.name = copy.name;
        this.addError = copy.addError;
    }

    public AddBudgetState() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddError(String addError) {
        this.addError = addError;
    }
}