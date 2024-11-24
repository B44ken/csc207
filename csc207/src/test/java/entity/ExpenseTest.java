package entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class ExpenseTest {

    @Test
    void getExpenseNameTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", 20.0, "food", date);
        if (!"McDonald's".equals(expense.getName())) {
            throw new Exception("getExpenseNameTest failed");
        }
    }

    @Test
    void setExpenseNameTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense(null, 20.0, "food", date);
        expense.setName("McDonald's");
        if (!"McDonald's".equals(expense.getName())) {
            throw new Exception("setExpenseNameTest failed");
        }
    }

    @Test
    void getDateTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", 20.0, "food", date);
        if (!date.equals(expense.getDate())) {
            throw new Exception("getDateTest failed");
        }
    }

    @Test
    void setDateTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", 20.0, "food", null);
        expense.setDate(date);
        if (!date.equals(expense.getDate())) {
            throw new Exception("setDateTest failed");
        }
    }

    @Test
    void getAmountTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", 20.0, "food", date);
        Double amount = expense.getAmount();
        if (!amount.equals(20.0)) {
            throw new Exception("getAmountTest failed");
        }
    }

    @Test
    void setAmountTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", null, "food", date);
        Double amount = 100.0;
        expense.setAmount(amount);
        Double setAmount = expense.getAmount();
        if (!setAmount.equals(100.0)) {
            throw new Exception("setAmountTest failed");
        }
    }

    @Test
    void getCategoryTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", 20.0, "food", date);
        String category = expense.getCategory();
        if (!category.equals("food")) {
            throw new Exception("getCategoryTest failed");
        }
    }

    @Test
    void setCategoryTest() throws Exception {
        LocalDate date = LocalDate.of(2024, 12, 2);
        Expense expense = new Expense("McDonald's", 20.0, null, date);
        String category = "food";
        expense.setCategory(category);
        String setCategory = expense.getCategory();
        if (!setCategory.equals("food")) {
            throw new Exception("setCategoryTest failed");
        }

    }
}
