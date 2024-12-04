package use_case.get_insight;

import data_access.UserData;
import entity.Deductible;
import entity.DeductibleFactory;
import entity.Expense;
import entity.Income;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetInsightInteractorTest {
    private UserData testUserData;
    private DeductibleFactory testDeductibleFactory;
    private GetInsightInputBoundary testGetInsightInteractor;
    private GetInsightInputData testGetInsightInputData;

    @BeforeEach
    void setUp() {
        testUserData = new UserData();
        testDeductibleFactory = new DeductibleFactory();
        Deductible test = testDeductibleFactory.createDeductible(new Expense("donation", 100.0, "charity", LocalDate.now())
                , new Income("donation", 75.0, "charity", LocalDate.now()));
        testUserData.getHistory().add(test.getIncome());
        Deductible test2 = testDeductibleFactory.createDeductible(new Expense("second donation", 200.0,"charity", LocalDate.of(2024, 1,1))
                , new Income("second donation", 75.0, "charity", LocalDate.of(2024, 1,1)));
        testUserData.getHistory().add(test2.getIncome());
        Expense expenseFake = new Expense("food", 2.00, "expense", LocalDate.now());
        testUserData.getHistory().add(expenseFake);
        testGetInsightInteractor = new GetInsightInteractor(testUserData);
        testGetInsightInputData = new GetInsightInputData(testUserData.getHistory());
    }

    @Test
    void getInsightInteractorTest() {
        testUserData.getHistory();
        testGetInsightInputData = new GetInsightInputData(testUserData.getHistory());
        try {
            ArrayList<Deductible> target = testGetInsightInteractor.execute(testGetInsightInputData);
            if (target.size() != 2) {
                System.out.println(target.toString());
                throw new Exception("Fail: Transaction that is NOT deductible was added");
            }
            if (target.isEmpty()) {
                throw new Exception("Fail: Deductibles were not added to list.");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
