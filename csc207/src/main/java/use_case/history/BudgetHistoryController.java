package use_case.history;

import data_access.UserData;
import entity.Budget;
import entity.Transaction;

import javax.swing.table.DefaultTableModel;

public class BudgetHistoryController {
    private UserData userData;

    public BudgetHistoryController(UserData ud) {
        this.userData = ud;
    }

    public void execute(DefaultTableModel model) {
        model.setRowCount(0);

        var history = userData.getBudgets().getList();
        for (Budget t : history)
            model.addRow(new String[] {
                    t.getCategoryName(),
                    String.valueOf(t.getAmount()),
            });
    }
}