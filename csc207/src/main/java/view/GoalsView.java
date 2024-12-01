package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Goal;
import entity.GoalList;
import use_case.goals.GoalsController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class GoalsView extends JPanel {
    private final String viewName = "Goals";

    private DefaultTableModel goalsTableModel;
    private JTable goalsTable;
    private JPanel goalsTablePanel;
    private JPanel panel;

    private GoalsController goalsInteractor;

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    public GoalsView(BottomButtons bottomButtons, GoalsController goalsInteractor) {
        this.goalsInteractor = goalsInteractor;

        final JLabel titleLabel = new JLabel("Goals");

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        this.panel = new JPanel();

        JPanel addGoalButton = new JPanel();
        JButton addGoal = new JButton("Add New Goal");
        addGoalButton.add(addGoal);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(titleLabel);
        this.add(panel);

        setupGoalsTable();

        attachSwitchToOnButton(addGoal, ViewNames.addGoal);

        this.add(goalsTablePanel);

        this.add(addGoalButton);
        this.add(bottomButtons, BorderLayout.AFTER_LAST_LINE);

        repaint();
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void repaint() {
        if (goalsInteractor != null)
            goalsInteractor.execute(goalsTableModel);
    }

    public void attachSwitchToOnButton(JButton button, String viewName) {
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(viewName);
                    }
                }
        );
    }

    public void setupGoalsTable() {
        String[] columnNames = {"Target", "Amount", "TargetDate"};
        goalsTableModel = new DefaultTableModel(columnNames, 0);

        goalsTable = new JTable(goalsTableModel);
        JScrollPane tableScrollPane = new JScrollPane(goalsTable);
        TitledBorder tableTitle = BorderFactory.createTitledBorder("Goals");
        tableScrollPane.setBorder(tableTitle);
        goalsTable.setFillsViewportHeight(true);
        goalsTable.setVisible(true);
        goalsTablePanel = new JPanel();
        goalsTablePanel.add(tableScrollPane);
        goalsTablePanel.setSize(300, 400);
        goalsTablePanel.setVisible(true);
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
        populateGoalsTable();
    }

    private void populateGoalsTable() {
        GoalList goalsData = userData.getList();
        JPanel goalsPane = new JPanel();

        String[] goalsColumnNames = {"Target", "Amount", "Target Date"};
        goalsTableModel = new DefaultTableModel(goalsColumnNames, 0);

        for (Goal goals : goalsData.getHistory()) {
            goalsTableModel.addRow(new String[]{goals.getTarget(), String.valueOf(goals.getAmount()),
                    goals.getTargetDate().toString()});
        }

        goalsTable = new JTable(goalsTableModel);
        JScrollPane tableScrollPane = new JScrollPane(goalsTable);
        goalsTable.setFillsViewportHeight(true);
        goalsTable.setVisible(true);
        JPanel tablePanel = new JPanel();
        tablePanel.add(tableScrollPane);
        tablePanel.setSize(300, 400);
        tablePanel.setVisible(true);
        goalsPane.add(tablePanel);

        this.panel.setComponentZOrder(goalsPane, 0);

    }
}