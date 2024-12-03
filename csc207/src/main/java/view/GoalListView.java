package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.labrats.app.ViewNames;
import interface_adapter.GoalListController;

/**
 * Class for GoalListView.
 */
public class GoalListView extends JPanel implements ActionListener {
    private final String viewName = "Goals";

    private DefaultTableModel goalsTableModel;
    private JTable goalListTable;
    private JPanel panel;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;
    private GoalListController controller;

    public GoalListView(GoalListController controller) {
        this.controller = controller;

        final JLabel titleLabel = new JLabel("Goals");

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        this.panel = new JPanel();
        var addGoalButton = new JButton(ViewNames.addGoal);

        addGoalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewSwitcher.switchTo(ViewNames.addGoal);
            }
        });

        final JPanel buttons = new JPanel();
        homeButton = new JButton("Home");
        buttons.add(homeButton);
        incomeButton = new JButton("Income");
        buttons.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons.add(expenseButton);
        goalsButton = new JButton("Goal");
        buttons.add(goalsButton);

        homeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
                }
        );

        expenseButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.expenseHistory);
                    }
                }
        );

        goalsButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.goalList);
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setupGoalsTable();

        this.add(titleLabel);
        this.add(panel);
        this.add(addGoalButton);
        this.add(buttons, BorderLayout.AFTER_LAST_LINE);

        repaint();
    }

    @Override
    public void repaint() {
        if (controller != null) {
            controller.execute(goalsTableModel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * The setter for ViewSwitcher of GoalList object.
     * @param viewSwitcher the ViewSwitcher.
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    /**
     * Sets up table when .addUserData() is run in App.
     */
    public void setupGoalsTable() {
        String[] columnNames = {"Target", "Amount", "TargetDate"};
        goalsTableModel = new DefaultTableModel(columnNames, 0);

        goalListTable = new JTable(goalsTableModel);
        JScrollPane tableScrollPane = new JScrollPane(goalListTable);
        TitledBorder tableTitle = BorderFactory.createTitledBorder("Goals");
        tableScrollPane.setBorder(tableTitle);
        goalListTable.setFillsViewportHeight(true);
        goalListTable.setVisible(true);
        panel = new JPanel();
        panel.add(tableScrollPane);
        panel.setSize(300, 400);
        panel.setVisible(true);
    }
}