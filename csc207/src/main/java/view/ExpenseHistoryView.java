package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.labrats.app.ViewNames;
import data_access.UserData;
import interface_adapter.ExpenseHistoryController;
import use_case.history.BudgetHistoryController;

/**
 * Class for ExpenseHistoryView, Includes Title, expenseHistory, execute, CHARTAPI, home buttons.
 */
public class ExpenseHistoryView extends JPanel {
    
    private JPanel panel;
    private ViewSwitcher viewSwitcher;

    private JTable expenseTable;
    private DefaultTableModel expenseTableModel;
    private JPanel expenseTablePanel;

    private ExpenseHistoryController expenseInteractor;
    private BudgetHistoryController budgetInteractor;

    private JPanel budgetTablePanel;
    private JTable budgetTable;
    private DefaultTableModel budgetTableModel;

    private JTable budgetHistoryTable;

    private UserData userData;

    /**
     * Constructor for ExpenseHistoryView.
     * @param bottomButtons the Home, Income, and Expense buttons.
     * @param expenseInteractor the Interactor for ExpenseHistory.
     * @param budgetInteractor the Interactor for BudgetHistory.
     */
    public ExpenseHistoryView(BottomButtons bottomButtons, ExpenseHistoryController expenseInteractor,
                              BudgetHistoryController budgetInteractor) {
        this.expenseInteractor = expenseInteractor;
        this.budgetInteractor = budgetInteractor;

        final JLabel title = new JLabel("Expense History");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        this.panel = new JPanel();

        final JPanel addExpenseButton = new JPanel();
        final JButton addExpense = new JButton("Add Expense");
        addExpenseButton.add(addExpense);

        final JPanel addBudgetButton = new JPanel();
        final JButton addBudget = new JButton("Add Budget");
        addBudgetButton.add(addBudget);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(panel);

        setupExpenseTable();
        setupBudgetTable();

        attachSwitchToOnButton(addBudget, ViewNames.addBudget);
        attachSwitchToOnButton(addExpense, ViewNames.addExpense);

        this.add(expenseTablePanel);
        this.add(budgetTablePanel);

        this.add(addExpenseButton);
        this.add(addBudgetButton);
        this.add(bottomButtons, BorderLayout.AFTER_LAST_LINE);
        repaint();
    }

    /**
     * The setter for ViewSwitcher of ExpenseHistory object.
     * @param viewSwitcher the ViewSwitcher.
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    /**
     * Commands the interactors of ExpenseHistory to execute based on the tableModels.
     */
    public void repaint() {
        if (expenseInteractor != null) {
            expenseInteractor.execute(expenseTableModel);
        }
        if (budgetInteractor != null) {
            budgetInteractor.execute(budgetTableModel);
        }

    }

    /**
     * Adds functionality of switching views when indicated button is pressed to viewName.
     * @param button the button the functionality is to be added to.
     * @param viewName the viewName of View to switch to.
     */
    public void attachSwitchToOnButton(JButton button, String viewName) {
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(viewName);
                    }
                });
    }

    /**
     * Populates table when.addUserData() is run in App.
     */
    public void setupExpenseTable() {
        final String[] columnNames = {"Name", "Amount", "Date", "Category"};
        expenseTableModel = new DefaultTableModel(columnNames, 0);

        expenseTable = new JTable(expenseTableModel);
        final JScrollPane tableScrollPane = new JScrollPane(expenseTable);
        final TitledBorder tableTitle = BorderFactory.createTitledBorder("Expense History");
        tableScrollPane.setBorder(tableTitle);
        expenseTable.setFillsViewportHeight(true);
        expenseTable.setVisible(true);
        expenseTablePanel = new JPanel();
        expenseTablePanel.add(tableScrollPane);
        expenseTablePanel.setSize(300, 400);
        expenseTablePanel.setVisible(true);
    }

    /**
     * Populates table when .addUserData() is run in App.
     */
    public void setupBudgetTable() {
        final String[] columnNames = {"Category", "Amount"};
        budgetTableModel = new DefaultTableModel(columnNames, 0);

        budgetTable = new JTable(budgetTableModel);
        final JScrollPane tableScrollPane = new JScrollPane(budgetTable);
        final TitledBorder tableTitle = BorderFactory.createTitledBorder("Budget List");
        tableScrollPane.setBorder(tableTitle);
        budgetTable.setFillsViewportHeight(true);
        budgetTable.setVisible(true);
        budgetTablePanel = new JPanel();
        budgetTablePanel.add(tableScrollPane);
        budgetTablePanel.setSize(300, 400);
        budgetTablePanel.setVisible(true);
    }
}
