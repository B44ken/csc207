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

    public AddExpensePresenter() {
    }
    @Override
    public void prepareSuccessView() {
    }

    @Override
    public void prepareFailView(String error) {
    }

}
