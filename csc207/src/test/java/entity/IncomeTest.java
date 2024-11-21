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

