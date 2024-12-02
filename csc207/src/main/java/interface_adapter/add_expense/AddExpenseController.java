package interface_adapter.add_expense;

import java.time.LocalDate;

import use_case.add_expense.AddExpenseInputData;
import use_case.add_expense.AddExpenseInteractor;

public class AddExpenseController {
   private final AddExpenseInteractor addExpenseInteractor;

    public AddExpenseController(AddExpenseInteractor addExpenseInteractor) {
        this.addExpenseInteractor = addExpenseInteractor;
    }

    /**
     * Executes the Add Income use case by passing UserData into Interactor
     * @param name
     * @param amount
     * @param category
     * @param date
     *
     */
    public void execute(String name, String amount, String category, String year, String month, String date) {
        //Double doubleAmount = Double.valueOf(amount);
        final AddExpenseInputData addExpenseInputData = new AddExpenseInputData(name, amount, category, date, month, year);
        addExpenseInteractor.execute(addExpenseInputData);
    }
}