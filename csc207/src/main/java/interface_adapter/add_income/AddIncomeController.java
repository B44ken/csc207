package interface_adapter.add_income;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import use_case.add_income.AddIncomeInputData;

import java.util.Date;

/**
 * Controller for Add Income use case.
 */
public class AddIncomeController {
    private final AddIncomeInputData addIncomeUseCaseInteractor;
    public AddIncomeController(AddIncomeInputData addIncomeUseCaseInteractor) {
        this.addIncomeUseCaseInteractor = addIncomeUseCaseInteractor;
    }

    /**
     * Executes the Change password use case.
     * @param name to be added
     * @param amount
     * @param category
     * @param date
     *
     */
    public void execute(String name, double amount, String category, Date date) {
        final AddIncomeInputData addIncomeInputData;
    }
}
