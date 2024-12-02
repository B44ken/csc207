package use_case.add_budget;

import data_access.UserData;
import entity.Budget;
import entity.BudgetFactory;
import entity.BudgetHistory;
import interface_adapter.add_budget.AddBudgetPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddBudgetInteractorTest {

    private UserData testUserData;
    private BudgetFactory testBudgetFactory;
    private AddBudgetOutputBoundary testUserPresenter;
    private AddBudgetInteractor testAddBudgetInteractor;

    private AddBudgetInputData testAddBudgetInputData;

    @BeforeEach
    void setUpForTests() {
        testUserData = new UserData();
        testBudgetFactory = new BudgetFactory();
        testUserPresenter = new AddBudgetPresenter();
        // testAddBudgetInteractor = new AddBudgetInteractor(testUserData, testUserPresenter, testBudgetFactory);
        // testAddBudgetInputData = new AddBudgetInputData("food", 50.0);
    }

    @Test
    void addToUserDataTest() {
        testAddBudgetInteractor = new AddBudgetInteractor(testUserData, testUserPresenter, testBudgetFactory);
        testAddBudgetInputData = new AddBudgetInputData("food", 50.0);
        try {
            testAddBudgetInteractor.execute(testAddBudgetInputData);
            if (!testUserData.getBudgets().getList().isEmpty()) {
                Budget thisBudget = testUserData.getBudgets().getList().get(0);
                if (thisBudget.getCategoryName().equals("food") && thisBudget.getAmount() == 50.0) {
                    System.out.println("Success: Adding to User Data");
                } else {
                    System.err.println("Fail: Adding to User Data");
                }
            }
        } catch (Exception e) {
            System.err.println("Fail: Adding to User Data");
        }
    }

}
