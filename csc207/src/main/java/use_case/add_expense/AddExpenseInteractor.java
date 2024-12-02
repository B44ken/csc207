package use_case.add_expense;

import data_access.UserData;
import entity.Expense;
import entity.ExpenseFactory;

import java.time.LocalDate;

/**
 * The Add Expense Interactor
 */
public class AddExpenseInteractor {
    private final UserData userData;
    private final ExpenseFactory expenseFactory;
    private final AddExpenseOutputBoundary userPresenter;

    public AddExpenseInteractor(UserData userData, AddExpenseOutputBoundary userPresenter,
                                ExpenseFactory expenseFactory) {
        this.userData = userData;
        this.expenseFactory = expenseFactory;
        this.userPresenter = userPresenter;
    }

    public void execute(AddExpenseInputData addExpenseInputData) {
        final Expense expense = expenseFactory.create(addExpenseInputData.getName(), addExpenseInputData.getAmount(),
                addExpenseInputData.getCategory(), addExpenseInputData.getDate());
        userData.getHistory().add(expense);
        userData.save();
    }
}
