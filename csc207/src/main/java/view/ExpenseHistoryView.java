package view;


import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Budget;
import entity.BudgetHistory;
import entity.Transaction;
import entity.TransactionHistory;
import interface_adapter.add_budget.AddBudgetController;
import use_case.ExpenseHistoryController;
import use_case.history.BudgetHistoryController;
import view.ViewSwitcher;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for ExpenseHistoryView, Includes Title, expenseHistory, addExpense, CHARTAPI, home buttons.
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

    // private IncomeHistoryControlerl interactor;

    public ExpenseHistoryView(BottomButtons bottomButtons, ExpenseHistoryController expenseInteractor, BudgetHistoryController budgetInteractor) {
        this.expenseInteractor = expenseInteractor;
        this.budgetInteractor = budgetInteractor;

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

        attachSwitchToOnButton(addBudget, ViewNames.addBudget);
        attachSwitchToOnButton(addExpense, ViewNames.addExpense);

        this.add(expenseTablePanel);
        this.add(budgetTablePanel);

        this.add(addExpenseButton);
        this.add(addBudgetButton);
        this.add(bottomButtons, BorderLayout.AFTER_LAST_LINE);
        repaint();
    }


    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void repaint() {
        if (expenseInteractor != null)
            expenseInteractor.execute(expenseTableModel);
        if (budgetInteractor != null)
            budgetInteractor.execute(budgetTableModel);

    }


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
        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        expenseTableModel = new DefaultTableModel(columnNames, 0);

        expenseTable = new JTable(expenseTableModel);
        JScrollPane tableScrollPane = new JScrollPane(expenseTable);
        TitledBorder tableTitle = BorderFactory.createTitledBorder("Expense History");
        tableScrollPane.setBorder(tableTitle);
        expenseTable.setFillsViewportHeight(true);
        expenseTable.setVisible(true);
        expenseTablePanel = new JPanel();
        expenseTablePanel.add(tableScrollPane);
        expenseTablePanel.setSize(300, 400);
        expenseTablePanel.setVisible(true);
    }
    public void setupBudgetTable() {
        String[] columnNames = {"Category", "Amount"};
        budgetTableModel = new DefaultTableModel(columnNames, 0);

        budgetTable = new JTable(budgetTableModel);
        JScrollPane tableScrollPane = new JScrollPane(budgetTable);
        TitledBorder tableTitle = BorderFactory.createTitledBorder("Budget List");
        tableScrollPane.setBorder(tableTitle);
        budgetTable.setFillsViewportHeight(true);
        budgetTable.setVisible(true);
        budgetTablePanel = new JPanel();
        budgetTablePanel.add(tableScrollPane);
        budgetTablePanel.setSize(300, 400);
        budgetTablePanel.setVisible(true);
    }

//    public void setUserData(UserData userData) {
//        this.userData = userData;
//        populateBudgetTable();
//        populateExpensesTable();
//    }
//
//    public void populateBudgetTable() {
//        BudgetHistory budgetData = userData.getBudgets().getAllBudgets();
//        JPanel budgetPane = new JPanel();
//
//        String[] budgetColumnNames = {"Category", "Amount"};
//        budgetTableModel = new DefaultTableModel(budgetColumnNames, 0);
//
//        for (Budget budget : budgetData.getList()) {
//            budgetTableModel.addRow(new String[]{budget.getCategoryName(), String.valueOf(budget.getAmount())});
//            // System.out.println("user data not null");
//
//
//            budgetHistoryTable = new JTable(budgetTableModel);
//            JScrollPane tableScrollPane = new JScrollPane(budgetHistoryTable);
//            budgetHistoryTable.setFillsViewportHeight(true);
//            budgetHistoryTable.setVisible(true);
//            JPanel tablePanel = new JPanel();
//            tablePanel.add(tableScrollPane);
//            tablePanel.setSize(300, 400);
//            tablePanel.setVisible(true);
//            budgetPane.add(tablePanel);
//
//            // refreshes the component! instead of using .add() which would incorrectly put the table at the bottom of UI.
//            this.panel.setComponentZOrder(budgetPane, 0);
//        }
//    }
//
//
//    public void populateExpensesTable() {
//        TransactionHistory expensesData = userData.getHistory().getAllExpenses();
//        JPanel expensesPane = new JPanel();
//
//        String[] expensesColumnNames = {"Name", "Amount", "Date", "Category"};
//        expenseTableModel = new DefaultTableModel(expensesColumnNames, 0);
//
//        for (Transaction transaction : expensesData.getHistory()) {
//            expenseTableModel.addRow(new String[]{transaction.getName(), String.valueOf(transaction.getAmount()),
//                    transaction.getDate().toString(), transaction.getCategory()});
//            // System.out.println("user data not null");
//        }
//
//        expenseTable = new JTable(expenseTableModel);
//        JScrollPane tableScrollPane = new JScrollPane(expenseTable);
//        expenseTable.setFillsViewportHeight(true);
//        expenseTable.setVisible(true);
//        JPanel tablePanel = new JPanel();
//        tablePanel.add(tableScrollPane);
//        tablePanel.setSize(300, 400);
//        tablePanel.setVisible(true);
//        expensesPane.add(tablePanel);
//
//        // refreshes the component! instead of using .add() which would incorrectly put the table at the bottom of UI.
//        this.panel.setComponentZOrder(expensesPane, 0);
//    }
}


