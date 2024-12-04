
package use_case.add_expense;

/**
 * Output data for Add Expense Use Case.
 */
public class AddExpenseOutputData {

    private final String name;

    public AddExpenseOutputData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}