package interface_adapter.add_budget;

import entity.Budget;
import entity.BudgetHistory;
import use_case.add_budget.AddBudgetInputBoundary;
import use_case.add_budget.AddBudgetInputData;
// import use_case.add_budget.AddBudgetInteractor;


/**
 * Controller for Add Budget use case.
 */
public class AddBudgetController {

    private final AddBudgetInputBoundary addBudgetInteractor;
    // do we need inputboundary instead of AddBudgetInteractor
    // private final AddBudgetInteractor addBudgetInteractor;

    public AddBudgetController(AddBudgetInputBoundary addBudgetInteractor) {
        // this.addBudgetInputBoundary = addBudgetInputBoundary;
        this.addBudgetInteractor = addBudgetInteractor;

    }

    /**
     * Executes the Add Budget use case.
     * @param categoryName to be added
     * @param amount
     *
     */
    public void createUserData(String categoryName, String amount) {
        Double convertedAmount = Double.valueOf(amount);
        final AddBudgetInputData addBudgetInputData = new AddBudgetInputData(categoryName, convertedAmount);
        final Budget budget = new Budget(null, null);
        budget.setAmount(addBudgetInputData.getAmount());
        budget.setCategoryName(addBudgetInputData.getCategoryName());
        // line above is for adding to budgethistory???? how do we add to budget history???? do we even need a budget history entity????? , not for adding to txt file
        addBudgetInteractor.execute(addBudgetInputData);
    }

    /**
     * Executes the "switch to Home View".
     */
    public void switchToHomeView() {
        addBudgetInteractor.switchToHomeView();
    }
}