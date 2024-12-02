package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ExpenseFactoryTest {
    @Test
    void createExpenseTest() throws Exception {
        ExpenseFactory expenseFactory = new ExpenseFactory();
        LocalDate testDate = LocalDate.of(2020, 1, 1);
        Income testIncome = new Income("McDonald's", 30.0, "food", testDate);
        boolean b = !testIncome.equals(expenseFactory.create("McDonald's", 30.0, "food",
                LocalDate.parse("01-01-2020")));


        if (b){
            throw new Exception("createExpense error.");
        }
    }
}
