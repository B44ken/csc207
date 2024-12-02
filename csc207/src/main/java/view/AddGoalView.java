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

    private final JButton confirmButton;
    private final JButton cancelButton;

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private AddGoalController controller;

    public AddGoalView(AddGoalController controller, ViewSwitcher viewSwitcher) {
        this.controller = controller;
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

        final JPanel buttons1 = new JPanel();
        cancelButton = new JButton("Cancel");
        buttons1.add(cancelButton);
        confirmButton = new JButton("Confirm");
        buttons1.add(confirmButton);


        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(confirmButton)) {
                    LocalDate exampleDate = LocalDate.of(Integer.parseInt(yearTextField.getText()),
                            Integer.parseInt(monthTextField.getText()),
                            Integer.parseInt(dayTextField.getText()));
                    controller.addGoal(
                            targetTextField.getText(), amountTextField.getText(), exampleDate);
                }
                controller.switchToHomeView();
            }
        });

        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
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
        mainPanel.add(buttons1);

        this.add(mainPanel);


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

    public void setUserData(UserData ud) {
        userData = ud;
        this.repaint();
    }

    public String getViewName() {return viewName;}

}