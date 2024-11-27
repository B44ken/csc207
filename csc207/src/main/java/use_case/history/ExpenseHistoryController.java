package use_case.history;

import javax.swing.table.DefaultTableModel;
import data_access.UserData;
import entity.Transaction;

public class ExpenseHistoryController {
    private UserData userData;

    public ExpenseHistoryController(UserData ud) {
        this.userData = ud;
    }

    public void execute(DefaultTableModel model) {
        model.setRowCount(0);

        var history = userData.getHistory().getAllExpenses().getHistory();
        for (Transaction t : history)
            model.addRow(new String[] {
                    t.getName(),
                    String.valueOf(t.getAmount()),
                    t.getDate().toString(),
                    t.getCategory()
            });
    }
}
