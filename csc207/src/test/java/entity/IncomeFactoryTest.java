package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class IncomeFactoryTest {

    @Test
    void incomeCreateTest() throws Exception {
        IncomeFactory incomeFactory = new IncomeFactory();
        LocalDate testDate = LocalDate.of(2020, 1, 1);
        Income testIncome = new Income("bonus", 100.0, "salary", testDate);
        boolean b = !testIncome.equals(incomeFactory.create("bonus", 100.0, "salary",
                LocalDate.parse("01-01-2020")));


        if (b){
            throw new Exception("create() method error.");
        }
    }
}
