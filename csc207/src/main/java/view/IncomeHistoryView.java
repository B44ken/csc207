package view;

import com.labrats.app.ViewNames;
import data_access.ChartImageFactory;
import data_access.UserData;
import entity.Transaction;
import entity.TransactionHistory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


/**
 * Class for IncomeHistoryView. Includes Title, incomeHistory, addIncome, CHARTAPI, home buttons.
 */

public class IncomeHistoryView extends JPanel implements ActionListener {
    private final String viewName = "income history";
    private DefaultTableModel tableModel;
    private JTable incomeHistoryTable;
    private JPanel panel;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;

    private UserData userData;

    // should we also remove the setViewSwitcher method then? if we are just going to pass the vs into the class
    public IncomeHistoryView(ViewSwitcher vs) {
        viewSwitcher = vs;

        final JLabel title = new JLabel("Income History");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        //Add chart API here!

        this.panel = new JPanel();

         var addIncomeButton = new JButton(ViewNames.addIncome);
         viewSwitcher.listenForButton(addIncomeButton, ViewNames.addIncome);

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

        this.add(title);
        this.add(panel);
        // this.add(ChartAPI);
        this.add(addIncomeButton);
        this.add(buttons, BorderLayout.AFTER_LAST_LINE);
    }


    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}


    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
        populateTable();
    }

    /**
     * Populates table when .addUserData() is run in App.
     */
    public void populateTable() {
        TransactionHistory data = userData.getHistory().getAllIncomes();
        JPanel pane = new JPanel();

        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        tableModel = new DefaultTableModel(columnNames, 0);

        for (Transaction transaction : data.getHistory()) {
            tableModel.addRow(new String[]{transaction.getName(), String.valueOf(transaction.getAmount()),
                    transaction.getDate().toString(), transaction.getCategory()});
        }

        incomeHistoryTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(incomeHistoryTable);
        incomeHistoryTable.setFillsViewportHeight(true);
        incomeHistoryTable.setVisible(true);
        JPanel tablePanel = new JPanel();
        tablePanel.add(tableScrollPane);
        tablePanel.setSize(300, 400);
        tablePanel.setVisible(true);
        pane.add(tablePanel);
        ChartImageFactory chart = new ChartImageFactory(userData.getHistory());
        chart.createIncomeImage(LocalDate.of(2024, 1,1),LocalDate.now());

        // refreshes the component! instead of using .add() which would incorrectly put the table at the bottom of UI.
        this.panel.setComponentZOrder(pane, 0);
    }

}
