package interface_adapter.add_budget;

import use_case.add_budget.AddBudgetInputBoundary;
import use_case.add_budget.AddBudgetInputData;


/**
 * Controller for Add Budget use case.
 */
public class AddBudgetController {

    private final AddBudgetInputBoundary addBudgetUseCaseInteractor;

    public AddBudgetController(AddBudgetInputBoundary addBudgetUseCaseInteractor) {
        this.addBudgetUseCaseInteractor = addBudgetUseCaseInteractor;
    }

    /**
     * Executes the Add Budget use case.
     * @param categoryName to be added
     * @param amount
     *
     */
    public void execute(String categoryName, Double amount) {
        final AddBudgetInputData addBudgetInputData = new AddBudgetInputData(categoryName, amount);
        addBudgetUseCaseInteractor.execute(addBudgetInputData);
    }

    /**
     * Executes the "switch to BudgetView" Use Case.
     */
    public void switchToBudgetView() {
        addBudgetUseCaseInteractor.switchToBudgetView();
    }
}