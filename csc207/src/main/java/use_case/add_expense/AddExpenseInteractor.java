package use_case.add_expense;

import data_access.UserData;
import entity.Expense;
import entity.TransactionFactory;
import entity.Transaction;

import java.time.LocalDate;

import entity.Expense;

/**
 * The Add Expense Interactor
 */
public class AddExpenseInteractor implements AddExpenseInputBoundary {
    private final AddExpenseOutputBoundary addExpensePresenter;
    private final UserData userData;

    public AddExpenseInteractor(AddExpenseOutputBoundary addExpenseOutputBoundary, UserData ud) {
        this.addExpensePresenter = addExpenseOutputBoundary;
        this.userData = ud;
    }

    @Override
    public void addExpense(AddExpenseInputData addExpenseInputData) {
        var date = LocalDate.now();
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
        }
        try {
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

    @Override
    public void switchToHomeView() {
        addExpensePresenter.switchToHomeView();
    }
}
