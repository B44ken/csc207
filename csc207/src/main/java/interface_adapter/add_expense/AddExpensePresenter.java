package interface_adapter.add_expense;

import javax.swing.*;

import com.labrats.app.ViewNames;
import use_case.add_expense.AddExpenseOutputBoundary;
import use_case.add_expense.AddExpenseOutputData;
import view.ViewSwitcher;


/**
 * The Presenter for the Add Expense Use Case.
 */
public class AddExpensePresenter implements AddExpenseOutputBoundary {

    private final ViewSwitcher viewSwitcher;

    public AddExpensePresenter(ViewSwitcher vs) {
        this.viewSwitcher = vs;
    }

    @Override
    public void prepareSuccessView(AddExpenseOutputData outputData) {
        JOptionPane.showMessageDialog(null, "Expense " + outputData.getName()
                + " successfully added!");
        viewSwitcher.switchTo(ViewNames.home);
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }

    @Override
    public void switchToHomeView() {
        viewSwitcher.switchTo(ViewNames.home);
    }
}
