package data_access;

import entity.BudgetHistory;
import entity.GoalList;
import entity.TransactionHistory;

// public interface UserData {
//     TransactionHistory getHistory();
//     GoalHistory getGoals();
//     void save(String filename);
// }

// public class UserDataFile implements UserData {
public class UserData {
    TransactionHistory history;
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

    public BudgetHistory getBudgets() { return budgets; }

    public void save() {
        FileAccess.exportData(history, file);

    }
}