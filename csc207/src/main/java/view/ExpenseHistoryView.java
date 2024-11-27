package view;


import use_case.history.ExpenseHistoryController;
import data_access.UserData;
import view.ViewSwitcher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseHistoryView extends JPanel {
    private JPanel panel;
    private ViewSwitcher viewSwitcher;

    private JTable expenseTable;
    private DefaultTableModel expenseTableModel;
    private JPanel expenseTablePanel;

    private ExpenseHistoryController expenseInteractor;
  
    private JTable budgetTable;
    private DefaultTableModel budgetTableModel;
    private JPanel budgetTablePanel;

    private IncomeHistoryController interactor;

    public ExpenseHistoryView(BottomButtons bottomButtons, ExpenseHistoryController interactor) {
        this.interactor = interactor;

        final JLabel title = new JLabel("Expense History");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        this.panel = new JPanel();

        JPanel addExpenseButton = new JPanel();
        JButton addExpense = new JButton("Add Expense");
        addExpenseButton.add(addExpense);
      
        JPanel addBudgetButton = new JPanel();
        JButton addBudget = new JButton("Add Budget");
        addBudgetButton.add(addBudget);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(panel);
        
        setupExpenseTable();
        setupBudgetTable();
        add(expenseTablePanel);
        add(budgetTablePanel);
        

        this.add(addExpenseButton);
        add(bottomButtons, BorderLayout.AFTER_LAST_LINE);

    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void repaint() {
        if (interactor != null)
            interactor.execute(tableModel);
    }

    public void attachSwitchToOnButton(JButton button, String viewName) {
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(viewName);
                    }
                });
    }

    public void setupExpenseTable() {
        String[] columnNames = { "Name", "Amount", "Date", "Category" };
        expenseTableModel = new DefaultTableModel(columnNames, 0);

        expenseTable = new JTable(expenseTableModel);
        JScrollPane tableScrollPane = new JScrollPane(expenseTable);
        expenseTable.setFillsViewportHeight(true);
        expenseTable.setVisible(true);
        expenseTablePanel = new JPanel();
        expenseTablePanel.add(tableScrollPane);
        expenseTablePanel.setSize(300, 400);
        expenseTablePanel.setVisible(true);

    public void setupBudgetTable() {
      String[] columnNames = { "Category", "Amount" };
        budgetTableModel = new DefaultTableModel(columnNames, 0);

        bxpenseTable = new JTable(budgetTableModel);
        JScrollPane tableScrollPane = new JScrollPane(budgetTable);
        budgetTable.setFillsViewportHeight(true);
        budgetTable.setVisible(true);
        budgetTablePanel = new JPanel();
        budgetTablePanel.add(tableScrollPane);
        budgetTablePanel.setSize(300, 400);
        budgetTablePanel.setVisible(true);
    }

}
