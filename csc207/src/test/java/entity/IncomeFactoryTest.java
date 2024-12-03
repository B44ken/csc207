package entity;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Test class for IncomeFactory.
 */
public class IncomeFactoryTest {

    /**
     * Tests create() method of IncomeFactory.
     * @throws Exception thrown if create() method fails.
     */
    @Test
    void incomeCreateTest() throws Exception {
        final IncomeFactory incomeFactory = new IncomeFactory();
        final LocalDate testDate = LocalDate.of(2020, 1, 1);
        final Income testIncome = new Income("bonus", 100.0, "salary", testDate);
        final boolean b = !testIncome.equals(incomeFactory.create("bonus", 100.0, "salary",
                LocalDate.parse("01-01-2020")));

        if (b) {
            throw new Exception("create() method error.");
        }
    }
}
