package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Goal;
import entity.GoalList;
import interface_adapter.goals.GoalsController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class GoalsView extends JPanel implements  ActionListener, PropertyChangeListener {
    private final String viewName = "Goals";

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private final JTable goalsTable;
    private final DefaultTableModel tableModel;


    public GoalsView(BottomButtons bottomButtons, GoalsController goalsController) {
        super();

        final JLabel titleLabel = new JLabel("Goals");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        final String[] columnNames = {"Target", "Amount", "Target Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        goalsTable = new JTable(tableModel);

        goalsTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(goalsTable);
        add(tableScrollPane, BorderLayout.CENTER);

        final JPanel addGoalButton = new JPanel();
        JButton addNewGoal = new JButton("Add New Goal");
        addGoalButton.add(addNewGoal);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(titleLabel);
        this.add(addGoalButton);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void setViewSwitcher(ViewSwitcher vs) {
        viewSwitcher = viewSwitcher;
    }

    public void setUserData(UserData ud) {
        userData = ud;
        this.repaint();
    }

    private void populateTable() {
        if(goalsTable != null) {
            DefaultTableModel model = (DefaultTableModel) goalsTable.getModel();
            model.addRow(new Object[]{"1", "2", "3"});
        }
        // for every entry...

    }

    public void repaint() {
        populateTable();
    }
}