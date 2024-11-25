package data_access;

import entity.GoalList;
import entity.TransactionHistory;

// public interface UserData {
//     TransactionHistory getHistory();
//     GoalHistory getGoals();
//     void save(String filename);
// }

// public class UserDataFile implements UserData {
public class UserData {
    private String file;

    TransactionHistory history;
    GoalList goals;

    public UserData() {
        history = new TransactionHistory();
        goals = new GoalList();        
    }

    public TransactionHistory getHistory() {
        return history;
    }

    public GoalList getGoals() {
        return goals;
    }

    public void save() {
        FileAccess.exportData(history, file);
    }
}