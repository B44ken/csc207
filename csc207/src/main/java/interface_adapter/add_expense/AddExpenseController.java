package interface_adapter.add_expense;

import java.time.LocalDate;

import com.labrats.app.ViewNames;

import data_access.UserData;
import entity.Expense;
import use_case.add_expense.AddExpenseInputData;
import use_case.add_expense.AddExpenseInteractor;
import use_case.add_expense.AddExpenseOutputBoundary;
import use_case.add_expense.AddExpenseOutputData;
import use_case.add_income.AddIncomeInputData;
import view.AddExpenseView;
import view.ViewSwitcher;

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
        Double doubleAmount = Double.valueOf(amount);
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date));
        final AddExpenseInputData addExpenseInputData = new AddExpenseInputData(name, doubleAmount, category, localDate);
        addExpenseInteractor.execute(addExpenseInputData);
    }
}