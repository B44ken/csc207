package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseFactoryTest {
    @Test
    void createExpenseTest() throws Exception {
        ExpenseFactory expenseFactory = new ExpenseFactory();
        LocalDate testDate = LocalDate.of(2020, 1, 1);
        Expense testExpense = new Expense("McDonald's", 30.0, "food", testDate);
        Expense compareExpense = expenseFactory.create("McDonald's", 30.0, "food",
                LocalDate.parse("2020-01-01"));
        assertEquals(testExpense.getName(), compareExpense.getName());
        assertEquals(testExpense.getAmount(), compareExpense.getAmount());
        assertEquals(testExpense.getCategory(), compareExpense.getCategory());
        assertEquals(testExpense.getDate(), compareExpense.getDate());

    }
}
