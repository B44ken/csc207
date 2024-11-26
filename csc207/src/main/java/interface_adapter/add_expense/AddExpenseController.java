package interface_adapter.add_expense;

import use_case.add_expense.AddExpenseInputBoundary;
import use_case.add_expense.AddExpenseInputData;

import java.time.LocalDate;

/**
 * The controller for the Add Expense Use Case.
 */
public class AddExpenseController {

    private final AddExpenseInputBoundary addExpenseUseCaseInteractor;

    public AddExpenseController(AddExpenseInputBoundary addExpenseUseCaseInteractor) {
        this.addExpenseUseCaseInteractor = addExpenseUseCaseInteractor;
    }

    /**
     * Executes the Add Expense Use Case.
     * @param name the name of the expense
     * @param amount the amount of the expense
     * @param category the category of the expense
     * @param date the date of the expense
     */
    public void execute(String name, double amount, String category, LocalDate date){
        final AddExpenseInputData addExpenseInputData = new AddExpenseInputData(name, amount, category, date);

        addExpenseUseCaseInteractor.execute(addExpenseInputData);
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
        addExpenseUseCaseInteractor.switchToHomeView();
    }
}
