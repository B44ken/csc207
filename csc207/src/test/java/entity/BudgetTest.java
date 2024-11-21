package entity;

import org.junit.jupiter.api.Test;


public class BudgetTest {

    @Test
    void getCategoryNameTest() throws Exception {
        Budget budget = new Budget("food", 50.0);
        if (!"food".equals(budget.getCategoryName())) {
            throw new Exception("getCategoryName() method error.");
        }
    }

    @Test
    void setCategoryNameTest() throws Exception {
        Budget budget = new Budget(null, 50.0);
        budget.setCategoryName("food");
        if (!"food".equals(budget.getCategoryName())) {
            throw new Exception("setCategoryName() method error.");
        }
    }

    @Test
    void getAmountTest() throws Exception {
        Budget budget = new Budget("food", 50.0);
        Double amount = budget.getAmount();
        if (!amount.equals(50.0)) {
            throw new Exception("getAmount() method error.");
        }
    }

    @Test
    void setAmountTest() throws Exception {
        Budget budget = new Budget("food", null);
        budget.setAmount(50.0);
        Double amount = budget.getAmount();
        if (!amount.equals(50.0)){
            throw new Exception("setAmount() method error.");
        }
    }

    @Test
    void toStringTest() throws Exception {
        Budget budget = new Budget("food", 50.0);
        if (!budget.toString().equals("Budget Type: food, Amount: $50.0")) {
            throw new Exception("toString() method error.");
        }
    }

}
