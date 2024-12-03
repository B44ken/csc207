package entity;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Test class for Income entity.
 */
public class IncomeTest {

    /**
     * Test for getName() method of Income.
     * @throws Exception thrown if getName() method fails.
     */
    @Test
    void getIncomeNameTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", 100.0, "salary", date);
        if (!"bonus".equals(income.getName())) {
            throw new Exception("getName() method error.");
        }
    }

    /**
     * Test for setName() method of Income.
     * @throws Exception thrown if setName() method fails.
     */
    @Test
    void setIncomeNameTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income(null, 100.0, "salary", date);
        income.setName("bonus");
        if (!"bonus".equals(income.getName())) {
            throw new Exception("setName() method error.");
        }
    }

    /**
     * Test for getAmount() method of Income.
     * @throws Exception thrown if getAmount() method fails.
     */
    @Test
    void getIncomeAmountTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", 100.0, "salary", date);
        final Double amount = income.getAmount();
        if (!amount.equals(100.0)) {
            throw new Exception("getAmount() method error.");
        }
    }

    /**
     * Test for setAmount() method of Income.
     * @throws Exception thrown if setAmount() method fails.
     */
    @Test
    void setIncomeAmountTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", null, "salary", date);
        final Double newAmount = 100.0;
        income.setAmount(newAmount);
        // Double setAmount = income.getAmount();
        if (!newAmount.equals(income.getAmount())) {
            throw new Exception("setAmount() method error.");
        }
    }

    /**
     * Test for getCategory() method of Income.
     * @throws Exception thrown if getCategory() method fails.
     */
    @Test
    void getIncomeCategoryTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", 100.0, "salary", date);
        if (!"salary".equals(income.getCategory())) {
            throw new Exception("getCategory() method error.");
        }
    }

    /**
     * Test for setCategory() method of Income.
     * @throws Exception thrown if setCategory() method fails.
     */
    @Test
    void setIncomeCategoryTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", 100.0, null, date);
        income.setCategory("salary");
        if (!"salary".equals(income.getCategory())) {
            throw new Exception("setCategory() method error.");
        }
    }

    /**
     * Test for getDate() method of Income.
     * @throws Exception thrown if getDate() method fails.
     */
    @Test
    void getIncomeDateTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", 100.0, "salary", date);
        if (!date.equals(income.getDate())) {
            throw new Exception("getDate() method error.");
        }
    }

    /**
     * Test for setDate() method of Income.
     * @throws Exception thrown if setDate() method fails.
     */
    @Test
    void setIncomeDateTest() throws Exception {
        final LocalDate date = LocalDate.of(2020, 1, 1);
        final Income income = new Income("bonus", 100.0, "salary", null);
        income.setDate(date);
        if (!income.getDate().equals(date)) {
            throw new Exception("setDate() method error.");
        }
    }
}

