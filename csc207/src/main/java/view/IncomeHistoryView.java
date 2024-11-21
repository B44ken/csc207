package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import interface_adapter.income_history.IncomeHistoryViewController;
import interface_adapter.income_history.IncomeHistoryState;
import interface_adapter.income_history.IncomeHistoryViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import java.beans.PropertyChangeEvent;

public class IncomeHistoryView extends JPanel implements ActionListener {
    private final String viewName = "income history";

    private final DefaultTableModel tableModel;
    private final JTable incomeHistoryTable;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;


    public IncomeHistoryView() {
        final JLabel title = new JLabel("Income History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        tableModel = new DefaultTableModel(columnNames, 0);
        incomeHistoryTable = new JTable(tableModel);

        incomeHistoryTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(incomeHistoryTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // add call to data here

        //Add chart API here!

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

        incomeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.incomeHistory);
                    }
                }
        );

        goalsButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.goals);
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(incomeHistoryTable);
        this.add(buttons);
    }


    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}


    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }
}
