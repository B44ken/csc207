package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class IncomeFactoryTest {

    @Test
    void incomeCreateTest() throws Exception {
        IncomeFactory incomeFactory = new IncomeFactory();
        String stringDate = "2020-01-01";
        LocalDate testDate = LocalDate.parse(stringDate);
        Income testIncome = new Income("bonus", 100.0, "salary", testDate);
        boolean b = !testIncome.equals(incomeFactory.create("bonus", 100.0, "salary", testDate));
        if (b){
            throw new Exception("create() method error.");
        }
    }
}
