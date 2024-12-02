package interface_adapter.add_expense;

import java.time.LocalDate;

import com.labrats.app.ViewNames;

import data_access.UserData;
import entity.Expense;
import view.ViewSwitcher;

public class AddExpenseController {
    private UserData userData;
    private ViewSwitcher viewSwitcher;

    public AddExpenseController(ViewSwitcher vs, UserData ud) {
        this.userData = ud;
        this.viewSwitcher = vs;
    }

    public void addExpense(String name, String amountStr, String category) {
        var date = LocalDate.now();

        if (name == null || amountStr == null || category == null) {
            System.out.println("invalid input");
            return;
        }
        try {
            var amount = Double.parseDouble(amountStr);
            var t = new Expense(name, amount, category, date);
            userData.getHistory().add(t);
            userData.save();
        } catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
        }
    }

    public void switchToHome() {
        viewSwitcher.switchTo(ViewNames.home);
    }
}