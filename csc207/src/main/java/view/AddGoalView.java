package view;

import com.labrats.app.ViewNames;
import data_access.UserData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.*;

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

    private final AddGoalController addGoalController;
    private final AddGoalViewModel addGoalViewModel;

    private final JFrame outerFrame;

    public AddGoalView(AddGoalViewModel goalViewModel, AddGoalController controller) {
        super();

        this.addGoalController = controller;
        this.addGoalViewModel = goalViewModel;
        addGoalViewModel.addPropertyChangeListener(this);

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
                // input into text file here
                // after everything funnelled into txt file go back to home
                // addIncomeController.switchToHomeView();
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
                        viewSwitcher.switchTo(ViewNames.goals);
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
        mainPanel.add(buttons2);

        outerFrame = new JFrame("Add Goal");
        outerFrame.setContentPane(mainPanel);
        outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outerFrame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void setVisible(boolean visible) {
        outerFrame.setVisible(visible);
    }

    public void setViewSwitcher(ViewSwitcher vs) {
        viewSwitcher = vs;
    }

    public void setUserData(UserData ud) {
        userData = ud;
        this.repaint();
    }

    public void repaint() {
        // TODO
        // repaint is called when a Swing component is switched to
        // use this to update numbers and stuff
        // other components also need repaint() methods
    }




}