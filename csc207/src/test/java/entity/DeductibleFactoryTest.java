package entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class DeductibleFactoryTest {

    private DeductibleFactory testDeductibleFactory;

    @BeforeEach
     void setUpForTest() {
        testDeductibleFactory = new DeductibleFactory();
    }

    @Test
    void deductibleFactoryTest() {
        Deductible testing = new Deductible(new Expense("donation", 100.0, "charity", LocalDate.now())
                , new Income("donation", 75.0, "charity", LocalDate.now()));
        try {
            if (!Objects.equals(testing.getExpenseName(), "donation")) {
                throw new Exception("Fail: Name is incorrect");
            }

            if (!Objects.equals(testing.getCreditDate(), LocalDate.now())) {
                throw new Exception("Fail: Name is incorrect");
            }

            if (testing.getIncomeAmount() != 75.0) {
                throw new Exception("Fail: Income Amount is incorrect");
            }

            System.out.println("Success: deductible created.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
