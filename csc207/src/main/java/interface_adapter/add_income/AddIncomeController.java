package interface_adapter.add_income;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import data_access.UserData;
import use_case.add_income.AddIncomeInputBoundary;
import use_case.add_income.AddIncomeInputData;
import use_case.add_income.AddIncomeInteractor;
import use_case.add_income.AddIncomeOutputBoundary;

import java.time.LocalDate;

/**
 * Controller for Add Income use case.
 */
public class AddIncomeController {
    private final AddIncomeInteractor addIncomeUseCaseInteractor;
    private final UserData userData ;

    public AddIncomeController(AddIncomeInteractor addIncomeUseCaseInteractor, UserData userData) {
        this.addIncomeUseCaseInteractor = addIncomeUseCaseInteractor;
        this.userData = userData;
    }

    /**
     * Executes the Add Income use case by passing UserData into Interactor
     * @param userData
     *
     */
    public void execute(UserData userData) {
        addIncomeUseCaseInteractor.execute(userData);
    }

}
