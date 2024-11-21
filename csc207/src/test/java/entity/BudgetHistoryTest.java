package entity;

import org.junit.jupiter.api.Test;

public class BudgetHistoryTest {

    @Test
    void addTest() throws Exception {
        BudgetHistory budgetHistory = new BudgetHistory();
        Budget budget = new Budget(null, null);
        budget.setCategoryName("food");
        budget.setAmount(50.0);
        budgetHistory.add(budget);
        if(!budgetHistory.history.contains(budget)){
            throw new Exception("add() method error.");
        }
    }

}
