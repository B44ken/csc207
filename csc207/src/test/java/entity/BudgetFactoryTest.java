package entity;

import org.junit.jupiter.api.Test;

public class BudgetFactoryTest {

    @Test
    void createTest() throws Exception {
        BudgetFactory budgetFactory = new BudgetFactory();
        Budget createdBudget = budgetFactory.create("food", 10.0);
        Budget compareToBudget = new Budget(null, null);
        compareToBudget.setCategoryName("food");
        compareToBudget.setAmount(50.0);
        if (!createdBudget.getCategoryName().equals(compareToBudget.getCategoryName()) &&
                createdBudget.getAmount() != compareToBudget.getAmount()){
            throw new Exception("Fail: Creating Budget");
        }
    }

}