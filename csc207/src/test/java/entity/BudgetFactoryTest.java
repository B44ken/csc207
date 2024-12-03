package entity;

import org.junit.jupiter.api.Test;

/**
 * Test class for BudgetFactory entity.
 */
public class BudgetFactoryTest {

    /**
     * Test for create() method in BudgetFactory.
     * @throws Exception thrown when create() fails.
     */
    @Test
    void createTest() throws Exception {
        final BudgetFactory budgetFactory = new BudgetFactory();
        final Budget createdBudget = budgetFactory.create("food", 10.0);
        final Budget compareToBudget = new Budget(null, null);
        compareToBudget.setCategoryName("food");
        compareToBudget.setAmount(50.0);
        if (!createdBudget.getCategoryName().equals(compareToBudget.getCategoryName())
                && createdBudget.getAmount() != compareToBudget.getAmount()) {
            throw new Exception("Fail: Creating Budget");
        }
    }

}
