package interface_adapter.add_budget;

/**
 * The State information representing the new budget to be logged.
 */
public class AddBudgetState {
    private String name = "";

    private String addError;

    /**
     * Initializes AddBudgetState object with copy.
     * @param copy another AddBudgetState.
     */
    public AddBudgetState(AddBudgetState copy) {
        this.name = copy.name;
        this.addError = copy.addError;
    }

    /**
     * AddBudgetState method.
     */
    public AddBudgetState() {
    }

    /**
     * Getter for name of AddBudgetState.
     * @return the name of AddBudgetState.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name of AddBudgetState to name.
     * @param name the new name to set AddBudgetState's name to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for name of AddBudgetState to name.
     * @param addError new addError to set AddBudgetState's addError to.
     */
    public void setAddError(String addError) {
        this.addError = addError;
    }
}
