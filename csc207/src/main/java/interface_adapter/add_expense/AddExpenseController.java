
package interface_adapter.add_expense;

import use_case.add_expense.AddExpenseInputData;
import use_case.add_expense.AddExpenseInteractor;

/**
 * The Controller for Add Expense Use Case.
 */
public class AddExpenseController {
    private final AddExpenseInteractor addExpenseInteractor;

    public AddExpenseController(AddExpenseInteractor addExpenseInteractor) {
        this.addExpenseInteractor = addExpenseInteractor;
    }

    /**
     * Executes the Add Income use case by passing UserData into Interactor.
     * @param name name of expense
     * @param amount of money
     * @param category of expenditure
     * @param year of expense
     * @param month of expense
     * @param date of expenditure
     *
     */
    public void execute(String name, String amount, String category, String year, String month, String date) {
        final AddExpenseInputData addExpenseInputData = new AddExpenseInputData(name,
                amount, category, date, month, year);
        addExpenseInteractor.execute(addExpenseInputData);
    }
}