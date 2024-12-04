package use_case.add_expense;

import java.time.DateTimeException;
import java.time.LocalDate;

import data_access.UserData;
import entity.Expense;
import entity.ExpenseFactory;

/**
 * The Add Expense Interactor, gets input data, turns amount into a double
 * Prepares success/fail views depending on input.
 */
public class AddExpenseInteractor implements AddExpenseInputBoundary {
    private final AddExpenseOutputBoundary addExpensePresenter;
    private final UserData userData;
    private final ExpenseFactory expenseFactory;

    public AddExpenseInteractor(UserData user, AddExpenseOutputBoundary addExpenseOutputBoundary,
                                ExpenseFactory expenseFactory) {
        this.addExpensePresenter = addExpenseOutputBoundary;
        this.userData = user;
        this.expenseFactory = expenseFactory;
    }

    @Override
    public void execute(AddExpenseInputData addExpenseInputData) {
        var name = addExpenseInputData.getName();
        var amountStr = addExpenseInputData.getAmountString();
        var category = addExpenseInputData.getCategory();

        if (name.equals("")) {
            addExpensePresenter.prepareFailView("Name field cannot be blank");
            return;
        }
        else if (amountStr.equals("")) {
            addExpensePresenter.prepareFailView("Amount field cannot be blank");
            return;
        }
        else if (category.equals("")) {
            addExpensePresenter.prepareFailView("Category field cannot be blank");
            return;
        }
        else {
            try {
                Double.valueOf(amountStr);
            }
            catch (NumberFormatException ex) {
                addExpensePresenter.prepareFailView("Invalid amount for parsing.");
                return;
            }

            try {
                Integer.parseInt(addExpenseInputData.getDay());
            }
            catch (NumberFormatException ex) {
                addExpensePresenter.prepareFailView("Invalid day for parsing.");
            }

            try {
                Integer.parseInt(addExpenseInputData.getMonth());
            }
            catch (NumberFormatException ex) {
                addExpensePresenter.prepareFailView("Invalid month for parsing.");
            }

            try {
                Integer.parseInt(addExpenseInputData.getYear());
            }
            catch (NumberFormatException ex) {
                addExpensePresenter.prepareFailView("Invalid year for parsing.");
            }
        }
        try {
            LocalDate date = LocalDate.of(Integer.parseInt(addExpenseInputData.getYear()),
                    Integer.parseInt(addExpenseInputData.getMonth()), Integer.parseInt(addExpenseInputData.getDay()));
        }
        catch (DateTimeException ex) {
            addExpensePresenter.prepareFailView("Invalid date for parsing.");
            return;
        }
        try {
            final LocalDate date = LocalDate.of(Integer.parseInt(addExpenseInputData.getYear()),
                    Integer.parseInt(addExpenseInputData.getMonth()), Integer.parseInt(addExpenseInputData.getDay()));
            final var amount = Double.parseDouble(amountStr);
            final var t = new Expense(name, amount, category, date);
            userData.getHistory().add(t);
            userData.save();

            final AddExpenseOutputData addExpenseOutputData = new AddExpenseOutputData(name);
            addExpensePresenter.prepareSuccessView(addExpenseOutputData);
        }
        catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
            addExpensePresenter.prepareFailView("failed to parse amount");
        }
    }
}
