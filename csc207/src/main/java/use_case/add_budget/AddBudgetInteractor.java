package use_case.add_budget;

import entity.Budget;
import entity.BudgetHistory;
import use_case.add_budget.*;

/**
 * The Add Budget Interactor.
 */
public class AddBudgetInteractor implements AddBudgetInputBoundary {
    private final AddBudgetUserDataAccessInterface userDataAccessObject;
    private final AddBudgetOutputBoundary userPresenter;
    private final BudgetHistory budgetHistory;

    public AddBudgetInteractor(AddBudgetUserDataAccessInterface userDataAccessObject,
                               AddBudgetOutputBoundary userPresenter,
                               BudgetHistory budgetHistory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.budgetHistory = budgetHistory;
    }

    /**
     * Execute the Add Budget Use Case.
     *
     * @param addBudgetInputData the input data for this use case
     */
    @Override
    public void execute(AddBudgetInputData addBudgetInputData) {
        final Budget budget = new Budget(null, null);
        budget.setAmount(addBudgetInputData.getAmount());
        budget.setCategoryName(addBudgetInputData.getCategoryName());
        budgetHistory.add(budget);
        // userDataAccessObject.save(budget);
        // do we want a save for this? do we need one?
        userDataAccessObject.addBudget(budget);
        final AddBudgetOutputData addBudgetOutputData = new AddBudgetOutputData(budget.getCategoryName(), false);
        userPresenter.prepareSuccessView(addBudgetOutputData);
    }
    @Override
    public void switchToHomeView() {
        userPresenter.switchToBudgetView();
    }
}
