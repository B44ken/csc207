package view;

import com.labrats.app.ViewNames;
import data_access.UserData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.text.View;

import entity.Expense;
import entity.Goal;
import view.BottomButtons;
import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_goal.AddGoalViewModel;

public class AddGoalView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Add Goal View";

    private AddGoalController addGoalController;

    private ViewSwitcher viewSwitcher;

    public AddGoalView(ViewSwitcher vs) {
        super();
        this.viewSwitcher = vs;
        final JLabel title = new JLabel("Add Goal");
        title.setAlignmentX((JComponent.CENTER_ALIGNMENT));

        JPanel targetPanel = new JPanel();
        JTextField targetTextField = new JTextField(15);
        targetPanel.add(new JLabel("Target:"));
        targetPanel.add(targetTextField);

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
                addGoalController.execute(targetTextField.getText(), amountTextField.getText(),
                        yearTextField.getText(), monthTextField.getText(), dayTextField.getText());
                viewSwitcher.switchTo(ViewNames.goalList);
            }
        });

        cancelButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewSwitcher.switchTo(ViewNames.home);
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
        mainPanel.add(cancelPanel);

        this.add(title);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void setAddGoalController(AddGoalController controller) {
        this.addGoalController = controller;
    }
}