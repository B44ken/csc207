package view;

import com.labrats.app.ViewNames;
import data_access.UserData;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class ExpenseHistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Expense";

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private final JTable expenseTable;
    private final DefaultTableModel expenseTableModel;
    private final JButton addExpenseButton;

    private final JTable budgetTable;
    private final DefaultTableModel budgetTableModel;
    private final JButton addBudgetButton;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalButton;

    public ExpenseHistoryView() {
        super();

        final JLabel titleLabel = new JLabel("Expenses");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        final String[] expenseColumnNames = { "Name", "Category", "Amount", "Date" };
        expenseTableModel = new DefaultTableModel(expenseColumnNames, 0);
        expenseTable = new JTable(expenseTableModel);

        expenseTable.setFillsViewportHeight(true);
        JScrollPane expenseTableScrollPane = new JScrollPane(expenseTable);
        expenseTableScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Expense History", // Title text
                TitledBorder.LEFT, // Title position
                TitledBorder.TOP // Title location
        ));
        // add(expenseTableScrollPane, BorderLayout.CENTER);

        final String[] budgetColumnNames = {"Category", "Amount"};
        budgetTableModel = new DefaultTableModel(budgetColumnNames, 0);
        budgetTable = new JTable(budgetTableModel);

        budgetTable.setFillsViewportHeight(true);
        JScrollPane budgetTableScrollPane = new JScrollPane(budgetTable);
        budgetTableScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Current Budgets", // Title text
                TitledBorder.LEFT, // Title position
                TitledBorder.TOP // Title location
        ));
        add(expenseTableScrollPane, BorderLayout.CENTER);
        add(budgetTableScrollPane, BorderLayout.CENTER);

        final JPanel budgets = new JPanel();
        addBudgetButton = new JButton("Add Budget");
        budgets.add(addBudgetButton);
        add(budgets);

        final JPanel buttons1 = new JPanel();
        addExpenseButton = new JButton("Add Expense");
        buttons1.add(addExpenseButton);
        add(buttons1);

        addBudgetButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Add Budget button clicked");
                        viewSwitcher.switchTo(ViewNames.addBudget);
                    }
        });

        addExpenseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Add Expense button clicked");
                        viewSwitcher.switchTo(ViewNames.addExpense);
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

        addBudgetButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.addBudget);
                    }
                });
        addExpenseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.addExpense);
                    }
                });
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(titleLabel);
        this.add(budgets);
        this.add(buttons1);
        this.add(buttons2);
    }

    public String getViewName() {
        return viewName;
    }

    public JTable getExpenseTable() {
        return expenseTable;
    }

    public JTable getBudgetTable() {return budgetTable;}

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

    public void repaint() {
        // TODO
        // repaint is called when a Swing component is switched to
        // use this to update numbers and stuff
        // other components also need repaint() methods
    }

}
