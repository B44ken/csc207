package interface_adapter.add_income;

/**
 * The State information representing the new income transaction to be logged.
 */
public class AddIncomeState {
    private String name = "";

    private String addFail;

    public AddIncomeState(AddIncomeState copy) {
        this.name = copy.name;
        this.addFail = copy.addFail;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    // I DON'T GET THIS
    public AddIncomeState() {
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
