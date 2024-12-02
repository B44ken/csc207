package interface_adapter.add_income;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import data_access.UserData;
import entity.Income;
import use_case.add_income.AddIncomeInputBoundary;
import use_case.add_income.AddIncomeInputData;
import use_case.add_income.AddIncomeInteractor;
import use_case.add_income.AddIncomeOutputBoundary;

import java.time.LocalDate;

/**
 * Controller for Add Income use case.
 */
public class AddIncomeController {
    private final AddIncomeInteractor addIncomeInteractor;

    public AddIncomeController(AddIncomeInteractor addIncomeInteractor) {
        this.addIncomeInteractor = addIncomeInteractor;
    }
    /**
     * Executes the Add Income use case by passing UserData into Interactor
     * @param name
     * @param amount
     * @param category
     * @param year
     * @param month
     * @param date
     *
     */
    public void execute(String name, String amount, String category, String year, String month, String date) {
        Double doubleAmount = Double.valueOf(amount);
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date));
        final AddIncomeInputData addIncomeInputData = new AddIncomeInputData(name, doubleAmount, category, localDate);
        addIncomeInteractor.execute(addIncomeInputData);
    }

}
