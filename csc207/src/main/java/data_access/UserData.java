package data_access;

import entity.BudgetHistory;
import entity.GoalList;
import entity.TransactionHistory;

public class UserData {
    final TransactionHistory history;
    GoalList goals;
    BudgetHistory budgets;

    public UserData() {
        history = new TransactionHistory();
        goals = new GoalList();
        budgets = new BudgetHistory();
    }

    public TransactionHistory getHistory() {
        return history;
    }

    public GoalList getGoals() {
        return goals;
    }

    public BudgetHistory getBudgets() {
        return budgets;
    }

    public void save() {
    }
}