package use_case.add_expense;

import data_access.UserData;
import entity.*;
import entity.Expense;

import java.time.LocalDate;
import java.time.DateTimeException;

/**
 * The Add Expense Interactor.
 */
public class AddExpenseInteractor implements AddExpenseInputBoundary {
    private final AddExpenseOutputBoundary addExpensePresenter;
    private final UserData userData;
    private final ExpenseFactory expenseFactory;

    public AddExpenseInteractor(UserData ud, AddExpenseOutputBoundary addExpenseOutputBoundary,
                                ExpenseFactory expenseFactory) {
        this.addExpensePresenter = addExpenseOutputBoundary;
        this.userData = ud;
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
        } else if (amountStr.equals("")) {
            addExpensePresenter.prepareFailView("Amount field cannot be blank");
            return;
        } else if (category.equals("")) {
            addExpensePresenter.prepareFailView("Category field cannot be blank");
            return;
        } else {
            try {Double.valueOf(amountStr); }
            catch (NumberFormatException e) {
                addExpensePresenter.prepareFailView("Invalid amount for parsing.");
                return;
            }

            try {Integer.parseInt(addExpenseInputData.getDay()); }
            catch (NumberFormatException e) {
                addExpensePresenter.prepareFailView("Invalid day for parsing.");
            }

            try {Integer.parseInt(addExpenseInputData.getMonth()); }
            catch (NumberFormatException e) {
                addExpensePresenter.prepareFailView("Invalid month for parsing.");
            }

            try {Integer.parseInt(addExpenseInputData.getYear()); }
            catch (NumberFormatException e) {
                addExpensePresenter.prepareFailView("Invalid year for parsing.");
            }
        }
        try {
            LocalDate date = LocalDate.of(Integer.parseInt(addExpenseInputData.getYear()),
                    Integer.parseInt(addExpenseInputData.getMonth()), Integer.parseInt(addExpenseInputData.getDay()));
        } catch (DateTimeException ex) {
            addExpensePresenter.prepareFailView("Invalid date for parsing.");
            return;
        }
        try {
            LocalDate date = LocalDate.of(Integer.parseInt(addExpenseInputData.getYear()),
                    Integer.parseInt(addExpenseInputData.getMonth()), Integer.parseInt(addExpenseInputData.getDay()));
            var amount = Double.parseDouble(amountStr);
            var t = new Expense(name, amount, category, date);
            userData.getHistory().add(t);
            userData.save();

            final AddExpenseOutputData addExpenseOutputData = new AddExpenseOutputData(name);
            addExpensePresenter.prepareSuccessView(addExpenseOutputData);
        } catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
            addExpensePresenter.prepareFailView("failed to parse amount");
        }
    }
}
