package use_case.add_budget;

import data_access.UserData;
import entity.Budget;
import entity.BudgetFactory;
import entity.BudgetHistory;
import use_case.add_budget.*;

/**
 * The Add Budget Interactor.
 */
public class AddBudgetInteractor {
    private final UserData userData;
    private final BudgetFactory budgetFactory;
    // private final AddBudgetOutputBoundary addBudgetOutputBoundary;

    // private final AddBudgetUserDataAccessInterface userDataAccessObject;
    private final AddBudgetOutputBoundary userPresenter;
    // private final BudgetHistory budgetHistory;

    public AddBudgetInteractor(UserData userData, AddBudgetOutputBoundary userPresenter, BudgetFactory budgetFactory) {
        this.userData = userData;
        this.budgetFactory = budgetFactory;
        this.userPresenter = userPresenter;

        // this.userDataAccessObject = userDataAccessObject;
        // this.userPresenter = userPresenter;
        // this.budgetHistory = budgetHistory;
    }

    /**
     * Execute the Add Budget Use Case.
     *
     * @param addBudgetInputData the input data for this use case
     */
    // @Override
    public void execute(AddBudgetInputData addBudgetInputData) {
        final Budget budget = budgetFactory.create(addBudgetInputData.getCategoryName(), addBudgetInputData.getAmount());
        userData.getBudgets().add(budget);
        userData.save();
        // budget.setAmount(addBudgetInputData.getAmount());
        // budget.setCategoryName(addBudgetInputData.getCategoryName());
        // budgetHistory.add(budget);
        // userDataAccessObject.save(budget);
        // do we want a save for this? do we need one?
        // userDataAccessObject.addBudget(budget);
        // final AddBudgetOutputData addBudgetOutputData = new AddBudgetOutputData(budget.getCategoryName(), false);
        //userPresenter.prepareSuccessView(addBudgetOutputData);
    }
    // @Override
    // public void switchToHomeView() {
        // userPresenter.switchToBudgetView();
    //}
}
