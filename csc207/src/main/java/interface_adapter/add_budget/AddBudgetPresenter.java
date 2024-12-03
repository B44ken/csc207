package interface_adapter.add_budget;

import use_case.add_budget.AddBudgetOutputBoundary;

/**
 * Presenter for Add Budget Use Case.
 */
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
