package interface_adapter.add_budget;

// takes output data and turns it into raw strings
// this tells UI what to do when the use case finishes running

import com.labrats.app.ViewNames;
import use_case.add_budget.AddBudgetOutputBoundary;
import use_case.add_income.AddIncomeOutputBoundary;
import view.AddIncomeView;
import view.ViewSwitcher;

public class AddBudgetPresenter implements AddBudgetOutputBoundary {

    public AddBudgetPresenter() {
    }

    /**
     * Prepares the success view for the Add Budget Use Case.
     *
     */
    @Override
    public void prepareSuccessView() {
        // On success, switch to expenseHistory view.
    }

    /**
     * Prepares the failure view for the Add Budget Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // this use case currently cannot fail.
    }

}
