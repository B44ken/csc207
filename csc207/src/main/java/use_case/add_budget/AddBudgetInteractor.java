package use_case.add_budget;

import data_access.UserData;
import entity.Budget;
import entity.BudgetFactory;


/**
 * The Add Budget Interactor.
 */
public class AddBudgetInteractor {
    private final UserData userData;
    private final BudgetFactory budgetFactory;

    private final AddBudgetOutputBoundary userPresenter;

    public AddBudgetInteractor(UserData userData, AddBudgetOutputBoundary userPresenter, BudgetFactory budgetFactory) {
        this.userData = userData;
        this.budgetFactory = budgetFactory;
        this.userPresenter = userPresenter;
    }

    /**
     * Execute the Add Budget Use Case.
     *
     * @param addBudgetInputData the input data for this use case
     */
    public void execute(AddBudgetInputData addBudgetInputData) {
        final Budget budget = budgetFactory.create(addBudgetInputData.getCategoryName(), addBudgetInputData.getAmount());
        userData.getBudgets().add(budget);
        userData.save();    
    }
}
