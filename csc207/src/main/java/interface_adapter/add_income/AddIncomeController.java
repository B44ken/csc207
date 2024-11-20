package interface_adapter.add_income;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import use_case.add_income.AddIncomeInputBoundary;
import use_case.add_income.AddIncomeInputData;

import java.time.LocalDate;

/**
 * Controller for Add Income use case.
 */
public class AddIncomeController {
    private final AddIncomeInputBoundary addIncomeUseCaseInteractor;
    public AddIncomeController(AddIncomeInputData addIncomeUseCaseInteractor) {
        this.addIncomeUseCaseInteractor = addIncomeUseCaseInteractor;
    }

    /**
     * Executes the Add Income use case.
     * @param name to be added
     * @param amount
     * @param category
     * @param date
     *
     */
    public void execute(String name, double amount, String category, LocalDate date) {
        final AddIncomeInputData addIncomeInputData = new AddIncomeInputData(name, amount, category, date);

        addIncomeUseCaseInteractor.execute(addIncomeInputData);
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToHomeView() {
        addIncomeUseCaseInteractor.switchToHomeView();
    }



}
