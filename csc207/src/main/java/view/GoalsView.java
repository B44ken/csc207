package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class GoalsView extends JPanel {
    private String viewName = "Goals";
    private final JTable goalsTable;
    private final DefaultTableModel tableModel;
    private final JButton addGoalButton;

    public GoalsView() {
        super();
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Goals");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Target", "Amount", "Target Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        goalsTable = new JTable(tableModel);

        goalsTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(goalsTable);
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addGoalButton = new JButton("Add New Goal");
        buttonPanel.add(addGoalButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddGoal();
            }
        });
    }
    public void addGoalToTable(String target, double amount, LocalDate targetDate) {
        tableModel.addRow(new Object[]{target, amount, targetDate});
    }

    // unsure how to integrate the addgoal button
    private void onAddGoal() {
        JOptionPane.showMessageDialog(this, "Add Goal functionality not yet implemented");
    }

    public String getViewName() {
        return viewName;
    }

    public JTable getGoalsTable() {
        return goalsTable;
    }
}