package interface_adapter.income_history;

import data_access.UserData;
import entity.Transaction;

import javax.swing.table.DefaultTableModel;

public class IncomeHistoryController {
    private UserData userData;

    public IncomeHistoryController(UserData userData) {
        this.userData = userData;
    }

    public void execute(DefaultTableModel model) {
        model.setRowCount(0);

        var history = userData.getHistory().getAllIncomes().getHistory();
        for (Transaction t : history)
            model.addRow(new String[] {
                    t.getName(),
                    String.valueOf(t.getAmount()),
                    t.getDate().toString(),
                    t.getCategory()
            });
    }

}
