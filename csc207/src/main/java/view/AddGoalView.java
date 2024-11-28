package view;

import com.labrats.app.ViewNames;
import data_access.UserData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.*;

import entity.Goal;
import view.BottomButtons;
import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_goal.AddGoalViewModel;

public class AddGoalView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Add Goal View";

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalButton;


    public AddGoalView(BottomButtons bottomButtons, AddGoalController addGoalController) {
        super();

        final JLabel title = new JLabel("Add Goal");
        title.setAlignmentX((JComponent.CENTER_ALIGNMENT));

        JPanel targetPanel = new JPanel();
        JTextField nameTextField = new JTextField(15);
        targetPanel.add(new JLabel("Target:"));
        targetPanel.add(nameTextField);

        JPanel amountPanel = new JPanel();
        JTextField amountTextField = new JTextField(15);
        amountPanel.add(new JLabel("Amount:"));
        amountPanel.add(amountTextField);

        JPanel targetDayPanel = new JPanel();
        JTextField dayTextField = new JTextField(15);
        targetDayPanel.add(new JLabel("Target Day:"));
        targetDayPanel.add(dayTextField);

        JPanel targetMonthPanel = new JPanel();
        JTextField monthTextField = new JTextField(15);
        targetMonthPanel.add(new JLabel("Target Month:"));
        targetMonthPanel.add(monthTextField);

        JPanel targetYearPanel = new JPanel();
        JTextField yearTextField = new JTextField(15);
        targetYearPanel.add(new JLabel("Target Year:"));
        targetYearPanel.add(yearTextField);

        JPanel confirmPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);

        JPanel cancelPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        cancelPanel.add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String target = nameTextField.getText();
                Double amount = Double.valueOf(amountTextField.getText());
                Integer targetDay = Integer.valueOf(dayTextField.getText());
                Integer targetMonth = Integer.valueOf(monthTextField.getText());
                Integer targetYear = Integer.valueOf(yearTextField.getText());
                LocalDate targetDate = LocalDate.of(targetYear, targetMonth, targetDay);
                Goal newGoal = new Goal(target, amount, targetDate);
                userData.getGoals().add(newGoal);
                userData.save();
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        final JPanel buttons2 = new JPanel();
        homeButton = new JButton("Home");
        buttons2.add(homeButton);
        incomeButton = new JButton("Income");
        buttons2.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons2.add(expenseButton);
        goalButton = new JButton("Goal");
        buttons2.add(goalButton);

        homeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
                });

        incomeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.incomeHistory);
                    }
                });

        expenseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.expenseHistory);
                    }
                });

        goalButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.goalList);
                    }
                });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(title);
        mainPanel.add(targetPanel);
        mainPanel.add(amountPanel);
        mainPanel.add(targetDayPanel);
        mainPanel.add(targetMonthPanel);
        mainPanel.add(targetYearPanel);
        mainPanel.add(confirmPanel);

        this.add(mainPanel);
        this.add(BottomButtons);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void setViewSwitcher(ViewSwitcher vs) {
        viewSwitcher = vs;
    }

}