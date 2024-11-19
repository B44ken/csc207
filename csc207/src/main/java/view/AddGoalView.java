package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;

import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_goal.AddGoalViewModel;

public class AddGoalView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Goal View";

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
                LocalDate date = LocalDate.of(targetYear, targetMonth, targetDay);
                // input into text file here
                // after everything funnelled into txt file go back to home
                // addIncomeController.switchToHomeView();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(targetPanel);
        mainPanel.add(amountPanel);
        mainPanel.add(targetDayPanel);
        mainPanel.add(targetMonthPanel);
        mainPanel.add(targetYearPanel);
        mainPanel.add(confirmPanel);

        outerFrame = new JFrame("Add Goal");
        outerFrame.setContentPane(mainPanel);
        outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outerFrame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Action Performed not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JOptionPane.showMessageDialog(this, "Property Change not implemented yet.");
    }

    public void setVisible(boolean visible) {
        outerFrame.setVisible(visible);
    }

    public String getViewName() {
        return viewName;
    }
}