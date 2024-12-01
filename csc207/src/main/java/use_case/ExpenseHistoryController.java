package use_case;

import javax.swing.table.DefaultTableModel;
import data_access.UserData;
import entity.Budget;
import entity.Transaction;

public class ExpenseHistoryController {
    private UserData userData;

    public ExpenseHistoryController(UserData ud) {
        this.userData = ud;
    }

    public void execute(DefaultTableModel expenseTableModel) {
        expenseTableModel.setRowCount(0);

        var history = userData.getHistory().getAllExpenses().getHistory();
        for (Transaction t : history)
            expenseTableModel.addRow(new String[] {
                    t.getName(),
                    String.valueOf(t.getAmount()),
                    t.getDate().toString(),
                    t.getCategory()
            });

    }
}
