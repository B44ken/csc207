package interface_adapter.add_budget;

import use_case.add_budget.AddBudgetInputData;
import use_case.add_budget.AddBudgetInteractor;

/**
 * Controller for Add Budget use case.
 */
public class AddBudgetController {

    private final AddBudgetInteractor addBudgetInteractor;

    /**
     * Initializes an AddBudgetController with an AddBudgetInteractor.
     * @param addBudgetInteractor the add budget Interactor.
     */
    public AddBudgetController(AddBudgetInteractor addBudgetInteractor) {
        // this.addBudgetInputBoundary = addBudgetInputBoundary;
        this.addBudgetInteractor = addBudgetInteractor;

        // userData = ud;
        // viewSwitcher = vs;

    }

    /**
     * Creates an AddBudgetInputData to pass into an AddBudgetInteractor.
     * @param categoryName the category name of Budget.
     * @param amountStr the amount of Budget as a String.
     */
    public void addBudget(String categoryName, String amountStr) {

        if (categoryName == null || amountStr == null) {
            System.out.println("invalid input");
            return;
        }
        try {
            final var amount = Double.parseDouble(amountStr);
            final AddBudgetInputData addBudgetInputData = new AddBudgetInputData(categoryName, amount);
            addBudgetInteractor.execute(addBudgetInputData);
        }
        catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
        }
    }

}
