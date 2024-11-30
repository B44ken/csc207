package use_case.add_budget;

import entity.BudgetHistory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddBudgetInteractorTest {

    @Test
    void successTest() {
        AddBudgetInputData inputData = new AddBudgetInputData("food", 50.0);
        BudgetHistory budgetHistory = new BudgetHistory();
        // do we need to check for budgetHistory?
        // AddBudgetUserDataAccessInterface totalHistory = new InMemoryUserDataAccessObject();
        // fix red once InMemoryUserDataAccessObject is created

        // This creates a successPresenter that tests whether the test case is as we expect.
        AddBudgetOutputBoundary successPresenter = new AddBudgetOutputBoundary() {
            @Override
            public void prepareSuccessView(AddBudgetOutputData budget) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("food", budget.getCategoryName());
                // should i be checking that budget is in budgetHistory here???
                // assertTrue(totalHistory.existsByName("food"));
                // fix red
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToHomeView() {
                // This is expected
            }
        };

        // AddBudgetInputBoundary interactor = new AddBudgetInteractor(userRepository, successPresenter, budgetHistory);
        // fix red once implemented
        interactor.execute(inputData);
    }
}
