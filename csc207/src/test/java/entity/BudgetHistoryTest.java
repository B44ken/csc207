package entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BudgetHistoryTest {

    @Test
    void constructorTest() throws Exception {
        BudgetHistory budgetHistory = new BudgetHistory();
        if(budgetHistory.getList() == null) {
            throw new Exception("Fail: Initializing Constructor.");
        }
    }

    @Test
    void addTest() throws Exception {
        BudgetHistory budgetHistory = new BudgetHistory();
        Budget budget = new Budget(null, null);
        budget.setCategoryName("food");
        budget.setAmount(50.0);
        budgetHistory.add(budget);
        if(!budgetHistory.getList().contains(budget)){
            throw new Exception("add() method error.");
        }
    }

    @Test
    void getAllBudgetsTest() throws Exception {
        BudgetHistory budgetHistory = new BudgetHistory();
        Budget budget1 = new Budget(null, null);
        budget1.setCategoryName("food");
        budget1.setAmount(50.0);
        budgetHistory.add(budget1);
        Budget budget2 = new Budget(null, null);
        budget2.setCategoryName("drink");
        budget2.setAmount(10.0);
        budgetHistory.add(budget1);
        budgetHistory.add(budget2);
        if(!budgetHistory.getList().contains(budget1) || !budgetHistory.getList().contains(budget2)){
            throw new Exception("Fail: Getting All Budgets.");
        }
    }

    @Test
    void getListTest() throws Exception {
        BudgetHistory budgetHistory = new BudgetHistory();
        Budget budget1 = new Budget(null, null);
        budget1.setCategoryName("food");
        budget1.setAmount(50.0);
        budgetHistory.add(budget1);
        Budget budget2 = new Budget(null, null);
        budget2.setCategoryName("drink");
        budget2.setAmount(10.0);
        budgetHistory.add(budget1);
        budgetHistory.add(budget2);
        if(budgetHistory.getList() == null){
            throw new Exception("Fail: Getting List.");
        }
    }

}
