package interface_adapter.add_expense;

import java.time.LocalDate;

import com.labrats.app.ViewNames;

import data_access.UserData;
import entity.Expense;
import use_case.add_expense.AddExpenseOutputBoundary;
import use_case.add_expense.AddExpenseOutputData;
import view.ViewSwitcher;

public class AddExpenseController {
    private UserData userData;
    private ViewSwitcher viewSwitcher;

    private AddExpenseOutputBoundary presenter;

    public AddExpenseController(ViewSwitcher vs, UserData ud, AddExpenseOutputBoundary addExpenseOutputBoundary) {
        this.userData = ud;
        this.viewSwitcher = vs;
        this.presenter = addExpenseOutputBoundary;
    }

    public void addExpense(String name, String amountStr, String category) {
        var date = LocalDate.now();


        if (name.equals("")) {
            presenter.prepareFailView("Name field cannot be blank");
            return;
        } else if (amountStr.equals("")) {
            presenter.prepareFailView("Amount field cannot be blank");
            return;
        } else if (category.equals("")) {
            presenter.prepareFailView("Category field cannot be blank");
        } else {
            try {Double.valueOf(amountStr); }
            catch (NumberFormatException e) {
                presenter.prepareFailView("Invalid amount for parsing.");
                return;
            }
        }
        try {
            var amount = Double.parseDouble(amountStr);
            var t = new Expense(name, amount, category, date);
            userData.getHistory().add(t);
            userData.save();

            final AddExpenseOutputData addExpenseOutputData = new AddExpenseOutputData(name);
            presenter.prepareSuccessView(addExpenseOutputData);
        } catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
            presenter.prepareFailView("failed to parse amount");
        }
    }

    public void switchToHome() {
        viewSwitcher.switchTo(ViewNames.home);
    }
}