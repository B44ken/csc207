package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import interface_adapter.add_goal.GoalController;
import interface_adapter.add_goal.GoalViewModel;

public class GoalView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Goal View";

    private final GoalController goalController;
    private final GoalViewModel goalViewModel;

    private final JFrame outerFrame;

    public GoalView(GoalViewModel goalViewModel, GoalController controller) {
        super();

        this.goalController = controller;
        this.goalViewModel = goalViewModel;
        goalViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Goals Overview");
        title.setAlignmentX((JComponent.CENTER_ALIGNMENT));

        JPanel overviewPanel = new JPanel();
        JLabel totalAmountLabel = new JLabel("Total Amount: " + goalViewModel.getTotalGoalAmount());
        overviewPanel.add(totalAmountLabel);

        JPanel goalsListPanel = new JPanel();
        goalsListPanel.setLayout(new BoxLayout(goalsListPanel, BoxLayout.Y_AXIS));
        List<String> goals = goalViewModel.getGoals();
        for (String goal : goals) {
            goalsListPanel.add(new JLabel(goal));
        }

        JPanel createGoalPanel = new JPanel();
        JButton createGoalButton = new JButton("Create New Goal");
        createGoalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goalController.switchToCreateGoalView();
            }
        });
        createGoalPanel.add(createGoalButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(title);
        mainPanel.add(overviewPanel);
        mainPanel.add(goalsListPanel);
        mainPanel.add(createGoalPanel);

        outerFrame = new JFrame("Goal View");
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






}
