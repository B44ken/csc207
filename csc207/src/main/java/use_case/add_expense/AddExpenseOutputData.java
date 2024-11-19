package use_case.add_expense;

/**
 * Output data for Add Expense Use Case.
 */
public class AddExpenseOutputData {

    private final String name;

    private final boolean useCaseFailed;

    public AddExpenseOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
