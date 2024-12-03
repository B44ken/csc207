package entity;

import org.junit.jupiter.api.Test;

/**
 * Test class for Budget entity.
 */
public class BudgetTest {

    /**
     * Tests getCategoryName() method of Budget.
     * @throws Exception thrown if getCategoryName() method fails.
     */
    @Test
    void getCategoryNameTest() throws Exception {
        final Budget budget = new Budget("food", 50.0);
        if (!"food".equals(budget.getCategoryName())) {
            throw new Exception("getCategoryName() method error.");
        }
    }

    /**
     * Tests setCategoryName() method of Budget.
     * @throws Exception thrown if setCategoryName() method fails.
     */
    @Test
    void setCategoryNameTest() throws Exception {
        final Budget budget = new Budget(null, 50.0);
        budget.setCategoryName("food");
        if (!"food".equals(budget.getCategoryName())) {
            throw new Exception("setCategoryName() method error.");
        }
    }

    /**
     * Tests getAmount() method of Budget.
     * @throws Exception thrown if getAmount() method fails.
     */
    @Test
    void getAmountTest() throws Exception {
        final Budget budget = new Budget("food", 50.0);
        final Double amount = budget.getAmount();
        if (!amount.equals(50.0)) {
            throw new Exception("getAmount() method error.");
        }
    }

    /**
     * Tests setAmount() method of Budget.
     * @throws Exception thrown if setAmount() method fails.
     */
    @Test
    void setAmountTest() throws Exception {
        final Budget budget = new Budget("food", null);
        budget.setAmount(50.0);
        final Double amount = budget.getAmount();
        if (!amount.equals(50.0)) {
            throw new Exception("setAmount() method error.");
        }
    }

    /**
     * Tests toString() method of Budget.
     * @throws Exception thrown if toString() method fails.
     */
    @Test
    void toStringTest() throws Exception {
        final Budget budget = new Budget("food", 50.0);
        if (!budget.toString().equals("Budget Type: food, Amount: $50.0")) {
            throw new Exception("toString() method error.");
        }
    }

}
