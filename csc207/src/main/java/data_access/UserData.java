package data_access;

import entity.Goals;
import entity.TransactionHistory;


// public interface UserData {
//     TransactionHistory getHistory();
//     GoalHistory getGoals();
//     void save(String filename);
// }

// public class UserDataFile implements UserData {
public class UserData {
    private String file;

    private TransactionHistory history;
    private Goals goals;

    public UserData(String fileName) {
        this.file = fileName;
        history = FileAccess.importData(fileName);
    }

    public TransactionHistory getHistory() {
        return history;
    }

    public Goals getGoals() {
        return goals;
    }

    public void save() {
        FileAccess.exportData(history, file);
    }
}