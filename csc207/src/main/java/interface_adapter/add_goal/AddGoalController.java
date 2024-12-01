package interface_adapter.add_goal;

// listens for any changes in view
// convert raw user input data into something useful
// create input data object containing that info
// call method to start a use case, pass the input data into the use case

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Budget;
import entity.Goal;
import use_case.add_goal.AddGoalInputData;
import use_case.add_goal.AddGoalInputBoundary;
import view.ViewSwitcher;

import javax.swing.text.View;
import java.time.LocalDate;
import java.util.Date;

/**
 * Controller for Add Income use case.
 */
public class AddGoalController {
    private UserData userData;
    private ViewSwitcher viewSwitcher;

    public AddGoalController(ViewSwitcher vs, UserData ud) {
        userData = ud;
        viewSwitcher = vs;
    }

    public void addGoal(String target, String amountstr, LocalDate targetDate) {

        if (target == null || amountstr == null || targetDate == null) {
            System.out.println("invalid input");
            return;
        }
        try {
            var amount = Double.parseDouble(amountstr);
            var g = new Goal(target, amount, targetDate);
            userData.getGoals().add(g);
            userData.save();
        } catch (NumberFormatException ex) {
            System.out.println("failed to parse amount");
        }


    }

    public void switchToHomeView() {
        viewSwitcher.switchTo(ViewNames.home);
    }
}
