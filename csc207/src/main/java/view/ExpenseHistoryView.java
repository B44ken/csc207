package view;


import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Transaction;
import entity.TransactionHistory;
import use_case.ExpenseHistoryController;
import view.ViewSwitcher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for ExpenseHistoryView, Includes Title, expenseHistory, addExpense, CHARTAPI, home buttons.
 */
public class ExpenseHistoryView extends JPanel implements ActionListener {
    private final String viewName = "expense history";
    private JPanel panel;
    private ViewSwitcher viewSwitcher;

    private final JButton addExpense;
    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton goalsButton;

    private UserData userData;

    private JTable expenseTable;
    private DefaultTableModel expenseTableModel;
    private JPanel expenseTablePanel;

    private ExpenseHistoryController interactor;

    private JPanel budgetTablePanel;
    private JTable budgetTable;
    private DefaultTableModel budgetTableModel;

    //private IncomeHistoryController interactor;

    public ExpenseHistoryView(ExpenseHistoryController interactor) {
        //this.interactor = interactor;

        final JLabel title = new JLabel("Expense History");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        this.panel = new JPanel();

        JPanel addExpenseButton = new JPanel();
        addExpense = new JButton("Add Expense");
        addExpenseButton.add(addExpense);

        addExpense.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewSwitcher.switchTo(ViewNames.addExpense);
            }
        });
      
        JPanel addBudgetButton = new JPanel();
        JButton addBudget = new JButton("Add Budget");
        addBudgetButton.add(addBudget);

        final JPanel buttons = new JPanel();
        homeButton = new JButton("Home");
        buttons.add(homeButton);
        incomeButton = new JButton("Income");
        buttons.add(incomeButton);
        goalsButton = new JButton("Goal");
        buttons.add(goalsButton);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        incomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewSwitcher.switchTo(ViewNames.incomeHistory);
            }
        });

        goalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewSwitcher.switchTo(ViewNames.goalList);
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(panel);

        /*
        setupExpenseTable();
        setupBudgetTable();
        add(expenseTablePanel);
        add(budgetTablePanel);
        */

        this.add(addExpenseButton);
        //add(bottomButtons, BorderLayout.AFTER_LAST_LINE);
        this.add(buttons, BorderLayout.AFTER_LAST_LINE);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click"  + evt.getActionCommand());}

    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void repaint() {
        if(interactor != null)
            interactor.execute(expenseTableModel, budgetTableModel);
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
        setupExpenseTable();
    }

    /*
    public void repaint() {
        if (interactor != null)
            interactor.execute(expenseTableModel);
    }
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
        TransactionHistory data = userData.getHistory().getAllExpenses();
        JPanel pane = new JPanel();

        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        expenseTableModel = new DefaultTableModel(columnNames, 0);

        for (Transaction transaction : data.getHistory()) {
            expenseTableModel.addRow(new String[]{transaction.getName(), String.valueOf(transaction.getAmount()),
            transaction.getDate().toString(), transaction.getCategory()});
        }

        expenseTable = new JTable(expenseTableModel);
        JScrollPane tableScrollPane = new JScrollPane(expenseTable);
        expenseTable.setFillsViewportHeight(true);
        expenseTable.setVisible(true);
        expenseTablePanel = new JPanel();
        expenseTablePanel.add(tableScrollPane);
        expenseTablePanel.setSize(300, 400);
        expenseTablePanel.setVisible(true);
        pane.add(expenseTablePanel);

        // refreshes the component instead of using .add() which would incorrectly put the table at the bottom of UI
        this.panel.setComponentZOrder(pane, 0);
    }
    public void setupBudgetTable() {
      String[] columnNames = { "Category", "Amount" };
        budgetTableModel = new DefaultTableModel(columnNames, 0);

        expenseTable = new JTable(budgetTableModel);
        JScrollPane tableScrollPane = new JScrollPane(budgetTable);
        budgetTable.setFillsViewportHeight(true);
        budgetTable.setVisible(true);
        budgetTablePanel = new JPanel();
        budgetTablePanel.add(tableScrollPane);
        budgetTablePanel.setSize(300, 400);
        budgetTablePanel.setVisible(true);
    }

}
