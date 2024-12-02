package use_case.goals;

import javax.swing.table.DefaultTableModel;
import data_access.UserData;
import entity.Goal;

public class GoalListController {
    private UserData userData;

    public GoalListController(UserData ud) {
        this.userData = ud;
    }

    public void execute(DefaultTableModel model) {
        model.setRowCount(0);

        var goals = userData.getGoals().getList();
        for (Goal g : goals)
            model.addRow(new String[] {
                    g.getTarget(),
                    String.valueOf(g.getAmount()),
                    g.getTargetDate().toString(),
            });
    }
}

