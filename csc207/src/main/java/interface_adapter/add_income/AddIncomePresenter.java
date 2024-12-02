package interface_adapter.add_income;

// takes output data and turns it into raw strings
// this tells UI what to do when the use case finishes running

import com.labrats.app.ViewNames;
import use_case.add_income.AddIncomeOutputBoundary;
import view.AddIncomeView;
import view.ViewSwitcher;

public class AddIncomePresenter implements AddIncomeOutputBoundary {

    public AddIncomePresenter() {
    }

    /**
     * Prepares the success view for the Add Income Use Case.
     *
     */
    @Override
    public void prepareSuccessView() {
        // On success, switch to incomeHistory view.
    }

    /**
     * Prepares the failure view for the Add Income Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // this use case currently cannot fail.
    }

}
