package use_case.goals;

import javax.swing.table.DefaultTableModel;
import data_access.UserData;
import entity.Goal;

public class GoalsController {
    private UserData userData;

    public GoalsController(UserData ud) {
        this.userData = ud;
    }

    public void execute(DefaultTableModel model) {
        model.setRowCount(0);

        var goals = userData.getGoals().getHistory();
        for (Goal g : goals)
            model.addRow(new String[] {
                    g.getTarget(),
                    String.valueOf(g.getAmount()),
                    String.valueOf(g.getTargetDate()),
            });
    }
}

