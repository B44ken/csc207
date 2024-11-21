package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class IncomeTest {

    @Test
    void getIncomeNameTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income("bonus", 100.0, "salary", date);
        if (!"bonus".equals(income.getName())) {
            throw new Exception("getName() method error.");
        }
    }

    @Test
    void setIncomeNameTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income(null, 100.0, "salary", date);
        income.setName("bonus");
        if (!"bonus".equals(income.getName())) {
            throw new Exception("setName() method error.");
        }
    }

    @Test
    void getIncomeAmountTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income("bonus", 100.0, "salary", date);
        Double amount = income.getAmount();
        if (!amount.equals(100.0)) {
            throw new Exception("getAmount() method error.");
        }
    }

    @Test
    void setIncomeAmountTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income("bonus", null, "salary", date);
        Double newAmount = 100.0;
        income.setAmount(newAmount);
        Double setAmount = income.getAmount();
        if (!setAmount.equals(100.0)) {
            throw new Exception("setAmount() method error.");
        }
    }

    @Test
    void getIncomeCategoryTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income("bonus", 100.0, "salary", date);
        if (!"salary".equals(income.getCategory())) {
            throw new Exception("getCategory() method error.");
        }
    }

    @Test
    void setIncomeCategoryTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income("bonus", 100.0, null, date);
        income.setCategory("salary");
        if (!"salary".equals(income.getCategory())) {
            throw new Exception("setCategory() method error.");
        }
    }

    @Test
    void getIncomeDateTest() throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Income income = new Income("bonus", 100.0, "salary", date);
        if (!date.equals(income.getDate())) {
            throw new Exception("getDate() method error.");
        }
    }
}

