package use_case.add_budget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data_access.UserData;
import entity.Budget;
import entity.BudgetFactory;
import interface_adapter.add_budget.AddBudgetPresenter;

/**
 * Test class for AddBudgetInteractor.
 */
public class AddBudgetInteractorTest {

    private UserData testUserData;
    private BudgetFactory testBudgetFactory;
    private AddBudgetOutputBoundary testUserPresenter;
    private AddBudgetInteractor testAddBudgetInteractor;

    private AddBudgetInputData testAddBudgetInputData;

    /**
     * Before each test, required parameters for AddBudgetInteractor construction.
     */
    @BeforeEach
    void setUpForTests() {
        testUserData = new UserData();
        testBudgetFactory = new BudgetFactory();
        testUserPresenter = new AddBudgetPresenter();
        // testAddBudgetInteractor = new AddBudgetInteractor(testUserData, testUserPresenter, testBudgetFactory);
        // testAddBudgetInputData = new AddBudgetInputData("food", 50.0);
    }

    /**
     * Test for execute() method of AddBudgetInteractor.
     */
    @Test
    void addToUserDataTest() {
        testAddBudgetInteractor = new AddBudgetInteractor(testUserData, testUserPresenter, testBudgetFactory);
        testAddBudgetInputData = new AddBudgetInputData("food", 50.0);
        testAddBudgetInteractor.execute(testAddBudgetInputData);
        if (!testUserData.getBudgets().getList().isEmpty()) {
            final Budget thisBudget = testUserData.getBudgets().getList().get(0);
            if (thisBudget.getCategoryName().equals("food") && thisBudget.getAmount() == 50.0) {
                System.out.println("Success: Adding to User Data");
            }
            else {
                System.err.println("Fail: Adding to User Data");
            }
        }
    }
}
