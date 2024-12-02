package interface_adapter.add_budget;

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Budget;
import entity.Expense;
import use_case.add_budget.AddBudgetInputBoundary;
import use_case.add_budget.AddBudgetInputData;
import use_case.add_budget.AddBudgetInteractor;
import view.ViewSwitcher;

import java.time.LocalDate;
// import use_case.add_budget.AddBudgetInteractor;


/**
 * Controller for Add Budget use case.
 */
public class AddBudgetController {

    // private final AddBudgetInputBoundary addBudgetInteractor;
    // do we need inputboundary instead of AddBudgetInteractor
    private final AddBudgetInteractor addBudgetInteractor;

    //private UserData userData;
    //private ViewSwitcher viewSwitcher;

    public AddBudgetController(AddBudgetInteractor addBudgetInteractor) {
        // this.addBudgetInputBoundary = addBudgetInputBoundary;
        this.addBudgetInteractor = addBudgetInteractor;

        // userData = ud;
        // viewSwitcher = vs;

    }

    public void addBudget(String categoryName, String amountStr) {

        if (categoryName == null || amountStr == null) {
            System.out.println("invalid input");
            return;
        }
        try {
            var amount = Double.parseDouble(amountStr);
            // var t = new Budget(categoryName, amount);
            final AddBudgetInputData addBudgetInputData = new AddBudgetInputData(categoryName, amount);
            addBudgetInteractor.execute(addBudgetInputData);
            // userData.getBudgets().add(t);
            // userData.save();
        } catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
        }
    }

    /**
     * Executes the Add Budget use case.
     * @param categoryName to be added
     * @param amount
     *
     */
    // public void createUserData(String categoryName, Double amount) {
        // final AddBudgetInputData addBudgetInputData = new AddBudgetInputData(categoryName, amount);
        // final Budget budget = new Budget(null, null);
        // budget.setAmount(addBudgetInputData.getAmount());
        // budget.setCategoryName(addBudgetInputData.getCategoryName());
        // line above is for adding to budgethistory???? how do we add to budget history???? do we even need a budget history entity????? , not for adding to txt file
        // addBudgetInteractor.execute(addBudgetInputData);
    // }


}