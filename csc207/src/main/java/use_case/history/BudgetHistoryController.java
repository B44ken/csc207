package use_case.history;

import javax.swing.table.DefaultTableModel;

import data_access.UserData;
import entity.Budget;

/**
 * The Controller for BudgetHistory.
 */
public class BudgetHistoryController {
    private UserData userData;

    /**
     * Creates BudgetHistoryController object with ud.
     *
     * @param userData UserData object for controller.
     */
    public BudgetHistoryController(UserData userData) {
        this.userData = userData;
    }

    /**
     * Method that takes all Budgets stored in UserData and adds them as rows in model.
     *
     * @param model DefaultTableModel that Budgets get added to.
     */
    public void execute(DefaultTableModel model) {
        model.setRowCount(0);

        final var history = userData.getBudgets().getList();
        for (Budget t : history) {
            model.addRow(new String[]{
                    t.getCategoryName(),
                    String.valueOf(t.getAmount()),
            });
        }
    }
}
