package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import use_case.goals.GoalListController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalListView extends JPanel {
    private final String viewName = "Goals";

    private DefaultTableModel goalsTableModel;
    private JTable goalsTable;
    private JPanel goalsTablePanel;
    private JPanel panel;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private final JButton addGoalButton;
    private ViewSwitcher viewSwitcher;

    private GoalListController goalsInteractor;

    private UserData userData;

    public GoalListView(BottomButtons bottomButtons, GoalListController goalsInteractor) {
        this.goalsInteractor = goalsInteractor;

        final JLabel titleLabel = new JLabel("Goals");

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        this.panel = new JPanel();

        final JPanel addGoal = new JPanel();
        addGoalButton = new JButton("Add New Goal");
        addGoal.add(addGoalButton);

        final JPanel buttons = new JPanel();
        homeButton = new JButton("Home");
        buttons.add(homeButton);
        incomeButton = new JButton("Income");
        buttons.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons.add(expenseButton);
        goalsButton = new JButton("Goal");
        buttons.add(goalsButton);

        addGoalButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.addGoal);
                    }
                }
        );
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

        this.add(titleLabel);
        this.add(panel);

        setupGoalsTable();

        this.add(goalsTablePanel);

        this.add(addGoalButton);
        this.add(buttons, BorderLayout.AFTER_LAST_LINE);

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
        if(goalsTable == null || userData == null)
            return;
        DefaultTableModel model = (DefaultTableModel) goalsTable.getModel();
        model.setRowCount(0);
        for(var g : userData.getGoals().getList())
            model.addRow(new Object[]{g.getTarget(), g.getAmount(), g.getTargetDate()});
//        GoalList goalsData = userData.getGoals();
       JPanel goalsPane = new JPanel();
//
//        String[] goalsColumnNames = {"Target", "Amount", "Target Date"};
//        goalsTableModel = new DefaultTableModel(goalsColumnNames, 0);
//
//        for (Goal goals : goalsData.getHistory()) {
//            goalsTableModel.addRow(new String[]{goals.getTarget(), String.valueOf(goals.getAmount()),
//                    goals.getTargetDate().toString()});
//        }

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