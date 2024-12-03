package entity;

import org.junit.jupiter.api.Test;

/**
 * Test class for BudgetHistory entity.
 */
public class BudgetHistoryTest {

    /**
     * Test for constructor of BudgetHistory.
     * @throws Exception thrown if BudgetHistory is not initialized correctly.
     */
    @Test
    void constructorTest() throws Exception {
        final BudgetHistory budgetHistory = new BudgetHistory();
        if (budgetHistory.getList() == null) {
            throw new Exception("Fail: Initializing Constructor.");
        }
    }

    /**
     * Test for add() method of BudgetHistory.
     * @throws Exception thrown if add() method fails.
     */
    @Test
    void addTest() throws Exception {
        final BudgetHistory budgetHistory = new BudgetHistory();
        final Budget budget = new Budget(null, null);
        budget.setCategoryName("food");
        budget.setAmount(50.0);
        budgetHistory.add(budget);
        if (!budgetHistory.getList().contains(budget)) {
            throw new Exception("add() method error.");
        }
    }

    /**
     * Test for getAllBudgets() method of BudgetHistory.
     * @throws Exception thrown if getAllBudgets() method fails.
     */
    @Test
    void getAllBudgetsTest() throws Exception {
        final BudgetHistory budgetHistory = new BudgetHistory();
        final Budget budget1 = new Budget(null, null);
        budget1.setCategoryName("food");
        budget1.setAmount(50.0);
        budgetHistory.add(budget1);
        final Budget budget2 = new Budget(null, null);
        budget2.setCategoryName("drink");
        budget2.setAmount(10.0);
        budgetHistory.add(budget1);
        budgetHistory.add(budget2);
        if (!budgetHistory.getList().contains(budget1) || !budgetHistory.getList().contains(budget2)) {
            throw new Exception("Fail: Getting All Budgets.");
        }
    }

    /**
     * Test for getList() method of BudgetHistory.
     * @throws Exception thrown if getList() method fails.
     */
    @Test
    void getListTest() throws Exception {
        final BudgetHistory budgetHistory = new BudgetHistory();
        final Budget budget1 = new Budget(null, null);
        budget1.setCategoryName("food");
        budget1.setAmount(50.0);
        budgetHistory.add(budget1);
        final Budget budget2 = new Budget(null, null);
        budget2.setCategoryName("drink");
        budget2.setAmount(10.0);
        budgetHistory.add(budget1);
        budgetHistory.add(budget2);
        if (budgetHistory.getList() == null) {
            throw new Exception("Fail: Getting List.");
        }
    }

}
